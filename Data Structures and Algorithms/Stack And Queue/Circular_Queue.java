import java.util.Scanner;
public class Circular_Queue {
	// Stacks Last in first out or First in last out
	// Queue First in first out or Last in Last out
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the Queue: ");
		int size = input.nextInt();
		Circular_Queue.size=size;
		Queue = new int[size];
		int select;
		int term = 0;
		while (true) {
			System.out.print("\nMenu: \n1. Enqueue\n2. Dequeue\n3. Display Queue\n4. Exit\nEnter Choice : ");
			select = input.nextInt();
			System.out.println();
			switch (select) {
			case 1: {
				// 10 2 3 13 30 12 13 15
				System.out.print("Enter element to insert in the Queue: ");
				int ele = input.nextInt();
				enQueue(ele);
				System.out.println("Front: " + front + "\nRear: " + rear);
				break;
			}
			case 2: {
				deQueue();
				System.out.println("Front: " + front + "\nRear: " + rear);
				break;
			}
			case 3: {
				display();
				break;
			}
			case 4: {
				System.out.println("Manalili, James");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Enter a valid options");
			}
		}
	}

	static int size;
	static int rear = -1;
	static int front = -1;
	static int Queue[];

	// push sa stacks
	// Enqueue sa Queue
	static void enQueue(int item) {
		if (((rear + 1) % size) == front) {
			System.out.println("Queue is Full");
		} else {
			if (rear == front && front == -1) {
				front += 1;
			}
			rear = (rear + 1) % size;
			Queue[rear] = item;
			/*System.out.print("Queue: "+Queue[rear]);
			System.out.println();*/
			display();
		}
	}
	// pop sa stacks
	// Dequeue sa Queue
	static void deQueue() {
		if (rear == front && rear == -1) {
			System.out.println("Queue is Empty.");
		} else {
			int item = Queue[front];
			if (rear == front) {
				rear = -1;
				front = -1;
			} else {
				front = (front + 1) % size;
			}
			System.out.println(item + " is deQueued from the Queue");
			display();
		}
	}

	// print all element of array
	static void display() {
		int tmpfront = front;
		if (rear == front && rear == -1) {
			System.out.println("Queue is Empty.");
		} else {
			System.out.print("Queue: ");
			for (int i = 0; i < size; i++) {
				if (tmpfront != rear) {
					System.out.print(Queue[tmpfront] + " ");
					tmpfront = (tmpfront + 1) % size;
				} else {
					System.out.println(Queue[rear]);
					break;
				}
			}
		}
	}
}
