package dja.housecleaning.company.internal.processes;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.internal.staff.Staff;
import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Receptionist;
import dja.housecleaning.company.processes.NewOrderProcess;
import dja.housecleaning.company.shared.CleaningInstructions;
import dja.housecleaning.company.shared.InsufficientAmountException;


public class InternalNewOrderProcess implements NewOrderProcess {

	private Staff staff = Staff.ALL; 

	@Override
	public void checkPayment(Money money) throws InsufficientAmountException {
		Receptionist receptionist = staff.getReceptionist();
		receptionist.recievePayment(money);
		Accountant accountant = staff.getAccountant();
		accountant.recordIncome(money);
		
	}

	@Override
	public CleaningInstructions prepareInstructions(String address, List<String> clientInstructions) {
		Receptionist receptionist = staff.getReceptionist();
		return receptionist.prepareCleaningInstructions(address, clientInstructions);
	}
}
