public abstract class Person {
    public String name;
    public Person(String n){
        name=n;
    }
    public abstract double getWeight();
    public abstract double getHeight();
    public abstract String getJob();
}