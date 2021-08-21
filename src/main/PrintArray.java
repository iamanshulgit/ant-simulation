package main;

public class PrintArray {
	public static void printArray(int[][]a) {
		for(int[] b : a) {
			for(int c : b)
				System.out.print(c + " ");
			System.out.println();
		}
		System.out.println();
	}
}
