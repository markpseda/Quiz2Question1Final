package mainPackage;
import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;
/*
 * This class is used to create Student Loan objects
 * that have tuition cost, yearly tuition increase,
 * yearly loan APR, and number of years to pay back as
 * attributes. The method totalOwed determines the amount
 * of loans to be taken out using tuition cost and tuition
 * increase, assuming the degree takes 4 years and interest
 * is not paid on the loans while in school. The method
 * monthlyRepayment determines the amount to be paid per
 * month. 
 */
public class StudentLoan {
	
	private double tuitionCost;
	private double tuitionIncrease;
	private double APR;
	private int numYears;
	
	public StudentLoan(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input the initial cost of tuition at your college: ");
		this.tuitionCost = input.nextDouble();
		
		System.out.println("Input the percentage tuition increases each year: ");
		this.tuitionIncrease = input.nextDouble();
		
		System.out.println("Input your loan repayment APR: ");
		this.APR = input.nextDouble();
		
		System.out.println("Input the number of years you plan to repay your loans: ");
		this.numYears = input.nextInt();
		
		input.close();
	}
	
	public StudentLoan(double tuitionCost, double tuitionIncrease, double APR, int numYears) {
		this.tuitionCost = tuitionCost;
		this.tuitionIncrease = tuitionIncrease;
		this.APR = APR;
		this.numYears = numYears;
	}


	public double getTuitionCost() {
		return tuitionCost;
	}
	
	public void setTuitionCost() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input the initial cost of tuition at your college: ");
		this.tuitionCost = input.nextDouble();
		input.close();
	}
	
	public double getTuitionIncrease() {
		return tuitionIncrease;
	}
	
	public void setTuitionIncrease() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input the percentage tuition increases each year: ");
		this.tuitionIncrease = input.nextDouble();
		input.close();
	}
	
	public double getAPR() {
		return APR;
	}
	
	public void setAPR() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input your loan repayment APR: ");
		this.APR = input.nextDouble();
		input.close();
	}
	
	public int getNumYears() {
		return numYears;
	}
	
	public void setNumYears() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input the number of years you plan to repay your loans: ");
		this.numYears = input.nextInt();
		input.close();
	}
	/**
	 * totalOwed is used to calculate the amount of debt that will accumulate after 4 years of college
	 * given tuition cost and the rate of tuition increase per year, both attributes of the StudentLoan class.
	 * @return returns the total amount owed after four years.
	 */
	public double totalOwed(){
		double tuitionCost = this.getTuitionCost();
		double tuitionIncrease = this.getTuitionIncrease();
				
		double total = 0; 											//running total amount owed
		double tuitionYearToYear = ((tuitionIncrease * .01)+1);		//Converts % to decimal ex: 5% to 1.05
		
		for(int year = 1; year <= 4; year++){						//counts through the four years of college
			total += tuitionCost;									//adds current tuition cost to total
			tuitionCost *= tuitionYearToYear;						//increases tuition cost by tuitionIncrease percentage
		}
		return(total);											//returns total amount owed to be paid back
	}
	/**
	 * monthlyRepayment: calculates monthly payment needed to pay back loan. Uses Apache Finance Library.
	 * @param totalOwed : pass in the total amount owed. This, combined with APR and years are used.
	 * @return : a double of the number of dollars that will be paid per month to pay back the loan.
	 */
	public double monthlyRepayment(double totalOwed){
		double APR = this.getAPR();
		int numYears = this.getNumYears();
		int numPayments = numYears * 12;
		
		double APRdecimalMonthly = ((APR/12) * .01);
		
		double monthlyPayment = FinanceLib.pmt(APRdecimalMonthly, numPayments, totalOwed, 0, false);
		
		return (monthlyPayment * -1);								//make value positive
	}
	
	
}
