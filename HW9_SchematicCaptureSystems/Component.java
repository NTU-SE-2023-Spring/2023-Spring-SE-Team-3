public abstract class Component {
    public String name;
    public Component(String n){
        this.name=n;
    }
    public String getComponent(){
        return this.name;
    }
    
}