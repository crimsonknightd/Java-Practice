package javaeuler;

public class LongestCollatzSequence {

//	The following iterative sequence is defined for the set of positive integers:
//
//		n Å® n/2 (n is even)
//		n Å® 3n + 1 (n is odd)
//
//		Using the rule above and starting with 13, we generate the following sequence:
//		13 Å® 40 Å® 20 Å® 10 Å® 5 Å® 16 Å® 8 Å® 4 Å® 2 Å® 1
//
//		It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//		Which starting number, under one million, produces the longest chain?
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long largest = 1;
		long count = 0;
		for (int i = 1; i <= 1000000; i++){
			long countTemp = numberInSequence(i);
			if (countTemp > count){
				count = countTemp;
				largest = i;
			}
		}
		System.out.println(largest);
		long endTime = System.currentTimeMillis();
		System.out.println("Took " + (endTime - startTime) + " ms");
	}
	
	static long numberInSequence(long startNumber){
		long count = 1;
		while (startNumber > 1){
			startNumber = (startNumber % 2 == 0)? startNumber / 2 : 3 * startNumber + 1;
			count++;
		}
		return count;
	}

}
