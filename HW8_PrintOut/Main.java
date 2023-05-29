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
        Map<String, SkipList> stringSkipListMap = new HashMap<>();
        Map<String, String>  nameMapType = new HashMap<>();


        while ((line = reader.readLine()) != null){
            String command = line.split(" ")[0];
            if (command.equals("Create")){
                String name = line.split(" ")[1];
                String type = line.split(" ")[2];
                if (type.equals("List")){
                    stringListMap.put(name, new List());
                    nameMapType.put(name, "List");
                }else if (type.equals("SkipList")){
                    stringSkipListMap.put(name, new SkipList());
                    nameMapType.put(name, "SkipList");
                }


            }else if (command.equals("Add")){

                String name = line.split(" ")[1];
                String val = line.split(" ")[2];
                if (nameMapType.get(name).equals("List")){
                    stringListMap.get(name).addItem(val);
                }else if (nameMapType.get(name).equals("SkipList")){
                    stringSkipListMap.get(name).addItem(val);
                }


            }else if (command.equals("Length")){
                String name = line.split(" ")[1];
                if (nameMapType.get(name).equals("List")){
                    stringListMap.get(name).getLength();
                }else if (nameMapType.get(name).equals("SkipList")){
                    System.out.println("SkipList can not access length");
                }


            }else if (command.equals("Size")){
                String name = line.split(" ")[1];
                if (nameMapType.get(name).equals("List")){
                    System.out.println("List do not have method size");
                }else if (nameMapType.get(name).equals("SkipList")){
                    stringSkipListMap.get(name).size();
                }


            }else if (command.equals("Get")){
                String name = line.split(" ")[1];
                int index = Integer.parseInt(line.split(" ")[2]);
                if (nameMapType.get(name).equals("List")){
                    stringListMap.get(name).get(index);
                }else if (nameMapType.get(name).equals("SkipList")){
                    System.out.println("SkipList do not have method get");
                }



            }else if (command.equals("GetNode")){
                String name = line.split(" ")[1];
                int index = Integer.parseInt(line.split(" ")[2]);
                if (nameMapType.get(name).equals("List")){
                    System.out.println("List do not have method getNode");
                }else if (nameMapType.get(name).equals("SkipList")){
                    stringSkipListMap.get(name).getNode(index);
                }


            }else if (command.equals("PrintOutList")){
                String name = line.split(" ")[1];
                if (nameMapType.get(name).equals("List")){
                    List l = stringListMap.get(name);
                    l.resetPos();
                    while(l.hasNext()){
                        String s = (String )l.next();
                        System.out.println(s);
                    }

                }else if (nameMapType.get(name).equals("SkipList")){
                    SkipList l = stringSkipListMap.get(name);
                    l.resetPos();
                    while(l.hasNext()){
                        String s = ((SkipNode)l.next()).value;
                        System.out.println("SkipNode:" + s);
                    }
                }

            }


        }

    }

}