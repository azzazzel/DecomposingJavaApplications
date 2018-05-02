package dja.housecleaning.company.processes;

import java.util.List;

import dja.housecleaning.company.internal.assets.Vehicles;
import dja.housecleaning.company.jobpositions.Cleaner;
import other.things.CleaningSupply;
import other.things.CleaningTool;
import other.things.Van;

public class TransportProcess {

	private Van companyVan;

	public TransportProcess() {
		companyVan = Vehicles.companyVan;
	}

	public void goTo(String address, Cleaner cleaner, List<CleaningSupply> supplies, List<CleaningTool> tools) {
		companyVan.load(supplies);
		companyVan.load(tools);
		companyVan.addPassenger(cleaner);
		companyVan.drive(address);
	}


}
