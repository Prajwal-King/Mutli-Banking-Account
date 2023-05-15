package com.multiBankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Account {
  String acc_no;
  String name;
  String acc_type;
  long balance;
  long prev_transaction;
  
  String username;
  String password;
  
  void enterOnlyNumberForAmount() {

	Scanner sc = new Scanner(System.in);
	System.out.println("=====================================================");		
	System.out.println("Deposit Amount:");
	try {
	long acc_balance1 = sc.nextLong();
	
	boolean check;
			check=Pattern.matches("[\\d]+", String.valueOf(acc_balance1));

	if(check) {
		balance = acc_balance1;	
		System.out.println();
	}else{
		System.out.println("=====================================================");		
		System.out.println(" Amount must be contain Number[0-9] only\n");
		System.out.println();
		enterOnlyNumberForAmount();		
	}
}
	catch (InputMismatchException ie) {
		System.out.println("=====================================================");
		System.out.println("<---------------- Invalid Input!!! ----------------->"
				       + "\n<-------[ Enter  Number or Digit[0-9] only ]-------->");
		System.out.println("=====================================================");		
		System.out.println();	
		enterOnlyNumberForAmount();
	}
}
	void checkAccNo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================");		

		System.out.println("Enter Account No:");
		String acc_no1 = sc.nextLine();

		boolean check;
		check=Pattern.matches("\\d+", acc_no1);
		
		if(check) {
			acc_no = acc_no1;
			System.out.println();
		
		}else{
			System.out.println("=====================================================");					
			System.out.println("Account Number must contain Number[0-9] only\n");
			checkAccNo();		

		}
}
	
	void checkName() {

		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================");		
		System.out.println("Enter Account Holder Name:");
		String acc_name = sc.nextLine();
	
		boolean a;
		a=Pattern.matches("[a-zA-Z\s]*", acc_name);
		if(a) {
			name = acc_name;
			System.out.println();
		}else{
			System.out.println("=====================================================");		
			System.out.println("Account Holder Name must be contain  alphabets  only \n");
			checkName();		
	}	
}
	void selectAccType_And_checkInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================");		

		System.out.println("Select AccounType:\npress 1.saving Account"
											+ " \npress 2.current Account");
		String opt=sc.nextLine();
		
		switch(opt) {
		 case "1": acc_type = "saving";
		 break;

		 case "2": acc_type = "current";
		 break;
		 
		 default:
			 System.out.println("=====================================================");		
		 System.out.println("<---------------- Invalid Input!!! ----------------->"
							+ "\n========= Please Enter Valid input Only =========");			
		 selectAccType_And_checkInput();
		  break;
			 }
		 }	
	void addUserName() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("=====================================================");					
		
		System.out.println("Enter Username:");
		String user = sc.nextLine();
	 	
		boolean set=false;
		set=Pattern.matches("[a-zA-Z]+", user);
		if(set) { 
			username=user;
		}else {
			System.out.println("=====================================================");					
			System.out.println("username name must contain Alphabet[a-z]/[A-Z] only\n");
		addUserName();
		}
		
	}
	void addUserPassword() {
		Scanner sc = new Scanner(System.in);

		System.out.println("=====================================================");					
		System.out.println("Enter password:");
		String pwd = sc.nextLine();
		boolean set=false;
		set=Pattern.matches("[^\s]+", pwd);
		if(set) { 
			password=pwd;
		}else {
			System.out.println("=====================================================");					
			System.out.println("Password  must contain  alphabet/number only\n");
		addUserPassword();
		}
		
	}
	//method for add UserAccount details
	public void addAccount() {
	
	checkAccNo();//method  to take "acc_number"
	
	checkName(); //method to take "account holder name"	
	
	selectAccType_And_checkInput();//method to take "account type"
	
	enterOnlyNumberForAmount();//method to take "amount"
	
	addUserName();//method to take "username"
	
	addUserPassword();//method to take "userpassword"
	
	confirmDetails();
}
	
//method for user's account confirmDetails
void confirmDetails() {
Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println("=====================================================");		
	System.out.println("press 1.to confirm details \npress 2.to re-enter details");
	String opt=sc.nextLine();
switch (opt) {
case "1":
	 System.out.println("=====================================================");		
	 System.out.println(":)__Your Details Confirm Successfully!!!__:)");
		System.out.println("\n");
	break;

case "2":
	 System.out.println("=====================================================");		
	 System.out.println("Re-Enter Your Details");	 
	 addAccount();	
	break;

default:
	 System.out.println("=====================================================");		
	 System.out.println("<---------------- Invalid Input!!! ----------------->"
						+ "\n========= Please Enter Valid input Only =========");			
	 confirmDetails();
	break;
	}
}

//method for edit user's account details
void editDeatils() {
	Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println("=====================================================");		
	System.out.println("Do You want to edit details ? press [y:(yes) or n:(no)] ");
	String opt=sc.nextLine();
switch (opt) {
case "y":
	 System.out.println("=====================================================");		
	 addAccount();	
	 System.out.println(":)__Your Details Confirm Successfully!!!__:)");
	 getDetails();
	 menu(); 
	 break;

case "n":
	 System.out.println("=====================================================");		
	 menu();
	 break;

default:
	 System.out.println("=====================================================");		
	 System.out.println("<---------------- Invalid Input!!! ----------------->"
						+ "\n========= Please Enter Valid input Only =========");			
	 editDeatils();
	 break;
	}
	
}

//method for Display user's account details 
void getDetails() {
	 System.out.println("=====================================================");		
	 System.out.println("================ Your Account Details ===============");
	 System.out.println("=====================================================");		
	System.out.println("Account Number: " + acc_no);
	System.out.println("Account Holder Name: " + name);
	System.out.println("Account Type: " + acc_type);
	System.out.println("Account Balance: " + balance);

}

//method for perform operations on user's account
public void operations() {
	Scanner sc = new Scanner(System.in);	
	 System.out.println("\n*****************************************************");		
	 System.out.println("!---------------------*[ Tasks ]*-----------------------!");	
	 System.out.println("*****************************************************");		
	 System.out.println("press 1.Make Deposit \npress 2.Make Withdraw  \npress 3.Check Balance "
		 + "\npress 4.Show Transactions \npress 5.See AccountDetails \npress 6. Back to Menu ");
	int opt = 0;
	try {
		opt = sc.nextInt();
	} catch (InputMismatchException ie) {
		System.out.println("=====================================================");
		System.out.println("<---------------- Invalid Input!!! ----------------->"
				       + "\n<----------[ Enter Digit OR Number only ]----------->");
		System.out.println("=====================================================");			
		operations();
		System.out.println();
	}

	switch (opt) {
	case 1:
		deposit();
		operations();
		break;
	case 2:
		withdraw();
		operations();
		break;
	case 3:
		checkBalance();
		operations();
		break;
	case 4:
		showTransaction();
		operations();
		break;
	case 5:getDetails();
		operations();
		break;
	case 6:
		menu();
		break;
	default:
		System.out.println("<----------------- Invalid Input!!! ------------------>"
					  + "\n ============ Please Enter Valid input Only ===========");
	    System.out.println("======================================================");		
		operations();
		break;
	}
}

// method for deposit amount
public void deposit() {
	Scanner sc = new Scanner(System.in);
	long amt = 0;
	System.out.println("======================================================");		
	System.out.println("Enter the amount you want to deposit");

	String a=sc.nextLine();
		boolean set=false;
		set=Pattern.matches("\\d+", a);
		if(set) {
		amt = Long.parseLong(a);

		if(amt>0) { //inner if-else started
			balance = balance + amt;
	 		prev_transaction = amt;
			System.out.println("======================================================");		
				System.out.println("Rs." + amt + " amount deposited successfully.");
			}
		else {
			System.out.println("======================================================");		
			System.out.println("<=======[ Enter amount Sholud not be zero(0) ]=======>");
			System.out.println();
			deposit();
		}//inner if-else closed

		}else {
			System.out.println("=====================================================");					
			System.out.println("Account Number must contain Number[0-9] only\n");
			deposit();
		}	
}

// method for withdraw amount
public void withdraw() {
	Scanner sc = new Scanner(System.in);
	long amt = 0;
	System.out.println("======================================================");		
	System.out.println("Enter the amount you want to withdraw");
	try {
	amt = sc.nextLong();
	}
	catch (InputMismatchException ie) {

		System.out.println("=====================================================");
		System.out.println("<---------------- Invalid Input!!! ----------------->");
		System.out.println("<=======[ Enter amount Sholud not be zero(0) ]=======>");
		System.out.println("=====================================================");		
		withdraw();	
	}
	if (balance >= amt) {
		balance = balance - amt;
		if(amt!=0)
		{
			prev_transaction = amt;
			
		System.out.println("======================================================");		
				System.out.println("Rs." + amt + " amount withdrawn successfully.");
		}
		} else {

		System.out.println("======================================================");		
		System.out.println("<============== Transaction Failed!!! ===============>" 
						+"\n Your balance is lesser than Rs." + amt);	
		withdraw();
	}
}

//method for checking Balance
public void checkBalance() {
		System.out.println("======================================================");		
		System.out.println("Your Account Balance: Rs." + balance);
		System.out.println("======================================================");		
		}
//method for show transaction
public void showTransaction() {
		System.out.println("======================================================");		
		System.out.println("Last Transactions: Rs." + prev_transaction);
		System.out.println("======================================================");		
}

//method to exit from user's account
public void exit() {
	System.out.println(":)-----------[ Thank You visit again!!! ]------------:)\n");	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("\n=====================================================");		
	System.out.println("*****************************************************");		
	System.out.println("=====================================================");		
	System.out.println("press.1 Creat Account \npress.2 Login");
	int opt = 0;
	try {
		opt=sc.nextInt();
	}
	catch (InputMismatchException e) {
		System.out.println("======================================================");		
		System.out.println("<----------------- Invalid Input!!! ------------------>"
				       + "\n<-----------[ Enter Digit OR Number only ]------------>");
		System.out.println("======================================================");		
		System.out.println();
	}
	switch(opt) {
	case 1:createBankAccount();
		break;
	
	case 2:login();
		break;
		
	default:
		System.out.println("<----------------- Invalid Input!!! ------------------>"
					  + "\n ============ Please Enter Valid input Only ===========");
		System.out.println("======================================================");		
			exit();
		break;
	}
}

//method for to login user's account
public void login(){	 
	Scanner sc=new Scanner(System.in);
	System.out.println("\n======================================================");		
	System.out.println("!!!.................[ User Login ]..................!!!");
	
	System.out.println("======================================================");		
	System.out.println("Enter  username:");	  
	String user = null;
 	user=sc.nextLine();
	
	System.out.println("======================================================");		
	System.out.println("Enter  password:");
	String pwd; 
	pwd=sc.nextLine();
 	 
	if(user.equals(username) && pwd.equals(password))// if-else opened
	  {
	System.out.println("======================================================");	
	System.out.println("login Successfully...");
	getDetails();	
	menu();		
	  }else {
		System.out.println("======================================================");		
		System.out.println("Login Failed...");
		System.out.println();
		login();
	}//if-else is closed
}

void menu() {
	Scanner sc=new Scanner(System.in);

	System.out.println("======================================================");	
	System.out.println("!------------------*[ Menu ]*------------------!");				
	
	System.out.println("press 1.Task \npress 2.Edit Details \npress 3.Exit");
	
	int opt=sc.nextInt();
	if(opt==1){ 
	operations();
	
	}else if(opt==2){
	System.out.println("!------------------*[ Edit Details ]*------------------!");				
	editDeatils();
	
	}else if(opt==3) {
	System.out.println("!----------------------*[ Exit ]*----------------------!");				
	exit();
	}	
	else{
	System.out.println("<----------------- Invalid Input!!! ------------------>"
			  + "\n ============ Please Enter Valid input Only ===========");
	System.out.println("======================================================");
	System.out.println("\n");
	menu();
	}
}

public  void createBankAccount() {
	Scanner sc = new Scanner(System.in);
	System.out.println("===================================================================");		
	System.out.println("!!!.............Welcome to Multi-Bank Account Portal............!!!");
	System.out.println("===================================================================");
	System.out.println("<-----------[ To Open Bank account In Your Desire Bank ]----------->");
	System.out.println("===================================================================");
	System.out.println("=====================================================");
	System.out.println("Please Select Below Option:-");
	System.out.println("=====================================================");
		
	System.out.println("press 1.Public SectorBank  \npress 2.Private SectorBank"); 
	int opt = 0;
	try {
		opt = sc.nextInt();
	} catch (InputMismatchException ie) {
		System.out.println("=====================================================");
		System.out.println("<---------------- Invalid Input!!! ----------------->"
				       + "\n<----------[ Enter Digit OR Number only ]----------->");
		
		System.out.println();
		createBankAccount();
	}
	switch (opt) {
	
	case 1:
		System.out.println("=====================================================");
		System.out.println("You have choosen Public SectorBank.");
		System.out.println("=====================================================");
		PublicBank.publicBank();
		break;
	
	case 2:
		System.out.println("=====================================================");
		System.out.println("You have choosen Private SectorBank");
		System.out.println("=====================================================");
		PrivateBank.privateBank();
	break;
	
	default:
		System.out.println("=====================================================");
		System.out.println("<---------------- Invalid Input!!! ----------------->"
				       + "\n<---------[ Please Enter valid input only ]--------->");
		System.out.println("\n");
		createBankAccount();
		break;
		}
	}
}

//publicbank class started
class PublicBank extends Account{
	public static void publicBank() {
	Account a1=new BankOfMaharashtra(); 
	BankOfMaharashtra b1=(BankOfMaharashtra)a1;
	
	Account a2=new CanaraBank();
	CanaraBank b2=(CanaraBank)a2;
	
	Account a3=new StateBankOfIndia();
	StateBankOfIndia b3=(StateBankOfIndia)a3;
	
	Account a4=new UnionBankIndia();
	UnionBankIndia b4=(UnionBankIndia)a4;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("press 1.Bank of Maharashtra  \npress 2.Canara Bank "
					+ "\npress 3.StateBankOfIndia \npress 4.UnionBankOfIndia"); 
			int opt = 0;
			try {
				opt = sc.nextInt();
			} catch (InputMismatchException ie) {
				System.out.println("=====================================================");
				System.out.println("<---------------- Invalid Input!!! ----------------->"
						       + "\n<----------[ Enter Digit OR Number only ]----------->");
				System.out.println("=====================================================");			
				System.out.println();
				publicBank();
			}

			switch (opt) {
			case 1:System.out.println("You have choosen BankOfMaharashtra");
			b1.maharashtraBank();
				
			break;
			case 2:System.out.println("You have choosen CanaraBank");
			b2.canaraBank();
			break;
			
			case 3:System.out.println("You have choosen StateBankOfIndia");
			b3.stateBankOfIndia();
			break;
			
			case 4:System.out.println("You have choosen UnionBankOfIndia");
			b4.unionBank();
			break;
			
			default:
				System.out.println("<---------------- Invalid Input!!! ----------------->"
					       + "\n<---------[ Please Enter valid input only ]--------->");
				publicBank();
				break;
			}
		}
}//public bank closed

class BankOfMaharashtra extends PublicBank{

	public void maharashtraBank() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To BankOfMaharashtra Bank ........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();			
		menu();
	}
}

class CanaraBank extends PublicBank{

	public void canaraBank() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To Canara Bank ........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();			
		menu();
	}	
}

class StateBankOfIndia extends PublicBank{

	public void stateBankOfIndia() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To StateBankOfIndia........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();			
		menu();
		}	
}

class UnionBankIndia extends PublicBank{

	public void unionBank() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To BankOfMaharashtra Bank ........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();			
		menu();
		}
}

//PrivateBank class  started
class PrivateBank extends Account  {
	public static void privateBank() {

Account a=new AxisBank();
AxisBank b=(AxisBank)a;

Account a1=new HDFCBank();
HDFCBank b1=(HDFCBank)a1;

Account a2=new ICICIBank();
ICICIBank b2=(ICICIBank)a2;

Account  a3=new KotakMahindraBank();
KotakMahindraBank b3=(KotakMahindraBank)a3;


	Scanner sc = new Scanner(System.in);
	System.out.println("press 1.Axis Bank  \npress 2.HDFC Bank \npress 3.ICICI Bank \npress 4.Kotak Mahindra Bank "); 
	int opt = 0;
	try {
		opt = sc.nextInt();
	} catch (InputMismatchException ie) {
		System.out.println("=====================================================");
		System.out.println("<---------------- Invalid Input!!! ----------------->"
				       + "\n<----------[ Enter Digit OR Number only ]----------->");
		System.out.println("=====================================================");			
		System.out.println();
		privateBank();
	}

	switch (opt) {
	case 1:System.out.println("You have choosen AxisBank");
	b.axisBank();		
	break;
	case 2:System.out.println("You have choosen HDFCBank");
	b1.hdfcBank();  
	break;
	case 3:System.out.println("You have choosen ICICIBank");
	b2.iciciBank();  
	break;
	case 4:System.out.println("You have choosen KotakMahindraBank");
	b3.kotakMahindraBank();  
	break;
	default:
		System.out.println("<---------------- Invalid Input!!! ----------------->"
			       + "\n<---------[ Please Enter valid input only ]--------->");
	privateBank();
		break;
		}	
	}
}//privatebank class  closed

class AxisBank extends PrivateBank{
	
	public void axisBank() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To Axis Bank ........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();
		menu();
		}	
}
class HDFCBank extends PrivateBank{

	public void hdfcBank() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To HDFC Bank ........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();
		menu();
	}
}
class ICICIBank extends PrivateBank{

	public void iciciBank() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To ICICI Bank ........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();
		menu();	
	}
}
class KotakMahindraBank extends PrivateBank{

	public void kotakMahindraBank() {
		addAccount();	
		System.out.println("===============================================");
		System.out.println("!!!........Welcome To KotakMahindra Bank ........!!!");
		System.out.println(" Your Account hass been  Successfully created!!! ");
		System.out.println();
		getDetails();
		menu();
		}
}
