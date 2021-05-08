package Chapter08;

public class Example02 {
	void go(int x) {
		System.out.println("int");
	}

	void go(Short s) {
		System.out.println("Short");
	}

	public static void main(String[] args) {
		Example02 test = new Example02();

		short s = 5;
		test.go(s);

	}

}
