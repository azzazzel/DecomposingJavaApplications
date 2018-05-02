package dja.housecleaning.company.processes;

import java.util.List;

import dja.housecleaning.company.jobpositions.Assistant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.staff.Staff;
import other.things.CleaningSupply;
import other.things.CleaningTool;


public class PrepareForCleaningProcess {

	private Staff staff = Staff.ALL; 

	public Cleaner selectCleaner(CleaningInstructions instructions) {
		// some process here
		return staff.getCleaner();
	}

	public List<CleaningSupply> getCleaningSupplies(CleaningInstructions instructions) {
		Assistant assistant = staff.getAssistant();
		return assistant.getNeededCleaningSupplies(instructions);
	}

	public List<CleaningTool> getCleaningTools(CleaningInstructions instructions) {
		Assistant assistant = staff.getAssistant();
		return assistant.getNeededCleaningTools(instructions);
	}

}
