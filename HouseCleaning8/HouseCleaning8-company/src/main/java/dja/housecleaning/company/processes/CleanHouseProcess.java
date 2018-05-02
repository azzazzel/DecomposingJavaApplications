package dja.housecleaning.company.processes;

import org.osgi.annotation.versioning.ProviderType;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.shared.CleaningInstructions;

@ProviderType
public interface CleanHouseProcess {

	void cleanHouse(Cleaner cleaner, CleaningInstructions cleaningInstructions);

}