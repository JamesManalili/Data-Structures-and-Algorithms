import java.util.Scanner;

public class ArraySumOfDigits {

	public static void main(String[] args) {
		int n, sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input array size: ");
		int size = sc.nextInt();
		int add[] = new int[size];
		System.out.print("Input " + size + " values: ");
		for (int i = 0; i < size; i++) {
			add[i] = sc.nextInt();
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				while (add[j] > 0) {
					n = add[j] % 10;
					sum = sum + n;
					add[j] = add[j] / 10;
				}
			}
		}
		System.out.println("Sum of " + size + " values: " + sum);

	}

}
