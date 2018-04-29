package dja.housecleaning.company.internal.processes;

import org.joda.money.Money;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.internal.jobpositions.Accountant;
import dja.housecleaning.company.internal.jobpositions.Receptionist;
import dja.housecleaning.company.processes.InsufficientAmountException;
import dja.housecleaning.company.processes.ReceivePaymentProcess;

public class InternalReceivePaymentProcess implements ReceivePaymentProcess {

	public void process(Money money) throws InsufficientAmountException {
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		receptionist.recievePayment(money);
		Accountant accountant = HouseCleaning.COMPANY.getAccountant();
		accountant.recordIncome(money);
	}
}
