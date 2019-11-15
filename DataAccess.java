import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataAccess {

    public void load() {
        try {
            File file = new File("C:\\Users\\Craig\\IdeaProjects\\TerrariaArmor\\src\\config.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line;
            while ((line = in.readLine()) != null) {
                ArrayList<String> linearray = new ArrayList<>(Arrays.asList(line.split("=", 2)));
                String statsstring = linearray.get(linearray.size()-1);
                System.out.println(statsstring);
                ArrayList<String> stats = new ArrayList<>(Arrays.asList(statsstring.split(",", 0)));
            }
        }

        catch (IOException ioe) {
            System.out.println("Unable to read from file: " + ioe.getMessage());
        }
    }
}
