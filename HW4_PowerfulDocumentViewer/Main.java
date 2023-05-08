import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
public class Main {
    static ArrayList<Document> Docs;
    public static void main(String[] args) {
        try {
            File fakeDataFile = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
            String line;
            Docs = new ArrayList<Document>();
            while ((line = reader.readLine()) != null){
                String[] words = line.split(" ");
                if (words[0].equals("Present")){
                    present();
                }else{
                    createNewDocument(words[0]);
                }
            } 
            reader.close();
        } catch (Exception e) {
            System.out.println("InputError");
            System.out.println(e.getMessage());
        }
    }
    public static void createNewDocument(String typ){
        switch (typ) {
            case "Draw":
                DrawDocument d = new DrawDocument();
                Docs.add(d);
            break;
            case "Text":
                TextDocument t = new TextDocument();
                Docs.add(t);
            break;
            default:
                System.out.println("InputError");
            break;
        }
    }
    public static void present() {
        for (Document dc : Docs) {
            dc.present();
        }
    }
    public static void manageDocument(){
        // TODO: not required in SPEC.
    }
    
}