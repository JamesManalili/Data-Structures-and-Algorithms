import java.util.Scanner;

public class StringConcatenation {

	public static void main(String[] args) {
		
		String str, str2, copy, rev = "", up = "", low = "";
		int cop;
		Scanner input = new Scanner(System.in);
		System.out.print("Input string 1: ");
		str = input.nextLine();
		System.out.print("Input string 2: ");
		str2 = input.nextLine();
		
		
		System.out.print("Concatenated String: ");
		System.out.println(str.concat(str2));
	}
}
