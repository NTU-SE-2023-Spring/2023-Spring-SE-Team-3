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
        
        boolean res = reviewer.reviewAssignment(criterion.criteria.size(), filename, score);
        if(res){
            String r = String.format("%s-%s was reviewed by %s. Level:", this.ID, student.ID, reviewer.ID);
            System.out.print(r);
            for(int i=0;i<score.reviews.get(reviewer).size();i++){
                System.out.print(" "+ score.reviews.get(reviewer).get(i));
            }
            System.out.print("\n");
        } else {
            System.out.println("Error: invalid scoreFile");
        }
        
    }

    public void createRubric(String filename){
        Rubric.RubricBuilder rubricBuilder = new Rubric.RubricBuilder();
        this.criterion = rubricBuilder.setFilename(filename).setRubric().build();
    }

    public Score getScore(Student student){
        return studentScores.get(student);
    }
 
}
