import java.util.ArrayList;

public class Request {
    ArrayList<Person> persons;
    private int counter;
    public Request(ArrayList<Person> persons){
        this.persons=persons;
    }
    public String Job(String j){
        for (Person p : persons){
            if (p.name.equals(j)){
                return p.getJob();
            }
        }
        return "Unknown";
    }

    public int WeightSum(ArrayList<String> names) {
        double sum = 0;
        counter=0;
        for (Person p : persons) {
            if (names.contains(p.name)) {
                sum = sum + p.getWeight();
                if (p.getWeight()!=0){
                    counter = counter + 1;
                }
            }
        }
        return Math.toIntExact(Math.round(sum));
    }

    public double HeightSum(ArrayList<String> names) {
        double sum = 0;
        counter=0;
        for (Person p : persons) {
            if (names.contains(p.name)) {
                sum = sum + p.getHeight();
                if (p.getHeight()!=0){
                    counter = counter + 1;
                }
            }
        }
        return Math.toIntExact(Math.round(sum));
    }

    public int WeightAverage(ArrayList<String> names) {
        double sum = WeightSum(names);
        return Math.toIntExact(Math.round(sum/names.size())) ;
    }

    public int HeightAverage(ArrayList<String> names) {
        double sum = HeightSum(names);
        return Math.toIntExact(Math.round(sum/names.size())) ;
    }
}
