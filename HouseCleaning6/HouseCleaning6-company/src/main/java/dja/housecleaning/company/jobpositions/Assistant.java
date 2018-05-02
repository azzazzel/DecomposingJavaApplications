package dja.housecleaning.company.jobpositions;

import java.util.List;

import dja.housecleaning.company.shared.CleaningInstructions;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public interface Assistant {

	List<CleaningSupply> getNeededCleaningSupplies(CleaningInstructions instructions);

	List<CleaningTool> getNeededCleaningTools(CleaningInstructions instructions);

	void storeCleaningTools(List<CleaningTool> cleaningTools);

	void storeCleaningSupplies(List<CleaningSupply> cleaningSupplies);
}
