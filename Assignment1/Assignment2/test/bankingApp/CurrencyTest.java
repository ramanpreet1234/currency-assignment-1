
package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;

public class CurrencyTest {
	
	/* Example currencies: 
	 * 	CAD = Canadian dollar
	 * 	EUR = Euros
	 * 	GBP = Great British Pounds
	 * 	HKD = Hong Kong Dollars
	 */
	public Currency CAD, EUR, GBP, HKD;
	
	@Before
	public void setUp() throws Exception {
		// Setup some test currencies to use in the below test cases
		CAD = new Currency("CAD", 0.75);
		EUR = new Currency("EUR", 1.14);
		HKD = new Currency("HKD", 0.13);
	}

	@Test
	public void testGetName() {
		// Write the test case for testing the getName() function
		
		String name1 = CAD.getName();
		assertEquals("CAD", name1);
	}
	
	@Test
	public void testGetRate() {
		// @TODO: Write the test case for testing the getRate() function
		double rate1 = CAD.getRate();
		assertEquals(0.75, rate1,0.001);
	}
	
	@Test
	public void testSetRate() {
		// @TODO: Write the test case for testing the setRate() function
		
		// For this function, you should do:
		// 1. Assert that the oldRate is correct
		// 2. Change the rate
		// 3. Assert that the newRate is correct
		// You will end up with 2 assert() statements in this function.
		double oldrate = CAD.getRate();
		assertEquals(0.75, oldrate,0.001);
		CAD.setRate(1.1);
		double newrate1 = CAD.getRate();
		assertEquals(1.1, newrate1,0.001);
	}
	
	@Test
	public void testValueInUSD() {
		// @TODO: Write the test case for testing the valueInUSD() function
		double valueInUsd = EUR.valueInUSD(12);
		assertEquals(13.68,valueInUsd ,0.001);	
	}
	
	@Test
	public void testValueInThisCurrency() {
		// @TODO: Write the test case for testing the valueInThisCurrency() function
		// For this function, you should:
		// 1. Assert the value of the "other" currency
		// 2. Get the value in "this" currency
		// 3. Assert that the value in "this" currency is correct
		// You will end up with 2 assert() statements in this function.
		
		//Conversion of HKD TO EUR AND CAD
		double testother = HKD.valueInThisCurrency(10, CAD);
		assertEquals(1.73,testother ,0.001);
		CAD.getRate();
		double testthis = CAD.valueInThisCurrency(1.73, HKD);
		assertEquals(9.98,testthis,0.001);
		double testother1 = HKD.valueInThisCurrency(10, EUR);
		assertEquals(1.73,testother ,0.001);
		CAD.getRate();
		double testthis1 = CAD.valueInThisCurrency(1.73, HKD);
		assertEquals(9.98,testthis,0.001);
		
		
		//CONVERSION OF EUR TO CAD AND HKD
		double testother2 = EUR.valueInThisCurrency(10, CAD);
		assertEquals(15.2,testother2 ,0.001);
		CAD.getRate();
		double testthis2 = CAD.valueInThisCurrency(15.2, EUR);
		assertEquals(10,testthis2,0.001);
		double testother3 = EUR.valueInThisCurrency(10, HKD);
		assertEquals(87.69,testother3 ,0.001);
		CAD.getRate();
		double testthis3 = HKD.valueInThisCurrency(87.69, EUR);
		assertEquals(10,testthis3,0.001);
		
		
		//CONVERSION OF CAD TO EUR AND CAD
		double testother4 = CAD.valueInThisCurrency(10, EUR);
		assertEquals(6.58,testother4 ,0.001);
		CAD.getRate();
		double testthis4 = EUR.valueInThisCurrency(6.57, CAD);
		assertEquals(9.99,testthis4,0.001);
		double testother5 = CAD.valueInThisCurrency(10, HKD);
		assertEquals(57.69,testother5 ,0.001);
		CAD.getRate();
		double testthis5 = HKD.valueInThisCurrency(57.69, CAD);
		assertEquals(10,testthis5,0.001);
		
	}

}
