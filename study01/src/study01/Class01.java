package study01;

import java.lang.reflect.Array;
import java.util.Arrays;

class Class01 {

	String[] array;
	Class01(){	}
	Class01(String[] array){
		this.array = array;
	}
	
	Integer funAdd(int x, int y) {
		return x + y;
	}
	int funSubtract(int x, int y) {
		return x - y;
	}
	int funmultle(int x, int y) {
		return x * y;
	}
	int funDivide(int x, int y) {
		return x / y;
	}

	String[] funstring(int x) {
//		String[] arr1 = {"b11","b12","b13"};
		String[] arr1 = Arrays.copyOfRange(array, 0, x);
		return arr1;
	}
}
