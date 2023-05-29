import java.util.ArrayList;

public class Group extends Component{
    private ArrayList<Component> components;
    public Group(ArrayList<Component> c){
        super("Group");
        components=c;
    }
    public String getComponent(){
        String rs = "Group:{";
        for (int i=0;i<components.size();i++){
            Component c = components.get(i);
            rs += c.getComponent() + " ";
        }
        rs+="}";
        return rs;
    }
}
