import java.io.*;

public class Main {

    public static void main(String[] args) {

        // read filename
        String fn = args[0];

        // read file
        File inputFile = new File(fn);
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException ex) {
            // insert code to run when exception occurs
            System.out.println("Input Error");
        }

        EmailHandler handler = new SpamHandler(new ComplaintHandler(new FanHandler(null)));
        String email_type = "";
        while (true) {
            try {
                email_type = fileReader.readLine();
            } catch (IOException ex) {
                System.out.println("Input Error");
            }
            if(email_type == null){
                break;
            }
            handler.handleRequest(new Email(email_type));
        }

    }
}