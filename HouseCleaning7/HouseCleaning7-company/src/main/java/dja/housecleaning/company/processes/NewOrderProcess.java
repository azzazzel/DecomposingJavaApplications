package dja.housecleaning.company.processes;

import java.util.List;

import org.joda.money.Money;

public interface NewOrderProcess {

	void checkPayment (Money money) throws InsufficientAmountException;

	CleaningInstructions prepareInstructions (String address, List<String> clientInstructions);

}