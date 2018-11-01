public class FormatTest {
    public static void main (String[] args) {
        System.out.println (String.format (String.format ("%%0%dd", 13), 0).replace ("0", "X"));
    }
}