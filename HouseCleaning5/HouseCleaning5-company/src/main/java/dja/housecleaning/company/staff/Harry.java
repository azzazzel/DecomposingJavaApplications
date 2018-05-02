package dja.housecleaning.company.staff;

import org.joda.money.Money;

import dja.housecleaning.company.assets.Software;
import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.shared.CleaningInstructions;

class Harry implements Cleaner, Accountant {

	public static final Harry PERSON = new Harry();

	private Harry() {
	}
	
	@Override
	public void recordIncome(Money money) {
		Software.companyBookkepingsystem.recordIncome(money.getAmount().doubleValue());
	}

	
	public void cleanHouse (CleaningInstructions instructions) {
		System.out.println("Harry: cleaning 💦");
		System.out.println("Harry: done cleaning 🌟");
	}


}
