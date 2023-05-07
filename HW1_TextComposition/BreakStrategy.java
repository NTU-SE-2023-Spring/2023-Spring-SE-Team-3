import java.util.Vector;

public interface BreakStrategy {
    public  void arrangeComponents(Vector<Component> components);
}

class SimpleCompositionStrategy implements BreakStrategy {
    public  void arrangeComponents(Vector<Component> components){
        for (Component component: components){
            System.out.println("[" + Integer.toString(component.getNaturalSize()) + "]" + component.getContent());
        }
    }
}


class TexCompositionStrategy implements BreakStrategy  {
    public  void arrangeComponents(Vector<Component> components){
        for (Component component: components){
            if (!component.getContent().equals("<ParagraphEnd>")){
                System.out.print("[" + Integer.toString(component.getNaturalSize()) + "]" + component.getContent() + " ");
            }else{
                System.out.print("[" + Integer.toString(component.getNaturalSize()) + "]" + component.getContent() + "\n");
            }
        }
    }
}

class ArrayCompositionStrategy  implements BreakStrategy {
    public  void arrangeComponents(Vector<Component> components){
        int count = 1;
        for (Component component: components){
            if ( count % 3 != 0){
                System.out.print("[" + Integer.toString(component.getNaturalSize()) + "]" + component.getContent());
                if (component.getId() == components.get(components.size() - 1).getId()){
                    // last one should not output space
                    System.out.print("\n");
                }else{
                    System.out.print(" ");
                }
            }else{
                System.out.println("[" + Integer.toString(component.getNaturalSize()) + "]" + component.getContent() );
            }
            count++;
        }
    }
}