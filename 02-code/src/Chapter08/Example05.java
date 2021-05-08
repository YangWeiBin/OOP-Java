package Chapter08;

//可变参数  
public class Example05 {
	static  int sum(int a, int b) {
		return a + b;
	}

	static  int sum(int a, int b, int c) {
		return a + b + c;
	}

	static  int sum(int a, int b, int c, int d) {
		return a + b + c + d;
	}
//注意:这里的变量其实是一个数组, 如果一个方法有多个参数还有可变参数, 那么可变参数一定放在最后    
	static  int sum(int b, int... a) {
		int s = 0;
		for (int i : a) {
			s += i;
		}
		System.out.println(a[8]);
		System.out.println(a[0]);
		
		return s + b;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int result = sum(a, b);
		System.out.println("result:" + result);

		int c = 30;
		result = sum(a, b, c);
		System.out.println("result:" + result);

		int d = 40;
		result = sum(a, b, c, d);
		System.out.println("result:" + result);

		System.out.println("可变参数的方法:"  + sum(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
		System.out.println("可变参数的方法:" + sum(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

	}

}
