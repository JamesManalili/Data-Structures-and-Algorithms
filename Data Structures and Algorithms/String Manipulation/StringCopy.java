import java.util.Scanner;

public class StringCopy {

	public static void main(String[] args) {
		String str, str2, copy, rev = "", up = "", low = "";
		int cop;
		Scanner input = new Scanner(System.in);
		System.out.print("Input string 1: ");
		str = input.nextLine();
		System.out.print("Input string 2: ");
		str2 = input.nextLine();
		
		System.out.print("String Copy: ");
		cop = input.nextInt();
		if (cop == 1) {
			copy = new String(str);
			//copy =(str);
			System.out.println("String 3: " + copy);
		} else if (cop == 2) {
			copy = new String(str2);
			//copy =(str2);
			System.out.println("String 3: " + copy);
		}
		
	}

}
