package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;
import bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100, CAD152;
	
	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);
		
		// setup sample money amounts
		CAD100 = new Money(100, CAD);
		
		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);
		
		CAD152 = new Money(15.2, CAD);
	}

	@Test
	public void testGetAmount() {
		
		double amt = 0.0;
		amt = EUR10.getAmount();
		assertEquals(10.00,amt,0.001);
	}

	@Test
	public void testGetCurrency() {
		
		Currency curr = new Currency("CAD",0.75);
		Currency currency = CAD200.getCurrency();
		assertEquals(currency.getName(),curr.getName());
	}

	@Test
	public void testToString() {

		String outturn = "";
		outturn = EUR20.toString();
		assertEquals("20.0 EUR",outturn);

	}

	@Test
	public void testGetUniversalValue() {
		double generalValue = 0.0;
		generalValue = EUR10.getUniversalValue();
		assertEquals(11.4,generalValue,0.001);
	}

	@Test
	public void testEqualsMoney() {
		boolean testresult = false;
		testresult = EUR10.equals(CAD152);
		assertEquals(true, testresult);
	}

	@Test
	public void testAdd() {

		Money outcome = EUR10.add(CAD200);
		assertEquals(141.58, outcome.getAmount(),0.001);
		
		Money outcome2 = CAD152.add(CAD200);
		assertEquals(215.20, outcome2.getAmount(),0.001);
		
	}
	

	@Test
	public void testSubtract() {
		Money outcome = EUR10.subtract(CAD200);
		assertEquals(-121.58, outcome.getAmount() ,0.001);
	
		Money outcome2 = CAD152.subtract(CAD200);
		assertEquals(-184.80, outcome2.getAmount(),0.001);
		
	}

	@Test
	public void testIsZero() {
		boolean result = false;
		result = CAD0.isZero();
		assertEquals(true, result);
	}

	@Test
	public void testNegate() {
		Money negate = CAD200.negate();
		assertEquals(-200.00, negate.getAmount(),0.001);
	}

	@Test
	public void testCompareTo() {
		int v = 0;
		v = CAD152.compareTo(CAD200);
		assertEquals(-138,v);
	}
}
