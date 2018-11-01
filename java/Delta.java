public class Delta
{
	public void Delta () {
		System.out.println ("Delta.this.Delta");
	}

    static boolean foo (char c) {
        System.out.println (c);
        return true;
    }

    public static void main (String[] argv)
    {
        int i = 0;
        for (foo ('A'); foo ('B') && (i < 2); foo ('C'))
        {
            i++;
            foo ('D');
        }
    }
}