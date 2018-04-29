package dja.housecleaning.company.processes;

import org.joda.money.Money;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.internal.jobpositions.Accountant;
import dja.housecleaning.company.internal.jobpositions.Receptionist;

public class ReceivePaymentProcess {

	public boolean process (Money money) {
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		boolean paymentProcessed = receptionist.recievePayment(money);
		if (paymentProcessed) {
			Accountant accountant = HouseCleaning.COMPANY.getAccountant();
			accountant.recordIncome(money);
		} else {
			// notify manager 
		}
		return paymentProcessed;
	}
}
