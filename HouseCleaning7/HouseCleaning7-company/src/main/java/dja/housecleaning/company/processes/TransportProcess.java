package dja.housecleaning.company.processes;

import java.util.List;

import dja.housecleaning.company.Employee;
import dja.housecleaning.company.internal.jobpositions.Cleaner;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public interface TransportProcess {

	boolean isCurrentlyAvailable();
	
	void goTo(String address, Employee cleaner, List<CleaningSupply> supplies, List<CleaningTool> tools);

}