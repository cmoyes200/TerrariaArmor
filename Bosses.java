import java.util.ArrayList;
import java.util.Arrays;

public class Bosses {

    ArrayList<ArrayList<String>> stats = new ArrayList<>();

    public Bosses() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("kingslime", "eyeofcthulhu",
                "eaterofworlds", "brainofcthulhu", "queenbee", "skeletron", "wallofflesh"));

        for (int i=0; i<names.size(); i++) {
            ArrayList<String> temp = new ArrayList(Arrays.asList(names.get(i)));
            stats.add(temp);
        }
    }

    public void add(int index, ArrayList<String> values) {
        stats.add(index, values);
    }


    public ArrayList<ArrayList<String>> getStats() {
        return stats;
    }
}
