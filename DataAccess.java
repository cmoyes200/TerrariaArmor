import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataAccess {

    public void load() {
        try {
            File file = new File("config.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String[] stats;

            String line = in.readLine();
            while (line != null) {
                String linearray[] = line.split("=", 2);
                line = linearray[line.length()-1];
                System.out.println(line);
                stats = line.split(",", 0);
            }
        }

        catch (IOException ioe) {
            System.out.println("Unable to read from file: " + ioe.getMessage());
        }
    }
}
