import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    private ArrayList<HashMap<String, String>> RTFDoc;
    private LibrarySystem lib;
    public Reader(){
        this.lib= new LibrarySystem();
    }

    public void addDoc(String type, String tokens){
        HashMap<String,String> newMap = new HashMap<String,String>();
        newMap.put(type, tokens);
        this.RTFDoc.add(newMap);
    }
    public boolean parseBook(String s){

        return false;
    }
    public boolean parseUser(String s){

        return false;
    }
    public boolean parseCommand(String s){

        return false;
    }

            
    
}
