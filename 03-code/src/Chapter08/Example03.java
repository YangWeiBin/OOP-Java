package Chapter08;

public class Example03 {
	void go(long ...x) {
		System.out.println("double");
	}

	void go(Integer x) {
		System.out.println("Integer");
	}

	public static void main(String[] args) {

		Example03 test = new Example03();
		int i = 5;
		test.go(i,i);
	}

}
