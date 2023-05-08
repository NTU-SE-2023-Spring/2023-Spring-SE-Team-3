import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) throws IOException {
        File fakeDataFile = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
        String line;
        FileViewer fileViewer = new FileViewer();

        while ((line = reader.readLine()) != null){
            String command = line.split(" ")[1];
            if (command.equals("add")){
                String[] elements = line.split(" ");


                for (int i = 2; i < elements.length; i++){
                    fileViewer.addElementByViewName(line.split(" ")[0], line.split(" ")[i]);
                }


            }else if (command.equals("display")){
                fileViewer.display(line.split(" ")[0]);
            }else{
                String name = line.split(" ")[0];
                String text = line.split(" ")[1];
                fileViewer.addView(name, text);
            }

        }

    }

}
