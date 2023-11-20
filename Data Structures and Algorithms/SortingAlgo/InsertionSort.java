import java.util.Scanner;
public class InsertionSort {
	public static void  InsertionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int j = 0;
			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
			print(arr);
			System.out.println();
		}
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
		// 3 1 5 4 2
		 InsertionSort(arr);
		System.out.print("Sorted: ");
		print(arr);
	}
}
