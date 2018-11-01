class A {
	static {
		System.out.println("static");
	}
	{
		System.out.println("block");
	}
	public A(){
		System.out.println("A");
	}
	public void test1(){
		System.out.println("test1");
	}
}

class B extends A{
	public void test2(){
		System.out.println("test2");
	}
}

public class ClassTest{
	public static void printValue(int i, int j, int k){
		System.out.println("int");
	}

	public static void printValue(byte...b){
		System.out.println("long");
	}

	public static void main (String[] args) {
		A aObj = new A();
		A bObj = new B();
		B b1 = new B();
		// insert code here
		((B)bObj).test2();

		int a = 5 , b=6, c =7;
		System.out.println("Value is "+ b +c);

		for(int i = 2; i < 4; i++)
			for(int j = 2; j < 4; j++)
				if(i < j)
					assert i!=j : i;

		{
			double d=2D+2d+2.+2l+2L+2f+2F+2.f+2.D;
			System.out.println(d);
		}

		byte x = 9;
		printValue (x, x, x);
	}
}