package junitItescia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import junitItescia.services.Money;

@DisplayName("MoneyBagTest")
public class MoneyBagTest {

	private static Money mbaseMoney;
	
	@BeforeAll()
	static void beforeAll() throws Exception {
		mbaseMoney = new Money(10, "EUR");
	}
	
	@Test
	void testAddMoneyWithDataOk() throws Exception {
		Money newAmount = mbaseMoney.add(10, "EUR");
		
		Money expected = new Money(20, "EUR");
		assertEquals(expected.getFAmount(), newAmount.getFAmount());
		assertEquals(expected.getFCurrency(), newAmount.getFCurrency());
	}
	
	@Test
	void testAddMoneyWithDataNegativeOk() throws Exception {
		Money newAmount = mbaseMoney.add(-5, "EUR");
		
		Money expected = new Money(5, "EUR");
		assertEquals(expected.getFAmount(), newAmount.getFAmount());
		assertEquals(expected.getFCurrency(), newAmount.getFCurrency());
	}
	
	@Test

	void testAddMoneyWithDataNotOk() {
		assertThrows(Exception.class, () -> {
			mbaseMoney.add(10, "USD");
	    }, "currency not equal");
	}
	
	@Test
	@DisplayName("Test Add Money with money Ok")
	void testAddMoneyWithMoneyOk() throws Exception {
		Money newAmount = mbaseMoney.add(new Money(10, "EUR"));
		
		Money expected = new Money(20, "EUR");
		assertEquals(expected, newAmount);
	}
	
	@Test
	void testAddMoneyWithMoneyNotOk() {
		assertThrows(Exception.class, () -> {
			mbaseMoney.add(new Money(10, "USD"));
	    }, "currency not equal");
	}
	
	@Test
	void testAddMoneyDataCurrencyFailed() {
		assertThrows(Exception.class, () -> {
			mbaseMoney.add(10, "ABC");
	    }, "currency is not in the possible currency list");
	}
	
	@Test
	void testAddMoneyCurrencyFailed() {
		assertThrows(Exception.class, () -> {
			mbaseMoney.add(new Money(10, "ABC"));
	    }, "currency is not in the possible currency list");
	}
	
	@Test
	void testAddMoneyDataAmountNegative() {
		assertThrows(Exception.class, () -> {
			mbaseMoney.add(-20, "EUR");
	    }, "amount is not positive");
	}
	
	@Test
	void testAddMoneyAmountNegative() {
		assertThrows(Exception.class, () -> {
			mbaseMoney.add(new Money(-20, "EUR"));
	    }, "amount is not positive");
	}
}