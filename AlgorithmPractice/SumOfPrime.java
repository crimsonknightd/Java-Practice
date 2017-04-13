package javaeuler;
public class SumOfPrime {
	public static void main(String[] args) {

		//Find the sum of all the primes below two million.

		long sum = 0;
		
		for (int i = 0; i < 2000000; i++){
			if (isPrime(i)){
				sum += (long)i;
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isPrime(int n) {
		if (n == 2 || n == 3) {
			return true;
		} else if (n%2 == 0 || n%3 == 0 || n == 1){
			return false;
		} 
		
		int a = 5;
		while (a <= Math.sqrt(n)) {
			if (n % a == 0) {
				return false;
			}
			a++;
		}
		return true;
		
	}
	
}
