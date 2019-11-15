import java.util.ArrayList;
import java.util.Arrays;

public class Bosses {

    public Bosses() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("kingslime", "eyeofcthulhu",
                "eaterofworlds", "brainofcthulhu", "queenbee", "skeletron", "wallofflesh"));

        ArrayList<ArrayList<String>> stats = new ArrayList<>();

        for (int i=0; i<names.size(); i++) {
            ArrayList<String> temp = new ArrayList(Arrays.asList(names.get(i)));
            stats.add(temp);
        }

        System.out.println(names);
        System.out.println(stats);

    }

}
