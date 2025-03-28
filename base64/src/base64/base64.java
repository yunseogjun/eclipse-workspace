package base64;

import java.util.Base64;

class base64 {
	public static void main(String[] args) {
//		  String str = "test"; String encodedStr =
//		  Base64.getEncoder().encodeToString(str.getBytes());
//		  System.out.println("encoded string: " + encodedStr);
		test1 t1 = new test1();
		t1.num1 = 200;
		t1.num2 = 300;
		int ii = t1.fun1(t1.num1, t1.num2);
		System.out.println("test1 ii = " + ii);

		test2 t2 = new test2();
		t1.num1 = 500;
		t1.num2 = 300;
		    ii = t1.fun1(t2.num1, t2.num2);
		System.out.println("test2 ii = " + ii);

		test3 t3 = new test3();
		    ii = t3.fun1(t3.num1, t3.num2);
		System.out.println("test3 ii = " + ii);
		
	}
}