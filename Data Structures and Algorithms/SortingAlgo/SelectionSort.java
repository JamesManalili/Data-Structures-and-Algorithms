import java.util.Scanner;

public class SelectionSort {
public static void sort(int arr[]) {	
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[min] > arr[j])
					min = j;
			}
			if(min != i) {
				int temp = arr[min];
				arr[min] = arr[i];
				print(arr);
				System.out.println();
				arr[i] = temp;
				print(arr);
				System.out.println();
				//20 12 10 15 2 
			}
		}
	}
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of an array: ");
		int n = sc.nextInt();
		
		System.out.print("Enter "+n+" values: ");
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		sort(arr);
		System.out.print("Sorted: ");
		print(arr);
	}
}
