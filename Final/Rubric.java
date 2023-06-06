import java.util.ArrayList;
import java.io.*;
public class Rubric {
    public ArrayList<ArrayList<String>> rubricData;
    public ArrayList<String> criteria;
    // public String filename;
    Rubric (ArrayList<ArrayList<String>> rubricData, ArrayList<String> criteria){
        this.rubricData = rubricData;
        this.criteria = criteria;
    }
    public static class RubricBuilder {
        public ArrayList<ArrayList<String>> rubricData = new ArrayList<>(new ArrayList<>());
        public ArrayList<String> criteria = new ArrayList<>();
        public String filename;
        public RubricBuilder setFilename(String name){
            this.filename = name;
            return this;
        }
        public RubricBuilder setRubric(){
            BufferedReader fileReader = null;
            try {
                fileReader = new BufferedReader(new FileReader(this.filename));
            } catch (FileNotFoundException ex) {
                System.out.println("Error");
                // System.exit(1);
            }
            // CommandReader cmdrd = new CommandReader();
            String line;
            String criteriaName = null;
            try {
                while ((line = fileReader.readLine()) != null){
                    ArrayList<String> tmp = new ArrayList<>();
                    String[] sl = line.split("\t");
                    for(int i=0;i<sl.length;i++){
                        // if(i>=3){
                        //     System.out.println("Error: invalid rubric");
                        // }
                        tmp.add(sl[i]);
                        if(!sl[0].equals(criteriaName)){
                            criteriaName = sl[0];
                            this.criteria.add(criteriaName);
                        }
                    }
                    this.rubricData.add(tmp);
                }
            } catch (IOException ex) {
                System.exit(0);
            }
            return this;
        }

        public Rubric build(){
            return new Rubric(this.rubricData, this.criteria);
        }
    }
}