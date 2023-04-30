import java.util.Vector;

public class Composition {
    private Vector<Component> components;


    public  Composition(){
        this.components = new Vector<Component> (0,1);
    }
    public void addComponent(Component component){
        components.add(component);
    }

    public Vector<Component> getComponentsByInputOrder() {
        return components;
    }

    public void changeSizeByComponentId(int id, int newSize){
        for(int i = 0; i < components.size(); i++){
            if(components.get(i).getId() == id){
                components.get(i).setNaturalSize(newSize);
            }
        }


    }

    public void requireNewLayout(BreakStrategy strategy){

        strategy.arrangeComponents(this.getComponentsByInputOrder());
    }
}
