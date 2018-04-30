package dja.housecleaning.company.internal.staff;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.internal.policies.CleaningInstructions;
import dja.housecleaning.company.internal.policies.PricingPolicy;
import dja.housecleaning.company.processes.InsufficientAmountException;
import dja.housecleaning.company.internal.jobpositions.Receptionist;

public class Ronald implements Receptionist {

	public static final Ronald PERSON = new Ronald();

	private Ronald() {
	}
	
	@Override
	public void recievePayment(Money money) throws InsufficientAmountException{
		if (money.isLessThan(PricingPolicy.sevicePrice)) {
			throw new InsufficientAmountException(PricingPolicy.sevicePrice, money);
		}
	}

	@Override
	public CleaningInstructions prepareCleaningInstructions(String address, List<String> instructions) {
		
		CleaningInstructions cleaningInstructions = new CleaningInstructions();
		cleaningInstructions.address = address;
		for (String instruction : instructions) {
			if (instruction.isEmpty()) {
				cleaningInstructions.instructions.add(new CleaningInstructions.Instruction(/* parse and create proper instruction */)); 
			}
		}
		return cleaningInstructions;
	}

}
