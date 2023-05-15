import java.io.*;
import java.util.HashMap;

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

        Reader reader = new Reader();
        String type = "";
        String tokens = "";
        while (true) {
            try {
                type = fileReader.readLine();
                tokens = fileReader.readLine();
            } catch (IOException ex) {
                System.out.println("Input Error");
            }
            if(type == null){
                break;
            }
            reader.addDoc(type, tokens);
        }
        reader.convert();

    }
}