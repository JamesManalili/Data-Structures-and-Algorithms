package FinalProjectDSA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QueueWithGUI extends JFrame implements ActionListener {

	JTextField textbox;
	JTextField[] Out = new JTextField[10];
	JButton Enqueue, Dequeue, Top, Exit;
	JLabel l3, l2, Press, l4, Top2, Notif, l5, l6, l7, Num, Surname;
	JLabel c;
	JPanel p;
	Icon de = new ImageIcon("C:\\Users\\james\\Desktop\\De1.PNG");// button
	Icon en = new ImageIcon("C:\\Users\\james\\Desktop\\En1.PNG");// button
	Icon top = new ImageIcon("C:\\Users\\james\\Desktop\\Top1.JPG");// button
	Icon exit = new ImageIcon("C:\\Users\\james\\Desktop\\Exit.PNG");// button
	JFrame frame; // frame

	QueueWithGUI() { // Constructor
		p = new JPanel();// panel paara lumabas sa frame
		frame = new JFrame();// frame or form kung sa vb
		frame.setSize(620, 500);// site ng frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// rekta exit kapag clinose ung frame
		frame.add(p);// p.add
		// Border thickBorder = new LineBorder(Color.WHITE, 4);//pang border sana kaso
		// di ko na ginamit
		frame.setTitle("Final Requirement in DSA"); // title lang to

		l2 = new JLabel("Applet");
		l2.setBounds(40, 20, 80, 25);
		p.add(l2);

		Enqueue = new JButton(en);
		Enqueue.setBounds(40, 50, 120, 50);// position,pang adjust pakanan,pababa,haba,lapad
		Enqueue.setBackground(Color.WHITE);// color lang ng backgroup
		// Enqueue.setBorder(thickBorder);
		p.add(Enqueue);// inadd sa frame
		Enqueue.setActionCommand("Enqueue");// para sa command to
		Enqueue.addActionListener(this);// eto din para sa command

		Dequeue = new JButton(de);
		Dequeue.setBounds(165, 50, 120, 50);
		Dequeue.setBackground(Color.WHITE);
		// Dequeue.setBorder(thickBorder);
		p.add(Dequeue);
		Dequeue.setActionCommand("Dequeue");
		Dequeue.addActionListener(this);

		Top = new JButton(top);
		Top.setBounds(290, 50, 120, 50);
		Top.setBackground(Color.WHITE);
		// Top.setBorder(thickBorder);
		p.add(Top);
		Top.setActionCommand("Top");
		Top.addActionListener(this);

		Num = new JLabel("Number");
		Num.setBounds(420, 58, 100, 30);
		p.add(Num);

		textbox = new JTextField(11);
		textbox.setBounds(468, 58, 100, 30);
		textbox.setBackground(Color.WHITE);
		p.add(textbox);
		int a = 130;
		Press = new JLabel("Press Button");
		Press.setBounds(40, 100, 100, 30);
		p.add(Press);

		Top2 = new JLabel("Top: ");
		Top2.setBounds(260, 110, 100, 30);
		p.add(Top2);

		Notif = new JLabel("Note: ");
		Notif.setBounds(260, 140, 100, 30);
		p.add(Notif);

		l6 = new JLabel("Dequeue: ");
		l6.setBounds(260, 170, 100, 30);
		p.add(l6);
		l7 = new JLabel();
		l7.setBounds(320, 170, 100, 30);
		p.add(l7);
		Exit = new JButton(exit);
		Exit.setBounds(260, 200, 120, 50);
		Exit.setBackground(Color.WHITE);
		Exit.setActionCommand("Exit");
		Exit.addActionListener(this);
		p.add(Exit);
		Exit.addActionListener(this);

		l5 = new JLabel();// eto ung para kada input gagalaw pababa
		l5.setBounds(292, 140, 100, 30);
		p.add(l5);

		l3 = new JLabel();
		l3.setBounds(290, 110, 100, 30);
		p.add(l3);
		// etong loop na to para dun sa 1-10 tsaka 10 na textField
		for (int b = 0; b < 10; b++) {
			// int b = 9; b >=0; b-- rev
			int e = 30;
			c = new JLabel(Integer.toString(b));
			Out[b] = new JTextField(10);
			// Out.setText(i);
			c.setBounds(40, a - 3, 100, 30);
			Out[b].setBounds(65, a, 100, 25);
			a = a + e;
			p.add(c);
			p.add(Out[b]);
		}

		Surname = new JLabel("Manalili, Pardillo, Tapel");
		Surname.setBounds(460, 425, 150, 30);
		p.add(Surname);

		p.setLayout(null);// layout null para di naka fix ung ayos tayo na bahala mag set
		frame.setVisible(true);// visible true para kita lahat ng mga to sa frame
	}

	int labe = 130; // 400 eto lifehacks hahahah para lang sa label bumababa kada input
	static int size = 10;
	static int rear = -1;
	static int front = -1;
	static String Queue[] = new String[size];
	String i = " "; // eto dito mapupunta mga iniinput natin sa textField
	static int j = 0;

	public static boolean checker(String right) {
		if (right.matches(".*[a-zA-Z]+.*")) {
			return false;
		} else {
			return true;
		}
	}

	public void actionPerformed(ActionEvent e) {
		String button;
		button = e.getActionCommand();// Enqueue,Dequeue,Top,Exit

		// else if(ae.getActionCommand().equals(imageButton.getText()))

		if (button == "Enqueue") {// para sa button na Enqueue pagclinick pupunta dun sa equeue na ginawa natin
									// kay maam
			while (checker(textbox.getText())) {
				l5.setText("Invalid input");
				i = textbox.getText();// ung input sa textField nilagay sa I
				textbox.setText(null);
				int q = 30;
				// l1.setBounds(70, labe, 100, 25);

				if (labe == 400) {
					// 130
				} else {
					labe = labe + q;
					// labe=labe-q;
				}
				enQueue(i);// punta sya sa Enqueue
				break;
			}
		}

		else if (button == "Dequeue") {// para sa dequeue naman to
			deQueue();// punta sya sa Dequeue
		} else if (button == "Top") {
			top();// punta ng top
		} else if (button == "Exit") {
			System.exit(0);// terminate program
		}
	}

	void enQueue(String item) {
		l3.setText(" ");
		l5.setText(" ");
		l7.setText(" ");
		if (((rear + 1) % size) == front) {
			l5.setText("Queue is Full");
			j = 0;
		} else {
			if (rear == front && front == -1) {
				front += 1;
			}
			rear = (rear + 1) % size;
			Queue[rear] = item;

			for (int i = 0; i < 10; i++) {
				if (rear == i) {
					Out[i].setText(item);
				}
			}
		}
	}

	void deQueue() {
		if (rear == front && rear == -1) {
			l5.setText("Queue is Empty");
			l7.setText("Queue is Empty");
			j = -1;
		} else {
			if (rear == front) {
				rear = -1;
				front = -1;
			} else {
				front = (front + 1) % size;
			}
			for (int i = 0; i < 10; i++) {
				if (j == i) {
					Out[i].setText("");
				}
			}
		}
		j++;
	}

	void top() {
		if (rear == front && rear == -1) {
			l3.setText("Queue is Empty");
		} else {
			l3.setText(Queue[rear]);
		}
	}

	public static void main(String[] args) {
		 new QueueWithGUI();
	}
}
