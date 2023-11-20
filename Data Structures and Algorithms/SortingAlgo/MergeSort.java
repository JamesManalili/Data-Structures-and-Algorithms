import java.util.Scanner;
public class MergeSort {

	static int n =0;
	static Scanner sc = new Scanner (System.in);
	static int [] arr;
	public static void main(String[] args) {
		System.out.print("Enter size of an array: ");
		n=sc.nextInt();
		System.out.print("Enter "+n+" values: ");
		arr= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int[] numbers = new int[n];
		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = arr[i];
			number[i] = arr[i];
		}
		mergeSort(numbers);
		System.out.print("Sorted Array: ");
		printArray(numbers);
	}
	// 3 1 5 4 2 12 -1 10 7
	
	private static void mergeSort(int[] inputArray) {
		int inputLength = inputArray.length;
		if (inputLength < 2) {
			return;
		}
		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];
		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = inputArray[i];
		}
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge(inputArray, leftHalf, rightHalf);
	}
	// 38 27 43 3 9 82 10

	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] <= rightHalf[j]) {		
				inputArray[k] = leftHalf[i];
				i++;
			} else {
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		
		while (i < leftSize) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
