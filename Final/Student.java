import java.io.*;
import java.util.ArrayList;

public class Student {
    public String ID;
    Student(String id){
        this.ID=id;
    }
    
    public boolean reviewAssignment(int criteriaNum, String scoreFile, Score score){
        BufferedReader fileReader = null;
        boolean flag = true;
        try {
            fileReader = new BufferedReader(new FileReader(scoreFile));
        } catch (FileNotFoundException ex) {
            flag = false;
        }
        if(flag==false)
            return false;
        
        String line;
        ArrayList<String> scoreStrings = new ArrayList<>();
        try {
            for(int i=0;i<criteriaNum;i++){
                // TODO score invalid
                line = fileReader.readLine();
                scoreStrings.add(line);
            }
        } catch (IOException ex) {
            flag = false;
        }
        if(flag==false)
            return false;
        score.updateStudentScore(this, scoreStrings);

        return true;
    }
}
