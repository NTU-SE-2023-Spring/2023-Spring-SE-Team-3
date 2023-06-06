public class MeanRankingStrategy implements RankingStrategy{
    private static MeanRankingStrategy instance = new MeanRankingStrategy();
    private MeanRankingStrategy(){

    }
    public static MeanRankingStrategy getInstance(){
        return instance;
    }
    @Override
    public double rank(Score s) {
        // TODO Auto-generated method stub
        return 0;
    }
}
