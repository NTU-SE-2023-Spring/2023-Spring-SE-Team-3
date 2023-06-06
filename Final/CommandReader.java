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
                    res = designCriterion(sl);
                    break;
                case "assignment":
                    res = assignment(sl);
                    break;
                case "printRubric":
                    prs.printRubric(sl[1]);
                    res = true;
                    break;
                case "averageCriterion":
                    prs.averageCriterion(sl[1]);
                    res = true;break;
                case "calculateScore":
                    res = calculateScore(sl);
                    break;
                case "findStrength":
                    res = findStrength(sl);
                    break;
                case "findWeakness":
                    res = findWeakness(sl);
                    break;

                default:
                    return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return res;
    }
    private boolean assignment(String[] sl){
        return false;
    }
    private boolean findWeakness(String[] sl){
        return false;
    }
    private boolean findStrength(String[] sl){
        return false;
    }
    private boolean calculateScore(String[] sl){
        // prs.calculateScore(null, null, null);
        return false;
    }
    private boolean designCriterion(String[] sl){
        return false;
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
    private boolean createStudent(String[] sl){
        if (sl.length <= 1) {
            return false;
        }
        for (int i=1;i<sl.length;i++){
            prs.students.put(sl[i],new Student(sl[i]));
        }
        return true;
    }
}
