import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptContext;
public class PeerReviewSystem {
    public ArrayList<Assignment> assignments = new ArrayList<>();
    public Map<String,Double> schoolStrategy = new HashMap<String,Double>();
    public Map<String,Student> students = new HashMap<String,Student>();
    public int minReviewers;
    public int maxReviewers;
    public RankingStrategy rankingStrategy;

    public boolean setRankingStrategy(String rs){
        if (rs=="MeanRankingStrategy"){
            this.rankingStrategy=MeanRankingStrategy.getInstance();
        } else if (rs=="MedianRankingStrategy"){
            this.rankingStrategy=MedianRankingStrategy.getInstance();
        } else {
            System.out.println("Error: setRankingStrategy: No such strategy");
            return false;
        }
        return true;
    }
    public void printRubric(String AID){
        Assignment A = findAssignment(AID);
        if (A==null){
            System.out.println("Error: printRubric: assignment not found"); 
            return;
        }
        for (int i=0;i<A.criterion.criteria.size();i++){
            ArrayList<String> Acarr = A.criterion.rubricData.get(i);
            String res = "("+Acarr.get(0)+","+Acarr.get(1)+") "+Acarr.get(2);
            System.out.println(res);
        }
    }
    public void averageCriterion(String assignmentID){
        Assignment A = findAssignment(assignmentID);
        if (A==null){
            System.out.println("Error: averageCriterion: assignment not found"); 
            return;
        }
    }
    public void calculateScore(String AID,String SID,String rs){
        boolean setRsCorrect = this.setRankingStrategy(rs);
        if (!setRsCorrect){
            return;
        }
        Student st = students.get(SID);
        if (st==null){
            System.out.println("Error: calculateScore: No such student");
            return;
        }
        Assignment A = findAssignment(AID);
        if (A==null){
            System.out.println("Error: calculateScore: assignment not found");
            return;
        }
        Score s = A.getScore(st);
        if (s==null){
            System.out.println("Error: calculateScore: student do not have this score");
            return;
        }
        ArrayList<Double> score = this.rankingStrategy.rank(s,schoolStrategy);
        Double d = 0.0;
        for (Double ds: score){
            d+=ds;
        }
        d = d/score.size();
        Double rd = Math.round(d*10.0)/10.0;
        String returningString = "Assignment: "+A.ID+", Student: "+st.ID+", Score: "+rd.toString();
        System.out.println(returningString);
        
    }
    public void findStrength(String AID,String SID,String rs){
        boolean setRsCorrect = this.setRankingStrategy(rs);
        if (!setRsCorrect){
            return;
        }
        Student st = students.get(SID);
        if (st==null){
            System.out.println("Error: findStrength: No such student");
            return;
        }
        Assignment A = findAssignment(AID);
        if (A==null){
            System.out.println("Error: findStrength: assignment not found");
            return;
        }
        Score s = A.getScore(st);
        if (s==null){
            System.out.println("Error: findStrength: student do not have this score");
            return;
        }
        ArrayList<Double> score = this.rankingStrategy.rank(s,schoolStrategy);
        // int strengthIndex = -1;
        double strengthValue = -1;
        for (int i=0;i<A.criterion.criteria.size();i++){
            int result = Double.compare(score.get(i), strengthValue);
            if(result > 0){
                strengthValue = score.get(i);
            }
        }
        ArrayList<String> strength = new ArrayList<>();
        for (int i=0;i<A.criterion.criteria.size();i++){
            int result = Double.compare(score.get(i), strengthValue);
            if(result == 0){
                strength.add(A.criterion.criteria.get(i));
            }
        }
        String res = String.format("Assignment: %s, Student: %s, Strength:", AID, SID)
        System.out.print(res);
        for(int i=0;i<strength.size();i++){
            System.out.print(" "+ strength.get(i));
        }
        System.out.print("\n");
    }
    public void findWeakness(String AID,String SID,String rs){
        boolean setRsCorrect = this.setRankingStrategy(rs);
        if (!setRsCorrect){
            return;
        }
        Student st = students.get(SID);
        if (st==null){
            System.out.println("Error: findWeakness: No such student");
            return;
        }
        Assignment A = findAssignment(AID);
        if (A==null){
            System.out.println("Error: findWeakness: assignment not found");
            return;
        }
        Score s = A.getScore(st);
        if (s==null){
            System.out.println("Error: findWeakness: student do not have this score");
            return;
        }
        ArrayList<Double> score = this.rankingStrategy.rank(s,schoolStrategy);
        // int strengthIndex = -1;
        double weaknessValue = -1;
        for (int i=0;i<A.criterion.criteria.size();i++){
            int result = Double.compare(score.get(i), weaknessValue);
            if(result < 0){
                weaknessValue = score.get(i);
            }
        }
        ArrayList<String> weakness = new ArrayList<>();
        for (int i=0;i<A.criterion.criteria.size();i++){
            int result = Double.compare(score.get(i), weaknessValue);
            if(result == 0){
                weakness.add(A.criterion.criteria.get(i));
            }
        }
        String res = String.format("Assignment: %s, Student: %s, Weakness:", AID, SID)
        System.out.print(res);
        for(int i=0;i<weakness.size();i++){
            System.out.print(" "+ weakness.get(i));
        }
        System.out.print("\n");
    }
    public void assignment(String AID, String SID, ArrayList<String> reviewers){
        Student st = students.get(SID);
        if (st==null){
            System.out.println("Error: assignment: No such student");
            return;
        }
        Assignment A = findAssignment(AID);
        if (A==null){
            System.out.println("Error: assignment: assignment not found");
            return;
        }
        for (int i=0;i<reviewers.size();i++){
            String revfile = reviewers.get(i);
            String[] sl = revfile.split(",");
            try {
                Student reviewer = students.get(sl[0]);
                String filename = sl[1];
                if (reviewer==null){
                    System.out.println("Error: assignment: No such student");
                    return;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: assignment: ScoreFileName err");
            }
        }
        if (reviewers.size()<minReviewers || reviewers.size()>maxReviewers){
            System.out.println("Error: assignment: num of reviewers err");
        }
        for (int i=0;i<reviewers.size();i++){
            String revfile = reviewers.get(i);
            String[] sl = revfile.split(",");
            Student reviewer = students.get(sl[0]);
            A.reviewAssignment(st, reviewer, sl[1]);
        }
    }
    
    private Assignment findAssignment(String AID){
        for (int i=0;i<assignments.size();i++){
            if (assignments.get(i).ID==AID){
                return assignments.get(i);
            }
        }
        return null;
    }
}
