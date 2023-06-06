import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Score {
    public Map<Student, ArrayList<String>> reviews;
    // Student is a reviewer
    public void updateStudentScore(Student s, ArrayList<String> score){
        this.reviews.put(s, score);
    }
}
