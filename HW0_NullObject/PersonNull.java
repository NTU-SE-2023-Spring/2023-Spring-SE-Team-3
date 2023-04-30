public class PersonNull extends Person{
    private String job;
    private double weight;
    private double height;
    public PersonNull(String n){
        super(n);
        job="Unknown";
        weight=0.0;
        height=0.0;
    }
    public double getWeight(){
        return weight;
    }

    public double getHeight(){
        return height;
    }
    
    public String getJob(){
        return job;
    }
}
