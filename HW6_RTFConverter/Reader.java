import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    private ArrayList<HashMap<String, String>> RTFDoc;

    public Reader(){
        this.RTFDoc = new ArrayList<HashMap<String, String>>();
    }

    public void addDoc(String type, String tokens){
        HashMap<String,String> newMap = new HashMap<String,String>();
        newMap.put(type, tokens);
        this.RTFDoc.add(newMap);
    }

    public void convert(){
        for (Map<String, String> entry : this.RTFDoc) {
            for (String key : entry.keySet()) {
                String tokens = entry.get(key);
                FormatConverter builder;
                if (key.equals("TeX")) {
                    builder = new TeXConverter();
                } else if (key.equals("TextWidget")) {
                    builder = new TextWidgetConverter();
                } else {
                    continue;
                }
                String converted_token = "";
                for (int i = 0; i < tokens.length(); i++) {
                    char t = tokens.charAt(i);;
                    switch(t) {
                        case 'C':
                            converted_token += builder.convertCharacter();
                            break;
                        case 'F':
                            converted_token += builder.convertFontChange();
                            break;
                        case 'P':
                            converted_token += builder.convertParagraph();
                            break;
                    }
                }
                System.out.println(converted_token);
            }
        }
    }
}
