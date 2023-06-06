import java.util.ArrayList;
import java.util.Map;
public class MedianRankingStrategy implements RankingStrategy{
    private static MedianRankingStrategy instance = new MedianRankingStrategy();
    private MedianRankingStrategy(){

    }
    public static MedianRankingStrategy getInstance(){
        return instance;
    }
    @Override
    public ArrayList<Double> rank(Score s,Map<String,Double> schoolStrategy) {
        // TODO Auto-generated method stub
        return null;
    }
}
