package dja.housecleaning.company.internal.jobpositions;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.Employee;
import dja.housecleaning.company.internal.policies.CleaningInstructions;
import dja.housecleaning.company.processes.InsufficientAmountException;

public interface Receptionist extends Employee {

	void recievePayment(Money money) throws InsufficientAmountException;
	
	CleaningInstructions prepareCleaningInstructions(String address, List<String> instructions);
	
}
