import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Scanner;

public class InfixToPrefixEvalution {
	public static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter infix expression: ");
		String infix = scan.nextLine();

		while (!checker(infix)) {
			System.out.print("\nInvalid notation\n" + "Please try again\n" + "Enter a valid Infix: ");
			infix = scan.nextLine();
		}
		String prefix = infix_to_prefix(infix);
		if (!another_checker(prefix)) {
			System.out.println("\nGiven infix expresion contains letters\n" + "We can't evaluate letters\n"
					+ "proceeding to exit program");

		}
		evaluate_prefix(prefix);
	}

	public static boolean another_checker(String argument) {
		return !argument.matches(".*[a-zA-Z].*");
	}

	public static void evaluate_prefix(String prefix) {
		Stacks operan = new Stacks(prefix.length());

		String[] array = prefix.split(" ");
		String[] reversed = new String[array.length];

		int j = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			reversed[j] = array[i];
			j++;
		}
		for (String item : reversed) {
			if (item.matches("[0-9]+")) {
				operan.push(Double.parseDouble(item));
			} else {
				double a = operan.pop();
				double b = operan.pop();

				double result = evaluation(a, b, item.charAt(0));

				operan.push(result);
			}
		}
		System.out.println("Result: " + df.format(operan.topValue()));
	}

	public static double evaluation(double first, double second, char operator) {
		double result;

		switch (operator) {
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			result = first / second;
			break;
		case '^':
			result = Math.pow(first, second);
			break;
		default:
			return 0;
		}
		return result;
	}

	public static String print_array(String[] array) {
		String stre = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				stre += " " + array[i];
			}
		}
		return stre.trim();
	}

	public static boolean checker(String infix) {
		String openss = "";

		for (int i = 0; i < infix.length(); i++) {
			char letter = infix.charAt(i);

			if (letter == '(') {
				openss += letter;
			}

			else if (letter == ')') {
				if (openss.length() == 0) {
					return false;
				} else {
					openss = openss.substring(0, openss.length() - 1);
				}
			}
		}

		if (openss.length() != 0)
			return false;

		infix = infix.replaceAll("[(]\\s[+\\-/*^]", " ");
		infix = infix.replaceAll("[+\\-/*^]\\s[)]", " ");
		infix = infix.replaceAll("[(]\\s", "");
		infix = infix.replaceAll("\\s[)]", "");
		String[] infix_array = infix.split(" ");
		int array_size = infix_array.length;

		boolean[] cheOperator = new boolean[array_size];
		boolean[] cheOperand = new boolean[array_size];
		;

		for (int i = 0; i < infix_array.length; i++) {
			if (infix_array[i].equals("+") || "-".equals(infix_array[i]) || "*".equals(infix_array[i])
					|| infix_array[i].equals("/") || infix_array[i].equals("^")) {
				cheOperator[i] = true;
				cheOperand[i] = false;
			} else {
				cheOperand[i] = true;
				cheOperator[i] = false;
			}
		}

		for (int che = 0; che < infix_array.length; che++) {
			if (cheOperator[0] == true || cheOperator[infix_array.length - 1] == true) {
				return false;
			}
			if (cheOperand[che] == true) {
				if (infix_array[che].matches("[a-zA-Z0-9]+") == false) {
					return false;
				}

				if (che + 1 < infix_array.length) {
					if (cheOperand[che + 1] == true) {
						return false;
					}
				}
			}

			if (cheOperator[che] == true) {
				if (che + 1 < infix_array.length) {
					if (cheOperator[che + 1] == true) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static String infix_to_prefix(String notation) {
		String[] ope = notation.split(" ");

		int ps = 1;
		int md = 2;
		int c = 3;
		int runner4operators = 0, runner4operands = 0;
		int counter[] = new int[ope.length];
		// stack operat precedence
		int operat_precedence[] = new int[ope.length];

		String rev[] = new String[ope.length];
		String operat[] = new String[ope.length];
		String operan[] = new String[ope.length];
		String counterS[] = new String[ope.length];

		int reA = ope.length - 1;
		int a = 0;
		while (reA > -1) {
			rev[reA] = ope[a];
			reA--;
			a++;
		}
		a = 0;
		reA = ope.length - 1;
		while (reA > -1) {
			if (rev[a].equals("+") || rev[a].equals("-")) {
				counter[a] = 1;
				counterS[a] = "cba";
			} else if (rev[a].equals("*") || rev[a].equals("/")) {
				counter[a] = 2;
				counterS[a] = "cba";

			} else if (rev[a].equals("^")) {
				counter[a] = 3;
				counterS[a] = "cba";
			}

			// opening parenthesis
			else if (rev[a].equals(")")) {
				counter[a] = 0;
				counterS[a] = "paren";
			}

			// closing parenthesis
			else if (rev[a].equals("(")) {
				counter[a] = 5;
				counterS[a] = "paren";
			} else {
				counterS[a] = "abc";
			}
			a++;
			reA--;
		}

		for (int po = 0; po < rev.length; po++) {
			if (counterS[po].equals("abc")) {
				operan[runner4operands] = rev[po];
				runner4operands++;
			}

			// parenthesis
			else if (counterS[po].equals("paren")) {
				if (counter[po] == 0) {
					operat[runner4operators] = rev[po];
					operat_precedence[runner4operators] = counter[po];

					runner4operators++;
				} else {
					String operat_top = operat[runner4operators - 1];
					int operat_top_precedence = operat_precedence[runner4operators - 1];
					operat[runner4operators - 1] = "";
					operat_precedence[runner4operators - 1] = 0;

					runner4operators--;

					while (operat_top_precedence != 0) {
						operan[runner4operands] = operat_top;
						runner4operands++;

						operat_top = operat[runner4operators - 1];
						operat_top_precedence = operat_precedence[runner4operators - 1];
						operat[runner4operators - 1] = "";
						operat_precedence[runner4operators - 1] = 0;

						runner4operators--;
					}
				}
			}

			// operator
			if (counterS[po].equals("cba")) {

				// case 1
				if (counter[po] == ps) {

					if (runner4operators == 0) {
						operat[runner4operators] = rev[po];
						operat_precedence[runner4operators] = counter[po];

						runner4operators++;
					} else if (counter[po] < operat_precedence[runner4operators - 1]) {

						operan[runner4operands] = operat[runner4operators - 1];
						operat[runner4operators - 1] = "";
						operat_precedence[runner4operators - 1] = 0;

						runner4operands++;
						runner4operators--;
						po--;
						continue;
					} else if (counter[po] == ps) {
						operat[runner4operators] = rev[po];
						operat_precedence[runner4operators] = counter[po];
						runner4operators++;
					}

				}

				// case 2
				if (counter[po] == md) {
					if (runner4operators == 0) {
						operat[runner4operators] = rev[po];
						operat_precedence[runner4operators] = counter[po];

						runner4operators++;
					} else if (counter[po] < operat_precedence[runner4operators - 1]) {

						operan[runner4operands] = operat[runner4operators - 1];

						operat[runner4operators - 1] = "";
						operat_precedence[runner4operators - 1] = 0;

						runner4operands++;
						runner4operators--;
						po--;
						continue;
					} else if (counter[po] == md) {

						operat[runner4operators] = rev[po];
						operat_precedence[runner4operators] = counter[po];
						runner4operators++;
					}
				}

				// case 3
				if (counter[po] == c) {
					operat[runner4operators] = rev[po];
					operat_precedence[runner4operators] = counter[po];
					runner4operators++;
				}

			}
		}

		while (runner4operators > 0) {
			operan[runner4operands] = operat[runner4operators - 1];
			runner4operands++;
			runner4operators--;
		}

		a = 0;
		reA = ope.length - 1;
		while (reA > -1) {
			rev[reA] = operan[a];
			reA--;
			a++;
		}

		return print_array(rev);
	}

	private static class Stacks {
		private int topIndex = -1;
		private int size = 0;
		private double[] array;

		public Stacks(int size) {
			this.size = size;
			this.array = new double[size];
		}

		public boolean push(double data) {
			// check if the stack is full
			if (topIndex != size - 1) {
				topIndex++;
				array[topIndex] = data;
				return true;
			} else {
				return false;
			}
		}

		public double pop() {
			// check if the stack is empty
			if (topIndex > -1) {
				double data = array[topIndex];
				array[topIndex] = 0;
				topIndex--;
				return data;
			} else {
				return 0;
			}
		}

		public double topValue() {
			if (topIndex > -1) {
				return array[topIndex];
			} else {
				return 0;
			}
		}

		public int size() {
			return this.size;
		}

		public boolean empty() {
			if (topIndex < 0) {
				return true;
			} else {
				return false;
			}
		}

		public void displayStack() {
			if (topIndex < 0) {
				System.out.print("The Stack is empty");
			} else {
				System.out.print("\nThe stacks contains: ");
				for (int i = 0; i <= topIndex; i++) {
					System.out.print(array[i] + " ");
				}
			}
			System.out.println();
		}
	}
}
