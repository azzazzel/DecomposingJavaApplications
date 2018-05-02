package dja.housecleaning.company.staff;

import org.joda.money.Money;

import dja.housecleaning.company.HouseCleaning;
import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.CleaningInstructions;

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
