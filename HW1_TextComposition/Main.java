import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        File fakeDataFile = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
        String line;
        CommandReader commandReader = null;
        Composition delegator = new Composition();
        while ((line = reader.readLine()) != null){
            String command = line.split(" ")[0];
            if (command.equals("Text")){
                commandReader = new TextCommandReader();

            }else if (command.equals("GraphicalElement")){
                commandReader = new GraphicalElementCommandReader();
            }else if (command.equals("ChangeSize")){
                commandReader = new ChangeSizeCommandReader();

            }else if (command.equals("Require")){
                commandReader = new RequireCommandReader();
            }
            commandReader.reader(line, delegator);
        }

    }

}
