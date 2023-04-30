import java.util.ArrayList;

public class Spreadsheet implements Chart{
    @Override
    public void display(ArrayList<SpreadSheetData> data) {
        for(int i = 0; i < data.size(); i++){
            System.out.println("%s %d".formatted(data.get(i).getName(), data.get(i).getValue()));
        }
    }

    @Override
    public void changeItemValue(String item, int value, SpreadSheetApplication app) {
        System.out.println("%s change %s %d.".formatted(this.getClass().getName(), item, value));
        app.changeItemValue(item, value);
    }
}
