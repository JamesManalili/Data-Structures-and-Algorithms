import java.util.Scanner;
public class PalindromeChecking {
	 public static void main (String []args) { 
		  Scanner inp= new Scanner(System.in);
		    System.out.print("Enter the number: ");
		    int num= inp.nextInt();
		  
		    int reverse=0, element, remainder; 
		    element = num;
		  
		    for( ;num!=0;){//kapag zero na si num dun na sya if statement
		      remainder= num % 10;//5//4//3//2//1
		      reverse = (reverse * 10) + remainder;//5//54//543//5432//54321
		      num/=10;//1234//123//12//1//0
		    }
		    /** for( ;num!=0;){//kapag zero na si num dun na sya if statement
		      remainder= num % 10;//1//2//3//2//1
		      reverse = (reverse * 10) + remainder;//1//12//123//1232//12321
		      num/=10;//1232//123//12//1
		    **/
		  
		    if (element == reverse){
		      System.out.println("Yes, it is palindrome");
		    }
		    else{
		      System.out.println(reverse+" No, it is not palindrome");
		    }
	    }

	}

