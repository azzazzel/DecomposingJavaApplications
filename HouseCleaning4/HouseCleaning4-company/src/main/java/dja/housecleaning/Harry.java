package dja.housecleaning;

import java.util.ArrayList;
import java.util.List;

import dja.housecleaning.backoffice.Andrey;
import dja.housecleaning.backoffice.Storage;
import other.things.BookkeepingSystem;
import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;
import other.things.Van;

public class Harry {

	public static final Harry PERSON = new Harry();

	private BookkeepingSystem bookkeepingSystem = new BookkeepingSystem();
	
	private Andrey andrey = Andrey.PERSON;

	private Garage garage = Garage.PLACE;

	private Harry() {
	}		
			
	public void cleanHouseOrder (String address, String instructions, double money) {
		if (money < 100) {
			System.out.println("You need to pay me more!");
			return;
		}
		
		List<CleaningTool> neededCleaningTools = andrey.getNeededCleaningTools(instructions);
		List<CleaningSupply> neededCleaningSupplies = andrey.getNeededCleaningSupplies(instructions);
		
		Van myVan = garage.getVan();
		myVan.load(neededCleaningTools);
		myVan.load(neededCleaningSupplies);
		myVan.addPassenger(this);
		myVan.drive(address);
		
		System.out.println("Harry: cleaning 💦");
		System.out.println("Harry: done cleaning 🌟");

		myVan.load(neededCleaningSupplies);
		myVan.load(neededCleaningSupplies);
		myVan.addPassenger(this);
		myVan.drive("back to my office");
		
		andrey.storeCleaningSupplies(neededCleaningSupplies);
		andrey.storeCleaningTools(neededCleaningTools);
		
		bookkeepingSystem.recordIncome(money);
	}

	public Van borrowVan (String who) {
		if ("friend".equals(who)) {
			System.out.println("Harry: Here is my 🚚️");
			return Garage.PLACE.getVan();	
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
