package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mainPackage.StudentLoan;

public class StudentLoanJUnit {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_totalOwed() {
		double tuitioncost = 10000;
		double tuitionRisingRate = 5;
		StudentLoan testLoan = new StudentLoan(tuitioncost, tuitionRisingRate, 0, 0);	//0 values are irrelevant to method
		double correctValue = 43101.25;							//determined separately for values 10k and 5% per year
		assertEquals("Total loan is not correct to $1", testLoan.totalOwed(), correctValue, 1);
	}
	
	@Test
	public void test_monthlyRepayment() {
		int years = 20;
		double APR = 5;
		
		StudentLoan testLoan = new StudentLoan(0, 0, APR, years); //0 values are irrelevant to method
		double amountOwed = 50000;
		double correctRepayment = 329.98;						//determined using tool online
		assertEquals("Repayment Value is not correct to $1", testLoan.monthlyRepayment(amountOwed), correctRepayment, 1);
	}

}
