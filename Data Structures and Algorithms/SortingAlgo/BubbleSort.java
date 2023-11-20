
import java.util.Scanner;

public class BubbleSort {
	public static void Bubblesort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			print(arr);
			System.out.println();
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					print(arr);
					System.out.println();
				} else if (arr[j] < arr[j + 1]) {
					print(arr);
					System.out.println();
				}

			}

			if (i == 0) {
				System.out.println("First Pass");
			} else if (i == 1) {
				System.out.println("Second Pass");
			} else {
				System.out.println("Third Pass");
				break;
			}
		}
		// 3 1 5 4 2
	}

	public static void print(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of an array: ");
		int n = sc.nextInt();
		System.out.print("Enter " + n + " values: ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Bubblesort(arr);
		System.out.print("Sorted: ");
		print(arr);
	}
}
