package dja.housecleaning;

import java.util.List;

import other.things.BookkeepingSystem;
import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;
import other.things.Van;

class Harry {

	public static final Harry PERSON = new Harry();

	private BookkeepingSystem bookkeepingSystem = new BookkeepingSystem();
	
	private Harry() {
		Garage garage = Garage.PLACE;
		garage.add(new CleaningTool("vaccume cleaner"));
		garage.add(new CleaningTool("floor mop"));
		garage.add(new CleaningTool("glass wiper"));
		// ... 
		garage.add(CleaningSupplyStore.purchase("carpet cleaner"));
		garage.add(CleaningSupplyStore.purchase("wood cleaner"));
		garage.add(CleaningSupplyStore.purchase("glass cleaner"));
		// ... 
	}		
			
	public void cleanHouseOrder (String address, String instructions, double money) {
		if (money < 100) {
			System.out.println("Harry: You need to pay me more!");
			return;
		}
		Garage garage = Garage.PLACE;
		
		List<CleaningTool> neededCleaningTools = garage.getNeededCleaningTools(instructions);
		List<CleaningSupply> neededCleaningSupplies = garage.getNeededCleaningSupplies(instructions);
		
		Van myVan = garage.getVan();
		myVan.load(neededCleaningTools);
		myVan.load(neededCleaningSupplies);
		myVan.addPassenger(this);
		myVan.drive(address);
		
		System.out.println("Harry: cleaning 💦");
		System.out.println("Harry: done cleaning 🌟");

		myVan.load(neededCleaningTools);
		myVan.load(neededCleaningSupplies);
		myVan.addPassenger(this);
		myVan.drive("back to my office");
		
		System.out.println("Harry: Checking supplies ");
		for (CleaningSupply cleaningSupply : neededCleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				// purchase 
			}
		}

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
			return Garage.PLACE.getCleaningTools();
		}
		System.out.println("Harry: I'm sorry but I don't know you!");
		return null;
	}

	@Override
	public String toString() {
		return "Harry";
	}

}
