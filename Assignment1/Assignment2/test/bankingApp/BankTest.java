package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.AccountDoesNotExistException;
import bankingApp.AccountExistsException;
import bankingApp.Bank;
import bankingApp.Currency;

public class BankTest {
	protected Currency CAD;
	protected Currency HKD;
	protected Bank RBC;
	protected Bank TD;
	protected Bank HSBC;
	
	
	@Before
	public void setUp() throws Exception {
		
		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);
		
		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("TD Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
		
		// add sample customers to the banks
		
		
		// HINT:  uncomment these lines AFTER you test the openAccount() function
		// You can quickly uncomment / comment by highlighting the lines of code and pressing 
		// CTRL + / on your keyboard  (or CMD + / for Macs)
		
        this.RBC.openAccount("Marcos");
		this.RBC.openAccount("Albert");
		this.TD.openAccount("Jigesha");
		this.HSBC.openAccount("Pritesh");
	}

	@Test
	public void testGetName() {
		String nameOfBank1 = RBC.getName();
		assertEquals("Royal Bank of Canada",nameOfBank1);
		String nameOfBank2 = TD.getName();
		assertEquals("TD Bank",nameOfBank2);
		String nameOfBank3 = HSBC.getName();
		assertEquals("Hong Kong Shanghai Banking Corporation",nameOfBank3);
	}

	@Test
	public void testGetCurrency() {
		Currency currency1 = new Currency("CAD",0.75);
		assertEquals("CAD",currency1.getName());
		assertEquals(0.75,currency1.getRate(),0.001);
		
		Currency currency2 = new Currency("HKD",0.13);
		assertEquals("HKD",currency2.getName());
		assertEquals(0.13,currency2.getRate(),0.001);
		
		Currency currency3 = new Currency("EUR",1.14);
		assertEquals("EUR",currency3.getName());
		assertEquals(1.14,currency3.getRate(),0.001);
	}
	

	@Test (expected = AccountExistsException.class)
	public void testOpenAccount() throws AccountExistsException {	 
			RBC.openAccount("Marcos");		
	}

	@Test (expected = AccountDoesNotExistException.class)
	public void testDeposit() throws AccountDoesNotExistException {
			RBC.deposit("Marcos",new Money(105,CAD));	
	}
	
	@Test (expected = AccountDoesNotExistException.class)
	public void testWithdraw() throws AccountDoesNotExistException {
			
		RBC.withdraw("Marcccos",new Money(15,CAD));

	}

	
	@Test (expected = AccountDoesNotExistException.class)
	public void testGetBalance() throws AccountDoesNotExistException {
		
			double bal= 0.0;
			bal = RBC.getBalance("Marcos");	
	}
	
	
	@Test (expected = AccountDoesNotExistException.class)
	public void testTransfer() throws AccountDoesNotExistException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		// 2. Transfer between banks
		// See the Bank.java file for more details on Transfers
		RBC.transfer("Marcos", TD, "Albert", new Money(15,CAD));
		RBC.transfer("Marcos", "Albert", new Money(15,CAD));
	}


	
}
