package dja.housecleaning.company.internal.staff;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.internal.shared.InternalCleaningInstruction;
import dja.housecleaning.company.internal.shared.InternalCleaningInstructions;
import dja.housecleaning.company.internal.shared.PricingPolicy;
import dja.housecleaning.company.jobpositions.Receptionist;
import dja.housecleaning.company.shared.CleaningInstructions;
import dja.housecleaning.company.shared.InsufficientAmountException;

class Ronald implements Receptionist {

	public static final Ronald PERSON = new Ronald();

	private Ronald() {
	}
	
	@Override
	public void recievePayment(Money money) throws InsufficientAmountException{
		System.out.println("Ronald: checking payment");
		if (money.isLessThan(PricingPolicy.sevicePrice)) {
			throw new InsufficientAmountException(PricingPolicy.sevicePrice, money);
		}
	}

	@Override
	public CleaningInstructions prepareCleaningInstructions(String address, List<String> instructions) {
		System.out.println("Ronald: preparing cleaning instructions");
		InternalCleaningInstructions cleaningInstructions = new InternalCleaningInstructions();
		cleaningInstructions.address = address;
		for (String instruction : instructions) {
			if (instruction.isEmpty()) {
				cleaningInstructions.instructions.add(new InternalCleaningInstruction(/* parse and create proper instruction */)); 
			}
		}
		return cleaningInstructions;
	}

}
