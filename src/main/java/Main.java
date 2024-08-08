import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(Path.of("List_Champions.csv"));
        sc.nextLine(); //přečte první řádek ale nic to s ním neudělá
        Champion[] champions = new Champion[145];
        int i = 0;
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] array = line.split(",");
            Champion champ = new Champion(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]));
            champions[i++] = champ;
        }
        System.out.println(Arrays.toString(champions));
        System.out.println(champions.length);
        Champion lux = getName(champions, "Lux");
        System.out.println(lux);
        List<String> allClasses = getClazz(champions);
        System.out.println("List of all classes: " + allClasses);
        List<String> siblings = getSiblings(champions, "Mage");
        System.out.println("List of all mages: " + siblings);
        System.out.println(siblings.size());
        double average = getAverageAttack(champions, "Mage");
        System.out.printf("Average attack of all Mages is %.2f", average);
    }
    public static Champion getName(Champion[] champions, String name) {
        for (Champion champ : champions) {
            if (champ.name.equals(name)) {
                return champ;
            }
        }
        return null;
    }
    public static List<String> getClazz(Champion[] champions) {
        List<String> clazzList = new ArrayList<>();
        for (Champion champ : champions) {
            if (clazzList.contains(champ.clazz)) {
                continue;
            }
            clazzList.add(champ.clazz);
        }
        return clazzList;
        }

    public static List<String> getSiblings(Champion[] champions, String clazz) {
        List<String> champList = new ArrayList<>();
        for (Champion champ : champions) {
            if (champ.clazz.equals(clazz)) {
                champList.add(champ.name);
            }
        }
        return champList;
    }
    public static double getAverageAttack(Champion[] champions, String clazz) {
        double total = 0;
        int count = 0;
        for (Champion champ : champions) {
            if (champ.clazz.equals(clazz)) {
                total += champ.style;
                count++;
            }
        }
        return total/count;
    }
    }

