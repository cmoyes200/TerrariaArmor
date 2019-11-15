import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataAccess {

    ArrayList<ArrayList<String>> statsarray = new ArrayList<>();
    ArrayList<String> statsstrings = new ArrayList<>();

    public void load() {
        try {
            File file = new File("config.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line;
            while ((line = in.readLine()) != null) {
                ArrayList<String> linearray = new ArrayList<>(Arrays.asList(line.split("=", 2)));
                String statsstring = linearray.get(linearray.size()-1);
                statsstrings.add(statsstring);
                ArrayList<String> stats = new ArrayList<>(Arrays.asList(statsstring.split(",", 0)));
                statsarray.add(stats);
            }
        }

        catch (IOException ioe) {
            System.out.println("Unable to read from file: " + ioe.getMessage());
        }
    }

    public ArrayList<ArrayList<String>> getAllStats() {
        return statsarray;
    }

    public ArrayList<String> getStats(int index) {
        return statsarray.get(index);
    }

    public String getStatsstrings(int i) {
        return statsstrings.get(i);
    }
}
