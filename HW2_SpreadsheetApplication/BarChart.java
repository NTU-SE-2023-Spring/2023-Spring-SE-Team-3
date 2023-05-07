import java.util.ArrayList;

public class BarChart implements Chart{
    @Override
    public void display(ArrayList<SpreadSheetData> data) {
        for(int i = 0; i < data.size(); i++) {
            System.out.println("%s %s".formatted("=".repeat(data.get(i).getValue()), data.get(i).getName()));
        }

    }

    @Override
    public void changeItemValue(String item, int value, SpreadSheetApplication app) {
        System.out.println("%s change %s %d.".formatted(this.getClass().getName(), item, value));
        app.changeItemValue(item, value);
    }
}
