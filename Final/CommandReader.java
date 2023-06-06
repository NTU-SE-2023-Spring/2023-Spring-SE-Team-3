import java.util.ArrayList;
public class CommandReader {
    public PeerReviewSystem prs = new PeerReviewSystem();
    public CommandReader(){
        
    }
    public boolean parseCommand(String s){
        String[] sl = s.split(" ");
        System.out.println(sl[0]);
        boolean res = false;
        try {
            switch (sl[0]) {
                case "student":
                    res = createStudent(sl);
                    break;
                case "schoolStrategy":
                    res = schoolStrategy(sl);
                    break;
                case "designCriterion":
                    break;
                default:
                    return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return res;
    }
    private boolean createStudent(String[] sl){
        if (sl.length <= 1) {
            return false;
        }
        for (int i=1;i<sl.length;i++){
            prs.students.add(new Student(sl[i]));
        }
        return true;
    }
    private boolean schoolStrategy(String[] sl){
        if(sl.length <= 1) {
            return false;
        }
        for (int i=1;i<sl.length;i++){
            try {
                String[] s = sl[i].split(",");
                prs.schoolStrategy.put(s[0] , Double.parseDouble(s[1]));
            } catch (IndexOutOfBoundsException e) {
                return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        // System.out.println(prs.schoolStrategy.toString());
        return true;
    }
}
