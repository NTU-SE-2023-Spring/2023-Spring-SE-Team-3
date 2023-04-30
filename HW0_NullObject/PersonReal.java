public class PersonReal extends Person{
    private String job;
    private double weight;
    private double height;
    public PersonReal(String n,String j,double w,double h) {
        super(n);
        this.job=j;
        this.height=h;
        this.weight=w;
    };

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
