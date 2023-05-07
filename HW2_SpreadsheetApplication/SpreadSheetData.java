import java.util.ArrayList;

public class SpreadSheetData {

    private String name;
    private int value;

    public SpreadSheetData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
