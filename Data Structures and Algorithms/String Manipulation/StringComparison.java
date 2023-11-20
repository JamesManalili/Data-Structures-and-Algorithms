import java.util.Scanner;

public class StringComparison {

	public static void main(String[] args) {
		String str, str2, copy, rev = "", up = "", low = "";
		int cop;
		Scanner input = new Scanner(System.in);
		System.out.print("Input string 1: ");
		str = input.nextLine();
		System.out.print("Input string 2: ");
		str2 = input.nextLine();
		
		if (str.equals(str2)) {
			System.out.println("Yes the Strings are the same");
		} else {
			System.out.println("No the Strings are not the same");
		}

	}

}
