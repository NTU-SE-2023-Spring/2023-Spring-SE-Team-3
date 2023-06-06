import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
            ArrayList<String> Acarr = A.criterion.criteria.get(i);
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
        
        
    }
    public void findStrength(String AID,String SID,String rs){
        this.setRankingStrategy(rs);
       

    }
    public void findWeakness(String AID,String SID,String rs){

    }
    
    private Assignment findAssignment(String AID){
        for (int i=0;i<assignments.size();i++){
            if (assignments.get(i).name==AID){
                return assignments.get(i);
            }
        }
        return null;
    }
}
