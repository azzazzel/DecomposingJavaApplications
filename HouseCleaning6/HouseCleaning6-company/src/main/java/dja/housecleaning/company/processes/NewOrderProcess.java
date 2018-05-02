package dja.housecleaning.company.processes;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.internal.staff.Staff;
import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Receptionist;
import dja.housecleaning.company.shared.CleaningInstructions;
import dja.housecleaning.company.shared.InsufficientAmountException;


public class NewOrderProcess {

	private Staff staff = Staff.ALL; 

	public void checkPayment(Money money) throws InsufficientAmountException {
		Receptionist receptionist = staff.getReceptionist();
		receptionist.recievePayment(money);
		Accountant accountant = staff.getAccountant();
		accountant.recordIncome(money);
		
	}

	public CleaningInstructions prepareInstructions(String address, List<String> clientInstructions) {
		Receptionist receptionist = staff.getReceptionist();
		return receptionist.prepareCleaningInstructions(address, clientInstructions);
	}
}
