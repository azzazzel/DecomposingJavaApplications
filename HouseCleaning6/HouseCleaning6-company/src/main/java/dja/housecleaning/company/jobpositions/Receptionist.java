package dja.housecleaning.company.jobpositions;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.shared.CleaningInstructions;
import dja.housecleaning.company.shared.InsufficientAmountException;

public interface Receptionist {

	void recievePayment(Money money) throws InsufficientAmountException;
	
	CleaningInstructions prepareCleaningInstructions(String address, List<String> instructions);
	
}
