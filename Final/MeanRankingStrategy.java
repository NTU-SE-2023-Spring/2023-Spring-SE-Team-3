import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;
public class MeanRankingStrategy implements RankingStrategy{
    private static MeanRankingStrategy instance = new MeanRankingStrategy();
    private MeanRankingStrategy(){

    }
    public static MeanRankingStrategy getInstance(){
        return instance;
    }
    @Override
    public ArrayList<Double> rank(Score s, Map<String,Double> schoolStrategy) {
        // TODO Auto-generated method stub
        ArrayList<Double> resultScoreList = new ArrayList<>();
        Iterator<ArrayList<String>> itarrs = s.reviews.values().iterator();
        ArrayList<String> arr = itarrs.next();
        for (int i=0;i<arr.size();i++){
            resultScoreList.add(0.0);
        }
        for (Student rst: s.reviews.keySet()){
            ArrayList<String> Lvlarr = s.reviews.get(rst);
            for (int j=0;j<Lvlarr.size();j++){
                String lvlString = Lvlarr.get(j);
                Double dscore = schoolStrategy.get(lvlString);
                assert dscore != null;
                Double resultScore = resultScoreList.get(j);
                resultScore+=dscore/s.reviews.size();
                resultScoreList.set(j, resultScore);
            }          
        }
        return resultScoreList;
    }
}
