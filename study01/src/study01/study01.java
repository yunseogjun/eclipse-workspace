package study01;

import java.util.Iterator;

public class study01 {

	public static void main(String[] args) {
		Integer int1 = 0;
		if (args.length > 0 ) {
			System.out.println("args[0]=" + args[0]);
			int1 = Integer.parseInt(args[0].toString());
		} else {
			int1 = 1;
		}
		
		String[] strArray = {"aa11","aa12","aa13","aa14","aa15"};
		Class01 c1 = new Class01(strArray);

//		int1 =  c1.funAdd(3, 4);
//        int1 =  c1.funmultle(3, 4);
//        int1 =  c1.funSubtract(3, 4);
//        int1 =  c1.funDivide(3, 4);
		        
		        
		String[] arr1 = c1.funstring(int1);
		StringBuffer strbuf1 = new StringBuffer();
		for (int i=0 ; i< arr1.length; i++) {
			strbuf1.append(String.format("arr[%d] = %s\n", i , arr1[i]));
		}
		System.out.println(strbuf1.toString());
	}
}