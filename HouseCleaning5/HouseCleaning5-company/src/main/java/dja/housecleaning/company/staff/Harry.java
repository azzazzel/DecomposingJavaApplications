package dja.housecleaning.company.staff;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.assets.Software;
import dja.housecleaning.company.assets.Storage;
import dja.housecleaning.company.assets.Vehicles;
import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.shared.CleaningInstructions;
import other.things.CleaningTool;
import other.things.Van;

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

	public Van borrowVan (String who) {
		if ("friend".equals(who)) {
			System.out.println("Harry: Here is my 🚚️");
			return Vehicles.companyVan;
		}
		System.out.println("Harry: I'm sorry but I don't know you!");
		return null;
	}

	public List<CleaningTool> borrowTools (String who) {
		if ("friend".equals(who)) {
			System.out.println("Harry: Here are my 🛠️");
			return Storage.PLACE.getCleaningTools();
		}
		System.out.println("Harry: I'm sorry but I don't know you!");
		return null;
	}

	@Override
	public String toString() {
		return "Harry";
	}
}
