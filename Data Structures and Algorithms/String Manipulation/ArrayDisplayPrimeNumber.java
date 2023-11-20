
import java.util.Scanner;
public class ArrayDisplayPrimeNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input Integer: ");
		int user = in.nextInt();
		int[] array = new int[user];
		int minus = user - 1;

		for (int element = 0; element < array.length; element++) // gives the array's elements from 1...a
		{
			array[element] = user - (minus);
			minus--;
		}
		for (int a = 1; a < array.length; a++) {
			System.out.print(array[a] + "\t");
		}
		System.out.println();

		for (int a = 2; a < array.length; a++) {
			int remainder = array[a] % 2;
			if (remainder != 0) {

			} else {
				array[a] = 0;
			}

		}

		for (int a = 1; a < array.length; a++) {
			if (array[a] != 0)
				System.out.print(array[a] + "\t");
		}

		System.out.println();
		for (int a = 1; a < array.length; a++) {
			int remainder = array[a] % 3;
			if (remainder != 0) {

			} else {
				array[a] = 0;
			}
		}
		for (int a = 1; a < array.length; a++) {
			if (array[a] != 0)
				System.out.print(array[a] + "\t");
		}
		System.out.println();
		for (int a = 5; a < array.length; a++) {
			int remainder = array[a] % 5;
			if (remainder != 0) {

			} else {
				array[a] = 0;
			}
		}
		for (int a = 1; a < array.length; a++) {
			if (array[a] != 0)
				System.out.print(array[a] + "\t");
		}
		System.out.println();
		for (int a = 7; a < array.length; a++) {
			int remainder = array[a] % 7;
			if (remainder != 0) {

			} else {
				array[a] = 0;
			}
		}
		System.out.println("\nThis is all the prime numbers in users input");
		for (int a = 1; a < array.length; a++) {
			if (array[a] != 0)
				System.out.print(array[a] + "\t");
		}

	}
}
