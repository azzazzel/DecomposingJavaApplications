package dja.housecleaning.company.jobpositions;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.policies.CleaningInstructions;

public interface Receptionist {

	boolean recievePayment(Money money);
	
	CleaningInstructions prepareCleaningInstructions(String address, List<String> instructions);
	
}
