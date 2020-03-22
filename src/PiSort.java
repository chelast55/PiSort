import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PiSort {

    public static final String PI_PATH = "res/pi_shorter.txt";
    public static final String PERSONS_PATH = "res/persons.csv";

    public static char[] pi;

    public static List<Matchable> list;

    public static void main(String[] args) {
        list = new LinkedList<>();
        pi = getPi();
        populateList();
        sortList();
        System.out.println(list);
    }

    public static void populateList() {
        FileInputStream personsStream = null;
        String[] person = new String[2];
        try {
            personsStream = new FileInputStream(new File(PERSONS_PATH));
            BufferedReader personsReader = new BufferedReader(new InputStreamReader(personsStream));
            while (personsReader.ready()) {
                person = personsReader.readLine().split(";");
                list.add(new Person(person[0], person[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int matchToPi(Matchable m) {
        return BM.bm(pi, m.getPattern().toCharArray());
    }

    public static void computeIndex(Matchable m) {
        m.setIndex(matchToPi(m));
    }

    public static char[] getPi() {
        String pi = "";
        FileInputStream piStream = null;
        try {
            piStream = new FileInputStream(new File(PI_PATH));
            BufferedReader piReader = new BufferedReader(new InputStreamReader(piStream));
            char[] readDigits = new char[2048];
            while (piReader.ready()) {
                piReader.read(readDigits, 0, readDigits.length);
                pi = pi.concat(String.copyValueOf(readDigits));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pi.toCharArray();
    }

    public static void sortList() {
        for (Matchable matchable : list) {
            computeIndex(matchable);
        }
        Collections.sort(list);
    }
}
