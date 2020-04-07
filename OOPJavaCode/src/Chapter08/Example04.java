package Chapter08;

public class Example04 {

	void go(int x, int y) {
		System.out.println("int,int");
	}

	void go(short... x) {
		System.out.println("short…");
	}

	void go(Short x, Short y) {
		System.out.println("Short,Short");
	}

	public static void main(String[] args) {
		Example04 test = new Example04();
		short s1 = 5;
		short s2 = 6;
		test.go(s1, s2);

	}

}
