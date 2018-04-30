package dja.housecleaning.company.processes;

import org.joda.money.Money;

public interface ReceivePaymentProcess {

	void process (Money money) throws InsufficientAmountException;
	
}