import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
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

        ArrayList<Double> resultScoreList = new ArrayList<>();
        Iterator<ArrayList<String>> itarrs = s.reviews.values().iterator();
        ArrayList<String> arr = itarrs.next();
        // for (int i=0;i<arr.size();i++){
        //     resultScoreList.add(0.0);
        // }
        ArrayList<ArrayList<Double>> map = new ArrayList<>(new ArrayList<>());
        for (Student rst: s.reviews.keySet()){
            ArrayList<Double> tmp = new ArrayList<>();
            ArrayList<String> Lvlarr = s.reviews.get(rst);
            for (int j=0;j<Lvlarr.size();j++){
                String lvlString = Lvlarr.get(j);
                Double dscore = schoolStrategy.get(lvlString);
                assert dscore != null;
                tmp.add(dscore);
            }
            map.add(tmp);

        }
        for(int i = 0; i < map.get(0).size(); i++){
            ArrayList<Double> tmp = new ArrayList<>();
            for(int j = 0; j < map.size(); j++){
                tmp.add(map.get(j).get(i));
            }
            tmp.sort(Comparator.naturalOrder());
            if(tmp.size() % 2 == 0){
                resultScoreList.add((tmp.get(tmp.size()/2)+tmp.get(tmp.size()/2-1))/2.0);
            }else{
                resultScoreList.add(tmp.get(tmp.size()/2));
            }
        }
        return resultScoreList;
    }
}
