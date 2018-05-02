package dja.housecleaning.company.processes;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.shared.CleaningInstructions;
import other.things.CleaningSupply;
import other.things.CleaningTool;

@ProviderType
public interface PrepareForCleaningProcess {

	Cleaner selectCleaner(CleaningInstructions instructions);

	List<CleaningSupply> getCleaningSupplies (CleaningInstructions instructions);

	List<CleaningTool> getCleaningTools (CleaningInstructions instructions);
}
