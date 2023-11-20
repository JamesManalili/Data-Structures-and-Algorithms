import java.util.Scanner;

public class StringToggle {

	public static void main(String[] args) {
		String str, str2, copy, rev = "", up = "", low = "";
		int cop;
		Scanner input = new Scanner(System.in);
		System.out.print("Input string 1: ");
		str = input.nextLine();
		System.out.print("Input string 2: ");
		str2 = input.nextLine();
		up = str.toUpperCase();
		char[] charArray = up.toCharArray();
		boolean foundSpace = true;
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])) {
				if (foundSpace) {
					charArray[i] = Character.toLowerCase(charArray[i]);
					foundSpace = false;
				}
			} else {
				foundSpace = true;
			}
		}
		up = String.valueOf(charArray);
		System.out.println("Output: " + up);
	}

}
