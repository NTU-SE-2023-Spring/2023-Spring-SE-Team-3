import java.util.ArrayList;
public class Writer {
    public ArrayList<Component> components = new ArrayList<>();
    private ArrayList<ArrayList<Component>> groupStack = new ArrayList<>();
    private int stackptr=-1;
    public Writer(){
        
    }
    public boolean parseCommand(String s){
        String[] sl = s.split("<");
        boolean r = false;
        for (int i=0;i<sl.length;i++){
            String si = (sl[i]).trim();
            if (!si.equals("")){
                // System.out.println(si);
                switch (si) {
                    case "?xml version=\"1.0\"?>":
                        r=true;
                        break;
                    case "Question>":
                        r=true;
                        break;
                    case "/Question>":
                        printComponent();
                        r=true;
                        break;
                    default:
                        if (si.contains(">")){
                            r=addComponent(si);
                            if (!r) {
                                return false;
                            }
                        } else {
                            continue;
                        }   
                        break;
                }
            } else {
                continue;
            } 
        }
        return r;
    }
    public boolean addComponent(String s){
        String sl = s.trim();
        if (stackptr<0){
            switch (sl) {
                case "Line/>":
                    components.add(new Line());
                    break;
                case "Rectangle/>":
                    components.add(new Rectangle());
                    break;
                case "Text/>":
                    components.add(new Text());
                    break;
                case "Group/>":
                    components.add(new Group(new ArrayList<>()));
                    break;
                case "Group>":
                    stackptr+=1;
                    groupStack.add(new ArrayList<Component>());
                    break;
                default:
                    return false;
            }
        } else {
            ArrayList<Component> a = groupStack.get(stackptr);
            switch (sl) {
                case "Line/>":
                    a.add(new Line());
                    break;
                case "Rectangle/>":
                    a.add(new Rectangle());
                    break;
                case "Text/>":
                    a.add(new Text());
                    break;
                case "Group/>":
                    a.add(new Group(new ArrayList<>()));
                    break;
                case "Group>":
                    stackptr+=1;
                    groupStack.add(new ArrayList<Component>());
                    break;
                case "/Group>":
                    if (stackptr>0){
                        ArrayList<Component> b = groupStack.get(stackptr-1);
                        b.add(new Group(a));
                    } else if (stackptr==0) {
                        components.add(new Group(a));
                    } else {
                        return false;
                    }
                    groupStack.remove(stackptr);
                    stackptr-=1;
                    break;
                default:
                    return false;
            }
        } 
        return true;
    }
    public void printComponent(){
        for (int i=0;i<components.size();i++){
            System.out.println(components.get(i).getComponent());  
        }
    }
}
