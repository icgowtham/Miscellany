import java.util.Set;
import java.util.LinkedHashSet;

public class LhsTest {
    public static void main (String[] args) {
        Set<String> tSet = new LinkedHashSet<>();
        tSet.add("1");
        tSet.add("2");
        tSet.add("3");
        tSet.add("4");
        tSet.add("5");
        tSet.add("6");
        tSet.add("7");
        tSet.add("8");
        tSet.add("9");
        tSet.add("10");

        for (String str: tSet) {
            System.out.println(str);
        }
    }
}