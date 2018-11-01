public class Test {
        /*public static void main (String[] args) {
                printAll (args);
        }

        public static void printAll (String[] lines) {
                for (int i = 0; i < lines.length; i++) {
                        System.out.println (lines[i]);
                        Thread.currentThread().sleep(1000);
                }
        }*/

		public static void main(String[] args)
		{
			/*int x = 0;
			assert (x > 0) ? "assertion failed" : "assertion passed" ;
			System.out.println("finished");*/

			for(int i = 0; i < 3; i++)
			{
    			switch(i)
    			{
        			case 0: break;
        			case 1: System.out.print("one ");
        			case 2: System.out.print("two ");
        			case 3: System.out.print("three ");
    			}
			}
			System.out.println("done");

			if (doesStringStartWithUC ("Zest")) {
				System.out.println ("Starts with upper case");
			} else {
				System.out.println ("Starts with lower case");
			}
		}

		public static boolean doesStringStartWithUC (String str) {
			if (str != null && Character.isUpperCase(str.charAt(0)))
				return true;
			else
				return false;
		}
}
