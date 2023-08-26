
import java.util.*;
public class Atm {
public static Scanner sc=new Scanner(System.in);
public static ArrayList<String> List=new ArrayList<>();

//transaction history  
public static void transac(int balance) {
	for(String i : List) {
		System.out.println(i);
	}
	ask(balance);
}

//login function 
public static void login(String username,int pin) {
	if(username.contains("Rashmi")&&pin==9090) {
		List.add("Logged In");
		ask(1000);
	}else {
		System.out.println("Enter the valid info!");
		System.out.println("Username followed by pin and seperated by a space:");
		login(sc.next(),sc.nextInt());
	}
}
//withdraw function
public static void withdraw(int balance,int amount) {
	if(amount>=0) {
		balance-=amount;
		System.out.println("Transaction Succesful,current balance is:"+balance);
		List.add(amount+" rupee/'s "+amount+" withdrawn.");
		ask(balance);
	}else {
		System.out.println("Enter the valid amount(greater than equal to 0):");
		withdraw(balance,sc.nextInt());
	}
}
//deposit function
public static void deposit(int balance ,int amount) {
	if(amount>=0) {
	balance+=amount;
	System.out.println("Transaction Succesful,current balance is:"+balance);
	List.add(amount+" rupees/'s deposited.");
	ask(balance);
}else {
	System.out.println("Enter the valid amount(greater than equal to 0):");
	deposit(balance,sc.nextInt());
}
}
//transfer function
//user account
public static void transfer(int balance,int amount) {
	if((amount<=balance)&&(amount>=0)) {
		System.out.println("Enter Receivers username:");
		String accname=sc.next();
		balance-=amount;
		System.out.println(amount+" \"rupees/'s  sent to "+accname);
		System.out.println("Transaction Succesful,current balance is:"+balance);
		List.add(amount+" transferred to account "+accname);
		ask(balance);
	}else {
		System.out.println("Enter the valid amount(greater than equal to 0):");
		transfer(balance,sc.nextInt());
	}
}
//"Quit " to exist the program
public static void quit(int balance,char qresponse) {
	if(qresponse=='y'||qresponse=='Y') {
		System.out.println("You are succesfully Log Out..! ");
		System.out.println();
	}else {
		ask(balance);
	}
}
//ask function presents the user with a list of options and allows them to 
//choose one of the actions
public static void ask(int bal) {
	System.out.println();
	System.out.println();
	System.out.println("1.Transaction History");
	System.out.println("2.Withdraw");
	System.out.println("3.Deposit");
	System.out.println("4.Transfer");
	System.out.println("5.Quit");
	System.out.println("Choose one of the following options:");
	int opt=sc.nextInt();
	System.out.println();
	if(1>opt || opt>5) {
		System.out.println("Enter valid input:");
		ask(bal);
	}else {
		switch(opt) {
		case 1:System.out.println("Transaction History:");
		transac(bal);
		break;
		
		case 2:System.out.println("Enter amount to be withdraw:");
		withdraw(bal,sc.nextInt());
		break;
		
		case 3:System.out.println("Enter amount to be deposited:");
		deposit(bal,sc.nextInt());
		break;
		
		case 4:System.out.println("Enter amount to be transferred:");
		transfer(bal,sc.nextInt());
		break;
		
		case 5:System.out.println("Do you want to exit(Yes/No):");
		char qresponse=sc.next().charAt(0);
		quit(bal,qresponse);
		break;	
		}
	}
}
public static void main(String[]args) {
System.out.println();
//use username is given"Rashmi and password 9090"
System.out.println("Use pin  as 9090  and username Rashmi for testing");
System.out.println("----------------LOGIN-------------");
System.out.println("Enter the username");
String username=sc.next();
System.out.println("enter pin:");
int pin=sc.nextInt();
login(username,pin);
}
}
