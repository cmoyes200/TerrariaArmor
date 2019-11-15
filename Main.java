import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static double defense;
    private static String boss;
    private static boolean finished = false;
    private Bosses bosses = new Bosses();
    private DataAccess data = new DataAccess();

    public static void main (String args[]) {
        Main main = new Main();
        main.start();
        main.addStats();
        main.menu();
    }


    public void addStats() {
        ArrayList<ArrayList<String>> stats = data.getAllStats();
        for (int i=0; i<stats.size(); i++) {
            bosses.getStats().get(i).add(data.getStatsstrings(i));
        }
    }

    public void start() {
        data.load();
    }

    public void menu() {
        while (finished !=true){
            System.out.println("Enter name of boss with no spaces e.g.'eyeofcthulhu': ");
            Scanner bossscanner = new Scanner(System.in);
            boss = bossscanner.nextLine();
            System.out.println("Enter defense value: ");
            defense = bossscanner.nextDouble();

            switch (boss) {
                case "kingslime":
                    kingSlime();
                    break;

                case "eyeofcthulhu":
                    eyeOfCthulhu();
                    break;

                case "eaterofworlds":
                    eaterOfWorlds();
                    break;

                case "brainofcthulhu":
                    brainOfCthulhu();
                    break;

                case "queenbee":
                    queenBee();
                    break;

                case "skeletron":
                    skeletron();
                    break;

                case "wallofflesh":
                    wallOfFlesh();
                    break;
            }

            System.out.println("Use this program again? (y/n)");
            Scanner input = new Scanner(System.in);
            String userinput = (input.nextLine()).toLowerCase();

            switch (userinput) {
                case "yes": case "y":
                    break;

                case "no": case"n":
                    finished = true;
            }
        }
    }

    public void kingSlime() {
        String stats = bosses.getStats().get(0).get(1);
        String[] statsarray = stats.split(",", 0);
        System.out.println("King Slime deals " + netDamage(Integer.parseInt(statsarray[0])) + " damage.");
        System.out.println("Spiked Blue Slime deals " + netDamage(Integer.parseInt(statsarray[1])) + " melee damage and "
                + netDamage(Integer.parseInt(statsarray[2])) + " ranged damage.");
        System.out.println("Normal Blue Slime deals " + netDamage(Integer.parseInt(statsarray[3])) + " damage.");
    }

    public void eyeOfCthulhu() {
        String stats = bosses.getStats().get(1).get(1);
        String[] statsarray = stats.split(",", 0);
        System.out.println("Eye of Cthulhu deals " + netDamage(Integer.parseInt(statsarray[0])) + " damage in phase 1.");
        System.out.println("Eye of Cthulhu deals " + netDamage(Integer.parseInt(statsarray[1])) +
                " damage in phase 2, and " + netDamage(Integer.parseInt(statsarray[2])) + " damage below 4% health");
    }

    public void eaterOfWorlds() {
        String stats = bosses.getStats().get(2).get(1);
        String[] statsarray = stats.split(",", 0);
        System.out.println("Eater of Worlds Head deals " + netDamage(Integer.parseInt(statsarray[0])) + " damage.");
        System.out.println("Eater of Worlds body deals " + netDamage(Integer.parseInt(statsarray[1])) + " damage.");
        System.out.println("Eater of Worlds Head deals " + netDamage(Integer.parseInt(statsarray[2])) + " damage.");
    }

    public void brainOfCthulhu() {
        String stats = bosses.getStats().get(3).get(1);
        String[] statsarray = stats.split(",", 0);
        System.out.println("Brain of Cthulhu deals " + netDamage(Integer.parseInt(statsarray[0])) + " damage.");
        System.out.println("Creepers deal " + netDamage(Integer.parseInt(statsarray[1])) + " damage.");
    }

    public void queenBee() {
        String stats = bosses.getStats().get(4).get(1);
        String[] statsarray = stats.split(",", 0);
        System.out.println("Queen Bee deals " + netDamage(Integer.parseInt(statsarray[0])) + " melee damage.");
        System.out.println("Queen Bee deals " + netDamage(Integer.parseInt(statsarray[1])) + " ranged damage.");
    }

    public void skeletron() {
        String stats = bosses.getStats().get(5).get(1);
        String[] statsarray = stats.split(",", 0);
        System.out.println("Skeletron head deals " + netDamage(Integer.parseInt(statsarray[0])) + " damage.");
        System.out.println("Skeletron limbs deal " + netDamage(Integer.parseInt(statsarray[1])) + " damage.");
    }

    public void wallOfFlesh() {
        String stats = bosses.getStats().get(6).get(1);
        String[] statsarray = stats.split(",", 0);
        System.out.println("Wall of Flesh deals " + netDamage(Integer.parseInt(statsarray[0])) + " melee damage.");
        System.out.println("Wall of Flesh deals " + netDamage(Integer.parseInt(statsarray[1])) + "-"
                + netDamage(Integer.parseInt(statsarray[2])) + " ranged damage, variable by remaining health.");
        System.out.println("The Hungry deal " + netDamage(Integer.parseInt(statsarray[3]))
                + "-" + netDamage(Integer.parseInt(statsarray[4])) + " melee damage, variable by remaining health.");
    }

    public int netDamage (double damage) {
        double doubledamage = Math.floor(damage-(defense*0.75));

        if (doubledamage < 1) {
            doubledamage = 1;
        }

        int netdamage = (int) doubledamage;
        return netdamage;
    }
}
