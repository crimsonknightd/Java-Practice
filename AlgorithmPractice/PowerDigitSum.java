package javaeuler;

import java.math.BigInteger;

public class PowerDigitSum {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String num = new BigInteger("2").pow(1000).toString();
		int total = 0;
		for (int i = 0; i < num.length(); i++){
			total += Integer.parseInt(num.substring(i, i+1));
		}
		System.out.println(total);
		long endTime = System.currentTimeMillis();
		System.out.println("Took " + (endTime-startTime) +" ms");
	}
}
