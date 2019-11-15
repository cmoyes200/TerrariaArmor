import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class DataAccess {

    public void DataAccess() {
        try {
            File file = new File("config.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
        }

        catch (IOException ioe) {
            System.out.println("Unable to read from file: " + ioe.getMessage());
        }
    }
}
