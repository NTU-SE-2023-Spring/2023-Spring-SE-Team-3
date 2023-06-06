public class MedianRankingStrategy implements RankingStrategy{
    private static MedianRankingStrategy instance = new MedianRankingStrategy();
    private MedianRankingStrategy(){

    }
    public static MedianRankingStrategy getInstance(){
        return instance;
    }
    @Override
    public double rank(Score s) {
        // TODO Auto-generated method stub
        return 0;
    }
}
