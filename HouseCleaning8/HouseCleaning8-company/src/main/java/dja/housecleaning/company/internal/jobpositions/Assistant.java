package dja.housecleaning.company.internal.jobpositions;

import java.util.List;

import dja.housecleaning.company.Employee;
import dja.housecleaning.company.internal.policies.CleaningInstructions;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public interface Assistant extends Employee {

	List<CleaningSupply> getNeededCleaningSupplies(CleaningInstructions instructions);

	List<CleaningTool> getNeededCleaningTools(CleaningInstructions instructions);

	void putCleaningSuppliesToStorage (List<CleaningSupply> cleaningSupplies);

	void putCleaningToolsInStorage (List<CleaningTool> cleaningTools);
}
