import java.util.Map;
import java.util.HashMap;
public class Assignment {
    public String ID;

    private Map<Student,Score> studentScores = new HashMap<Student,Score>();
    public Rubric criterion;
    public double average; 
    Assignment(String id, String rubricFile){
        this.ID = id;
        createRubric(rubricFile);
    }
    public void reviewAssignment(Student student, Student reviewer, String filename){
        
        Score score;
        if(studentScores.get(student)==null){
            score = new Score();
            studentScores.put(student, score);
        }

        score = studentScores.get(student);
        
        reviewer.reviewAssignment(criterion.criteria.size(), filename, score);
        
    }

    public void createRubric(String filename){
        Rubric.RubricBuilder rubricBuilder = new Rubric.RubricBuilder();
        this.criterion = rubricBuilder.setFilename(filename).setRubric().build();
    }
 
}
