package dja.housecleaning.company.shared;

import org.joda.money.Money;

public class InsufficientAmountException extends Exception {

	Money expected;
	
	Money received;

	public InsufficientAmountException(Money expected, Money received) {
		super();
		this.expected = expected;
		this.received = received;
	}

	public Money getExpected() {
		return expected;
	}

	public Money getReceived() {
		return received;
	} 
}
