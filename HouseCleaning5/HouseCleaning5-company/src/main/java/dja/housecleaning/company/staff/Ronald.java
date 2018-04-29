package dja.housecleaning.company.staff;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.jobpositions.Receptionist;
import dja.housecleaning.company.policies.CleaningInstructions;
import dja.housecleaning.company.policies.PricingPolicy;

public class Ronald implements Receptionist {

	public static final Ronald PERSON = new Ronald();

	private Ronald() {
	}
	
	@Override
	public boolean recievePayment(Money money) {
		if (!money.isLessThan(PricingPolicy.sevicePrice)) {
			return true;
		}
		return false;
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
