package dja.housecleaning.company.internal.processes;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Receptionist;
import dja.housecleaning.company.processes.CleaningInstructions;
import dja.housecleaning.company.processes.InsufficientAmountException;
import dja.housecleaning.company.processes.NewOrderProcess;


public class InternalNewOrderProcess implements NewOrderProcess {


	@Override
	public void checkPayment(Money money) throws InsufficientAmountException {
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		receptionist.recievePayment(money);
		Accountant accountant = HouseCleaning.COMPANY.getAccountant();
		accountant.recordIncome(money);
		
	}

	@Override
	public CleaningInstructions prepareInstructions(String address, List<String> clientInstructions) {
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		return receptionist.prepareCleaningInstructions(address, clientInstructions);
	}
}
