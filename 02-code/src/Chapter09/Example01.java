package Chapter09;

public class Example01 {

	Example01() {
		System.out.println("Outer class");
	}

	class InnerClass { // 定义内部类
		InnerClass() {
			System.out.println("Inner class");
		}
	}

}
