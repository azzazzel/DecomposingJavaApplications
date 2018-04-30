package dja.housecleaning.company.processes;

import java.util.List;

import dja.housecleaning.company.jobpositions.Cleaner;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public interface TransportProcess {

	boolean isCurrentlyAvailable();
	
	void goTo(String address, Cleaner cleaner, List<CleaningSupply> supplies, List<CleaningTool> tools);

	int priority ();
}