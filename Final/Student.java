import java.io.*;
import java.util.ArrayList;

public class Student {
    public String ID;
    Student(String id){
        this.ID=id;
    }
    public void reviewAssignment(int criteriaNum, String scoreFile, Score score){
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(scoreFile));
        } catch (FileNotFoundException ex) {
            System.out.println("Error: invalid scoreFile");
            // System.exit(1);
        }
        String line;
        ArrayList<String> scoreStrings = new ArrayList<>();
        try {
            for(int i=0;i<criteriaNum;i++){
                // TODO score invalid
                line = fileReader.readLine();
                scoreStrings.add(line);
            }
        } catch (IOException ex) {
            System.exit(0);
        }
        score.updateStudentScore(this, scoreStrings);
    }
}
