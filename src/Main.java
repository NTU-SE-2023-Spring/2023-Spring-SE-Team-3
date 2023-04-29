import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static ArrayList<Person> persons;
    
    public static void main(String[] args) {
        persons=new ArrayList<Person>();
        try {
            File fd = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(fd));
            String line;
            Request req = new Request(persons);
            while ((line=reader.readLine()) != null){
                String[] parts = line.split(" ");
                ArrayList<String> arr;
                switch (parts[0]) {
                    case "Person":
                        persons.add(personFactory(parts));
                        break;
                    case "Job":
                        System.out.println(req.Job(parts[1]));
                        break;
                    case "WeightAverage": 
                        arr = new ArrayList<String>();
                        arr.addAll(Arrays.asList(parts));
                        arr.remove(0);
                        System.out.println(req.WeightAverage(arr));
                        break;
                    case "HeightAverage":
                        arr = new ArrayList<String>();
                        arr.addAll(Arrays.asList(parts));
                        arr.remove(0);
                        System.out.println(req.HeightAverage(arr));
                        break;
                    case "WeightSum":
                        arr = new ArrayList<String>();
                        arr.addAll(Arrays.asList(parts));
                        arr.remove(0);
                        System.out.println(req.WeightSum(arr));
                        break;
                    case "HeightSum":
                        arr = new ArrayList<String>();
                        arr.addAll(Arrays.asList(parts));
                        arr.remove(0);
                        System.out.println(req.HeightSum(arr));
                        break;
                };
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Input Error");
            System.exit(0);
        }
    }

    public static Person personFactory(String[] line){
        ArrayList<String> arr = new ArrayList<String>();
        arr.addAll(Arrays.asList(line));
        String job="Unknown";
        double w=-1, h=-1;
        for (int i=1;i<arr.size();i++){
            try {
                double d = Double.parseDouble(arr.get(i));
                if (i==3){
                    w=d;
                } else if (i==4){
                    h=d;
                }
            }catch (NumberFormatException e) {
                if (i==2){
                    job=arr.get(i);
                }else if (i>2){
                    return new PersonNull(line[1]);
                }
            }  
        }
        if (w<=0 || h<=0){
            return new PersonNull(line[1]);
        }
        return new PersonReal(line[1], job, w, h);
    }
}