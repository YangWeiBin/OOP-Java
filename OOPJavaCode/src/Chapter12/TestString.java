package Chapter12;
/* 在Java 1.7     之后文字常量区移动到了堆区
 */
public class TestString {
	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = new String("abcde");	//String ||创建的对象没修改字符串的方法
		StringBuffer str3 = new StringBuffer("abcde");
		str1 =  str1.toUpperCase();
		str2 =  str2.toUpperCase();
		
		str3.replace(0, 1, "z");			//StringBuffer创建的对象可以修改字符串
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
