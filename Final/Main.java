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
            System.out.println("Error");
            System.exit(1);
        }
        CommandReader cmdrd = new CommandReader();
        String line;
        try {
            while ((line = fileReader.readLine()) != null){
                boolean pass = cmdrd.parseCommand(line);
                if (!pass){
                    System.out.println("Error");
                }
            }
        } catch (IOException ex) {
            System.exit(0);
        }

    }
    
}