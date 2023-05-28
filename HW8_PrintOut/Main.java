import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) throws IOException {
        File fakeDataFile = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
        String line;
        Map<String, List> stringListMap = new HashMap<>();


        while ((line = reader.readLine()) != null){
            String command = line.split(" ")[0];
            if (command.equals("Create")){
                String name = line.split(" ")[1];
                String type = line.split(" ")[2];
                if (type.equals("List")){
                    stringListMap.put(name, new List(name));
                }else if (type.equals("SkipList")){
                    stringListMap.put(name, new SkipList(name));
                }


            }else if (command.equals("Add")){
                String name = line.split(" ")[1];
                String val = line.split(" ")[2];
                stringListMap.get(name).addItem(val);

            }else if (command.equals("Length")){
                String name = line.split(" ")[1];
                stringListMap.get(name).getLength();

            }else if (command.equals("Size")){
                String name = line.split(" ")[1];
                stringListMap.get(name).size();

            }else if (command.equals("Get")){
                String name = line.split(" ")[1];
                int index = Integer.parseInt(line.split(" ")[2]);
                stringListMap.get(name).get(index);

            }else if (command.equals("GetNode")){
                String name = line.split(" ")[1];
                int index = Integer.parseInt(line.split(" ")[2]);
                stringListMap.get(name).getNode(index);

            }else if (command.equals("PrintOutList")){
                String name = line.split(" ")[1];
                stringListMap.get(name).printOut();

            }


        }

    }

}