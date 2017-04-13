package javaeuler;

public class HighlyDivisibleTriangle {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int count = 0;
		long triangle = 1;
		for (long i = 2; count < 501; i++ ){
			count = 0;
			long triangleTemp = triangle;
			for (long j = 1; j < triangleTemp; j++){
				if (j == 1) {
					count++;
					continue;
				}
				if (triangle % j == 0) {
					count+=2;
					triangleTemp = triangle / j;
				}
			}
			if (count < 501) triangle += i;
		}
		System.out.println(triangle);
		long endTime = System.currentTimeMillis();
		System.out.println("Took " + (endTime-startTime) +" ms");
	}
}