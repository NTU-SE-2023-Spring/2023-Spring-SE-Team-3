import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        File fakeDataFile = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
        String line;
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getChocolateBoiler();

        while ((line = reader.readLine()) != null){
            chocolateBoiler.changeState(line);

        }

    }

}