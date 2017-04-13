package javaeuler;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		long largestPrime = 0;
		long number = 600851475149l;
		largestPrime = lastPrime(number);
		System.out.println(""+ largestPrime);
	}
	
	public static long lastPrime(long n){
		long lastPrimeFactor;
		if (n == 2){
			lastPrimeFactor = 2;
		} else {
			lastPrimeFactor = 1;
		}
		
		long factor = 3;
		long maxFactor = (long)Math.sqrt(n);
		while (n > 1 && factor <= maxFactor){
			if (n % factor == 0) {
				n /= factor;
				lastPrimeFactor = factor;
				while (n % factor == 0){
					n = n / factor;
				}
				maxFactor = (long)Math.sqrt(n);
				
			}
			factor +=2;
		}
		
		if (n == 1) {
			return lastPrimeFactor;
		} else {
			return n;
		}
	}
	
	public static boolean isPrime(long n) {
		if (n == 2l || n == 3l) {
			return true;
		} else if (n%2l == 0 || n%3l == 0 || n == 1l){
			return false;
		} 
		
		long a = 5;
		while (a <= Math.sqrt(n)) {
			if (n % a == 0) {
				return false;
			}
			a++;
		}
		return true;
		
	}
	
	public static boolean isFactor(long n, long a){
		if (a % n == 0) return true;
		return false;
	}

}
