package dja.housecleaning.company.internal.staff;

import org.joda.money.Money;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.internal.jobpositions.Accountant;
import dja.housecleaning.company.internal.policies.CleaningInstructions;
import dja.housecleaning.company.internal.jobpositions.Cleaner;

public class HarryHouse implements Cleaner, Accountant {

	public static final HarryHouse PERSON = new HarryHouse();

	private HarryHouse() {
	}
	
	@Override
	public void recordIncome(Money money) {
		HouseCleaning.COMPANY.getBookkeepingSystem().recordIncome(money.getAmount().doubleValue());
	}

	
	public void cleanHouse (CleaningInstructions instructions) {
		System.out.println("started cleaning");
		// your cleaning "business logic" here
		System.out.println("done cleaning");
	}


}
