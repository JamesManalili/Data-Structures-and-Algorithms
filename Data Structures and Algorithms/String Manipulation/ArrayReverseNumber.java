
import java.util.Scanner;

public class ArrayReverseNumber {
	public static void main(String args[]) {
		int num = 0;
		int reversenum = 0;
		System.out.print("Input your number and press enter: ");
		Scanner in = new Scanner(System.in);
		num = in.nextInt();

		for (; num != 0;)// chinecheck yung user input kung hindi sya equal to zero kapag true punta dun
							// sa baba
		{
			reversenum = reversenum * 10;// 0//5x10=50//4x10=40//3x10=30//2x10=20
			reversenum = reversenum + (num % 10);// 5//54//543//5432//54321
			num = num / 10;// 1,234.5//123.45//12//1//0
		}

		System.out.print("Reverse of specified number is: " + reversenum);
	}
}
