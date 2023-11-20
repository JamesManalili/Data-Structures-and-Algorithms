import java.util.Scanner;

public class BSCS_2_Manalili_Stack {

	static Scanner sc = new Scanner(System.in);
	static int stack[], top = -1, size;

	public static void main(String[] args) {
		System.out.print("How many elements will stack have: ");
		if (!sc.hasNextInt()) {
			sc.next();
			System.err.print("Invalid input, Enter a number: ");
		}
		size = sc.nextInt();
		System.out.print("Processing.....");
		for (int i = 20; i <= 100; i += 20) {
			if (i >= 10 && i <= 99) {
				System.out.print(i + "% ");
			}
			if (i == 100) {
				System.out.print(i + "%");
			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		stack = new int[size];
		System.out.println("\nStack successfully created!\n");
		int ch, item;
		while (true) {
			printBorder();
			System.out.println("1 Push          ||");
			System.out.println("2 Pop           ||");
			System.out.println("3 Top           ||");
			System.out.println("4 Size          ||");
			System.out.println("5 Empty         ||");
			System.out.println("6 Display Stack ||");
			System.out.println("7 Quit          ||");
			printBorder();
			System.out.print("\nEnter choice: ");
			if (!sc.hasNextInt()) {
				sc.next();
				System.err.print("Invalid input, Enter a number: ");
			}
			ch = sc.nextInt(); 

			switch (ch) {
			case 1:
				System.out.print("\nEnter a number to add to the stack: ");
				if (!sc.hasNextInt()) {
					sc.next();
					System.err.print("Invalid input, Enter a number: ");
				}
				item = sc.nextInt();
				System.out.print("Processing.....");
				for (int i = 30; i <= 100; i += 30) {
					if (i >= 10 && i <= 99) {
						System.out.print(i + "% ");
					}
					if (i == 100) {
						System.out.print(i + "%");
					}

					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
				push(item);
				break;

			case 2:
				item = pop();
				if (item == 0) {
					System.out.println("Stack under flow");
				} else {
					System.out.println("popped item is " + item);
				}
				break;
			case 3:
				item = top();
				if (item == 0) {
					System.out.println("Stack under flow");
				} else {
					System.out.println("The top value is " + item);
				}
				break;
			case 4:
				size();
				break;
			case 5:
				display();
				break;
			case 6:
				displayStack();
				break;
			case 7:
				System.out.println("Manalili James");
				System.exit(1);
				break;
			default:
				System.out.println("Invalid Choice");
			}

		}

	}

	static void push(int item) {
		if (isFull()) {
			System.out.println("\nStack overflow");
		} else {
			System.out.print("\nStack data: " + item + " successfully pushed!\n\n");
			stack[++top] = item;
		}
	}

	static boolean isFull() {
		if (top == size - 1) {
			return true;
		} else {

			return false;
		}
	}

	static int pop() {
		if (isEmpty()) {
			return 0;
		} else {
			return stack[top--];
		}
	}

	static boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	static int top() {
		if (isEmpty()) {
			return 0;
		} else {
			return stack[top];
		}
	}

	static void displayStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			System.out.println("Elements of stack are");
			for (int i = top; i >= 0; i--) {
				System.out.print(stack[i] + " ");
			}
			System.out.print("\n");
		}
	}

	static void display() {
		if (isEmpty()) {
			System.out.println("True, stack is empty");
		} else {
			System.out.println("False, stack is not empty");
		}
	}

	static void size() {
		int j = top + 1;
		System.out.println("The size of stack is " + j);
	}

	public static void printBorder() {
		int x;
		for (x = 1; x <= 18; x++) {
			System.out.print("=");
		}
		System.out.println();
	}
}