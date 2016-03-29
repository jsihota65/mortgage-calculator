import java.util.Scanner;

public class MortgageCalculator {

	static String propertyId;
	static int principle;
	static double interestRate;
	static int termInMonths;
	static int termInYears;
	static int months;
	static double monthlyPayments;
	static Scanner scanner = new Scanner(System.in);
	
	public static void getPropertyInfo(){
				
		//Ask for property information
		System.out.println("Please enter a property id: ");
		propertyId = scanner.nextLine();
		System.out.println("Please enter the principle amount: ");
		String principleInput = scanner.nextLine();
		principle = Integer.parseInt(principleInput);
		System.out.println("Please enter the interest rate: ");
		String interestInput = scanner.nextLine();
		interestRate = Double.parseDouble(interestInput)*.01;
		System.out.println("Please enter the term in months: ");
		String termInput = scanner.nextLine();
		termInMonths = Integer.parseInt(termInput);
		
	}
	
	public static void calculatePayment(){
		monthlyPayments = Math.round((principle * interestRate) / (1 - Math.pow(1 + interestRate,  -termInMonths)) *100)/100;
		
		termInYears = termInMonths/12;
		months = termInMonths%12;
	}
	
	public static void displayCalculations(){
		System.out.println("Here are your mortgage calculations for property " + propertyId);
		
		System.out.println("Monthly Payment: " + monthlyPayments);
		System.out.println("Term in Years and months: " + termInYears + " years and " + months + " months");
		
	}
	
	public static void askUserForAnotherProperty(){
		
	}
	public static void main(String[] args) {
		
		//Greet the user		
		System.out.println("Thank you for visiting the Mortgage Calculator\n");
		
		getPropertyInfo();
		calculatePayment();
		displayCalculations();
		
		//ask user if they would like to calculate for another property.
		
		System.out.println("Would you like to calculate the mortgage for another property? Enter 'y' for yes or 'n' to quit: ");
		String answer = scanner.nextLine();
	
		while(answer.equalsIgnoreCase("y")){

			getPropertyInfo();
			calculatePayment();
			displayCalculations();
			
			System.out.println("Would you like to calculate the mortgage for another property? Enter 'y' for yes or 'n' to quit: ");
			answer = scanner.nextLine();
		}
		
		System.out.println("Thank you for using the Mortgage Calculator. Have a nice day!");
			
		
		
	}

}



/*Create an application which calculates the mortgage of a house given the principle, interest and term. The application should do the following steps:

Welcome the user to the application.
Ask the user what the property ID is.
Ask the user what the principle is (ex: 200000), the interest (ex: .0575), and term in months (360).
Calculate the payments based on the formula below:
double monthlyPayment =  (principle * interest) /  (1 - Math.pow( 1 + interest, -termInMonths));
Let the user know what the payments would be each month, for how many years and months for what property. Not just total months based on supplied term (Must use modulus operator).
Ask the user if they would like to find out the mortgage of another home and if not, exit.
Echo a farewell message to the user.
Exit the application.

NOTE: 
* To compare Strings you must use equals method or equalsIgnoreCase(). For example:
if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {... pg 70, Java24Hrs
*/