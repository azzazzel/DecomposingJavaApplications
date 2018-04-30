package dja.housecleaning.company.internal.processes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.osgi.service.component.annotations.Component;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.TransportProcess;
import other.things.CleaningSupply;
import other.things.CleaningTool;
import other.things.Van;

@Component
public class InternalTransportProcess implements TransportProcess {

	Van companyVan;

	public InternalTransportProcess() {
		companyVan = HouseCleaning.COMPANY.getCompanyVan();
	}

	@Override
	public void goTo(String address, Cleaner cleaner, List<CleaningSupply> supplies, List<CleaningTool> tools) {
		companyVan.load(supplies);
		companyVan.load(tools);
		companyVan.addPassenger(cleaner);
		companyVan.drive(address);
	}

	@Override
	public boolean isCurrentlyAvailable() {
		boolean vanIsFunctional = false;
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("user.dir") + "/status"));
			vanIsFunctional = Boolean.valueOf(properties.getProperty("van.functional", "false"));
		} catch (IOException e) {
		}

		return vanIsFunctional;
	}

	@Override
	public int priority() {
		return 1;
	}

//	@Override
//	public int status() {
//		return 0;
//	}
}
