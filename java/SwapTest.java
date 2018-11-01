public class SwapTest {
    public static void main (String[] args) {
        String s1 = "Hello", s2 = "World!";

        System.out.println ("First: " + s1 + " Second: " + s2);
        process (s1, s2);
        System.out.println ("First: " + s1 + " Second: " + s2);
    }

    static void process (Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
}