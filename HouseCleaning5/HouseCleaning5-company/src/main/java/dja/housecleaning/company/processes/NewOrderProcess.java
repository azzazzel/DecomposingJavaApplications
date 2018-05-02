package dja.housecleaning.company.processes;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.HouseCleaning;
import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Receptionist;


public class NewOrderProcess {


	public void checkPayment(Money money) throws InsufficientAmountException {
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		receptionist.recievePayment(money);
		Accountant accountant = HouseCleaning.COMPANY.getAccountant();
		accountant.recordIncome(money);
		
	}

	public CleaningInstructions prepareInstructions(String address, List<String> clientInstructions) {
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		return receptionist.prepareCleaningInstructions(address, clientInstructions);
	}
}
