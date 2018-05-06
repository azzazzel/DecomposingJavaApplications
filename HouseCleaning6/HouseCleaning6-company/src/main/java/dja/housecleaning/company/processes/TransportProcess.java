package dja.housecleaning.company.processes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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

	public boolean isVanFunctional() {
		boolean vanIsFunctional = false;
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("user.dir") + "/status"));
			vanIsFunctional = Boolean.valueOf(properties.getProperty("van.functional", "false"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vanIsFunctional;
	}
}
