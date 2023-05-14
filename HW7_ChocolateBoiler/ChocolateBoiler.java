import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChocolateBoiler {

    private Map<String, Integer> stateMap = new HashMap<String ,Integer>();

    private int state;

    private ArrayList<String> steps = new ArrayList<String>();

    private static ChocolateBoiler instance;

    private ChocolateBoiler(){
        this.stateMap.put("Fill", 0);
        this.stateMap.put("Boil", 1);
        this.stateMap.put("Drain", 2);
        this.steps.add("Fill chocolate");
        this.steps.add("Boil chocolate");
        this.steps.add("Drain the boiled chocolate");
        this.state = -1;

    }
    public static ChocolateBoiler  getChocolateBoiler() {
        if(instance == null) {
            instance = new ChocolateBoiler ();
        }
        return instance;
    }
    public   void changeState(String s){
        if(this.stateMap.get(s) ==  (this.state + 1) % this.steps.size()){
            this.state = (this.state + 1) % this.steps.size();
            System.out.println(this.steps.get(this.state));

        }
    }


}
