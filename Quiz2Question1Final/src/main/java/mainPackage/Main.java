package mainPackage;

public class Main {

	public static void main(String[] args) {
		StudentLoan msedaloan = new StudentLoan();
		
		double totalOwed = msedaloan.totalOwed();
		System.out.print("College will cost you $");
		System.out.printf("%.2f",totalOwed);
		System.out.println(" in loans.");
		
		double monthlyPayment = msedaloan.monthlyRepayment(totalOwed);

		System.out.print("You will need to pay $");
		System.out.printf("%.2f",monthlyPayment);
		System.out.println(" per month.");

	}

}
