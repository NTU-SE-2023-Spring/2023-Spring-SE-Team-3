import java.util.Map;
import java.util.HashMap;
public class Assignment {
    public String name;
    private Map<Student,Score> studentScores = new HashMap<Student,Score>();
    public Rubric criterion;
    public double average; 
    Assignment(){

    }
    public boolean reviewAssignment(){
    
    }
    public void updateAverage(){
        // TODO
    }

    public void createRubric(String filename){
        Rubric.RubricBuilder rubricBuilder = new Rubric.RubricBuilder();
        this.criterion = rubricBuilder.setFilename(filename).setRubric().build();
    }

    public Score getScore(Student student){
        return studentScores.get(student);
    }
 
}
