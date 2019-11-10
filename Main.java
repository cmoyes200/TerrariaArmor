import java.util.Scanner;

public class Main {

    private static double defense;
    private static String boss;
    private static boolean finished = false;

    public static void main (String args[]) {
        Main main = new Main();

        while (finished !=true){
            System.out.println("Enter name of boss with no spaces e.g.'eyeofcthulhu': ");
            Scanner bossscanner = new Scanner(System.in);
            boss = bossscanner.nextLine();
            System.out.println("Enter defense value: ");
            defense = bossscanner.nextDouble();

            switch (boss) {
                case "kingslime":
                    System.out.println("King Slime deals " + main.netDamage(64) + " damage.");
                    System.out.println("Spiked Blue Slime deals " + main.netDamage(28) + " melee damage and " + main.netDamage(36) + " ranged damage.");
                    System.out.println("Normal Blue Slime deals " + main.netDamage(14) + " damage.");
                    break;

                case "eyeofcthulhu":
                    System.out.println("Eye of Cthulhu deals " + main.netDamage(30) + " damage in phase 1.");
                    System.out.println("Eye of Cthulhu deals " + main.netDamage(36) + " damage in phase 2, and " + main.netDamage(40) + " damage below 4% health");
                    break;

                case "eaterofworlds":
                    System.out.println("Eater of Worlds Head deals " + main.netDamage(48) + " damage.");
                    System.out.println("Eater of Worlds body deals " + main.netDamage(20) + " damage.");
                    System.out.println("Eater of Worlds Head deals " + main.netDamage(17) + " damage.");
                    break;

                case "brainofcthulhu":
                    System.out.println("Brain of Cthulhu deals " + main.netDamage(54) + " damage.");
                    System.out.println("Creepers deal " + main.netDamage(54) + " damage.");
                    break;

                case "queenbee":
                    System.out.println("Queen Bee deals " + main.netDamage(54) + " melee damage.");
                    System.out.println("Queen Bee deals " + main.netDamage(44) + " ranged damage.");
                    break;

                case "skeletron":
                    System.out.println("Skeletron head deals " + main.netDamage(70) + " damage.");
                    System.out.println("Skeletron limbs deal " + main.netDamage(44) + " damage.");
                    break;

                case "wallofflesh":
                    System.out.println("Wall of Flesh deals " + main.netDamage(150) + " melee damage.");
                    System.out.println("Wall of Flesh deals " + main.netDamage(44) + "-" + +main.netDamage(60) + " ranged damage, variable by remaining health.");
                    System.out.println("The Hungry deal " + main.netDamage(60) + "-" + +main.netDamage(150) + " melee damage, variable by remaining health.");
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


    public int netDamage (double damage) {
        double doubledamage = Math.floor(damage-(defense*0.75));

        if (doubledamage < 1) {
            doubledamage = 1;
        }

        int netdamage = (int) doubledamage;
        return netdamage;
    }
}
