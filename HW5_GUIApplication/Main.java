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

        String input = "";
        GUIApplication guiApp = new GUIApplication();

        while (true) {
            try {
                input = fileReader.readLine();
            } catch (IOException ex) {
                System.out.println("Input Error");
            }
            if (input == null) {
                break;
            }
            String[] tmp = input.split(" ");

            if (tmp[0].equals("Present")) {
                guiApp.present();
            } else if (tmp[0].equals("Motif") || tmp[0].equals("PM")) {
                guiApp.switchStyle(tmp[0]);
            } else {
                guiApp.addWidget(tmp[0], tmp[1]);  // type, name
            }
        }
    }
}