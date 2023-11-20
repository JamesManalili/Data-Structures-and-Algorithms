import java.util.Scanner;

public class StringReverseFirstString {

	public static void main(String[] args) {
		String str, str2, copy, rev = "", up = "", low = "";
		int cop;
		Scanner input = new Scanner(System.in);
		System.out.print("Input string 1: ");
		str = input.nextLine();
		
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println("The reversed string is: " + rev);
	}

}
