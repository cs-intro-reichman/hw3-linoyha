// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(times(-2, -3));
	    
	}  
	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if ((x1 > 0 && x2 > 0) || (x1 < 0 && x2 > 0)) {
			while (x2 !=0) {
				x1++;
				x2--;
			}
		}
		else if ((x1 > 0 && x2 < 0) || (x1 < 0 && x2 < 0)) {
			while (x2 != 0) {
				x1--;
				x2++;
			}
		}
		else if (x1 == 0) {
			return x2;
		}
		else if (x2 == 0) {
			return x1;
		}
		
		return x1;
	}
	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x1 <= 0 && x2 < 0) {
			while (x2 != 0) {
				x1++;
				x2++;
			}
		}
		else if (x1 > 0 && x2 < 0){
			while (x2!= 0){
				x1--;
				x2++;
			}
		}
		else if ((x1 > 0 && x2 > 0) || (x1 <= 0 && x2 > 0)) {
			while (x2 != 0) {
				x1--;
				x2--;
			}
		}
		
		return x1;
	}
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		if (x1 > 0 && x2 > 0) {
			while (x2 != 0) {
			sum = plus(sum,x1) ;
			x2--;
			}
		}
		else if (x1 > 0 && x2 < 0) {
			while (x1 != 0) {
				sum = plus(sum, x2);
				x1--;
			}
		}
		else if (x1 < 0 && x2 > 0) {
			while (x2 !=0 ) {
				sum = plus (sum,x1);
				x2--;
			}
		}
		else if (x1 < 0 && x2 < 0) {
			while (x2 != 0) {
				sum = plus(sum,minus (0,x1));
				x2++;
			}
		}
		else if (x1 == 0 || x2 == 0) {
			return 0;
		}
		return sum;  
	}
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		if (n != 0){
			while (n != 0) {
				result = times (result,x);
			}
		}
		else return 1;
		
		return result;
	}
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x1 == 0 || x2==0) {
			return -1;
		 }
		 int newx1 = x1;
		 int newx2 = x2;
		 if (x1 < 0) {
			newx1 = times (x1,-1);
		 }
		 if (x2 < 0) {
			newx2 = times (-1,x2);
		 }
		 if (newx2 > newx1) {
			return 0;
		 }
		 int index = 0;
		 int result = 0;
		 while (result < newx1) {
			index++;
			result = times (newx2,index);
			
		 }

		 if ((x1 > 0 && x2 < 0) || (x1 < 0 && x2 > 0)) {
			return times (-1,minus(index,1));
		 }
			
		 return minus(index,1);

		 }
		
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		return minus(x1,times(x2,div(x1,x2)));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0){
			return 0;
		}
		int index = 0;
		//int result = 0;
		while (index != div(x,index)) {
			index++;
			//result = div(x,index);
		}
		return index;
	}	  	  
}