import java.util.ArrayList;

public interface Chart {
    public void display(ArrayList<SpreadSheetData> data);
    public void changeItemValue(String item, int value, SpreadSheetApplication app);
}
