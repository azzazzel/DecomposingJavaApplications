package dja.housecleaning.company.processes;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

import dja.housecleaning.company.jobpositions.Cleaner;
import other.things.CleaningSupply;
import other.things.CleaningTool;

@ProviderType
public interface TransportProcess {

	boolean isCurrentlyAvailable();
	
	void goTo(String address, Cleaner cleaner, List<CleaningSupply> supplies, List<CleaningTool> tools);

	int priority ();

//	int status ();

}