package javaeuler;

public class SpecialPythagoreanTriplet {

	public static void main(String[] args) {

		 /*	
		  *  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
		  *	Find the product abc.
		  */
		
		System.out.println(findTrip(1000));
		
		
		
	}
	
	public static int findTrip(int tripVal){
		
		for (int c = 3; c < tripVal*tripVal; c++){
			for (int b = 2; b < c; b++){
				for (int a=1; a < b; a++){
					if (a+b+c == tripVal){
						if (isTrip(a,b,c)){
							return a*b*c;
							
						}
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean isTrip(int a, int b, int c){
		if (a < b && b < c){
			if (a*a + b*b == c*c){
					return true;
			}
		}
		return false;
		
	}
	
}
