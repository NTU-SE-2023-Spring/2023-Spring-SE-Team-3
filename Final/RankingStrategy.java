import java.util.ArrayList;
import java.util.Map;
public interface RankingStrategy {
    public ArrayList<Double> rank(Score s,Map<String,Double> schoolStrategy);
}
