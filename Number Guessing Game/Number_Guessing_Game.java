
import java.util.*;
public class Number_Guessing_Game {
	public static  void GuessingNumberGame()
	{
		Scanner sc=new Scanner(System.in);
		int number=1+(int)(100*Math.random());
		//System.out.println("Random Number is"+number);
		int count=0;
		int k=8;
		
		int i=1,guess;
		System.out.println("Choose number between 1-100.You have only 5 trials ");
		
		for(i=0;i<k;i++) {
			System.out.print("Guess The number:");
			guess=sc.nextInt();
			if(number==guess) {
				System.out.println("Correct!You Win..!");
				count++;
			System.out.println("Your total Score is "+count);
			break;
		//	System.out.println("Would you like to play again..?\n1.Yes\n2.No");
			}
			else if(number<guess) {
				System.out.println("The number is less than "+guess);
			}
			else if(number>guess) {
				System.out.println("The number is Greater than "+guess);
			}
		}
		if(i==k) {
			System.out.println("You have exausted "+"all  trails");
			System.out.println("Your total Score is "+count);
			System.out.println("The number was "+number);
		}
		
	}

	public static void main(String[]args) {
		GuessingNumberGame();
	}
}