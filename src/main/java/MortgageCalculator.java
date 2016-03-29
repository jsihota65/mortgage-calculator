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



