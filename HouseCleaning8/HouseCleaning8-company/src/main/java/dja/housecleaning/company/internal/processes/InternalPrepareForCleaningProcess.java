package dja.housecleaning.company.internal.processes;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import dja.housecleaning.company.internal.staff.Staff;
import dja.housecleaning.company.jobpositions.Assistant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.PrepareForCleaningProcess;
import dja.housecleaning.company.shared.CleaningInstructions;
import other.things.CleaningSupply;
import other.things.CleaningTool;

@Component
public class InternalPrepareForCleaningProcess implements PrepareForCleaningProcess {

	private Staff staff = Staff.ALL; 

	@Override
	public Cleaner selectCleaner(CleaningInstructions instructions) {
		// some process here
		return staff.getCleaner();
	}

	@Override
	public List<CleaningSupply> getCleaningSupplies(CleaningInstructions instructions) {
		Assistant assistant = staff.getAssistant();
		return assistant.getNeededCleaningSupplies(instructions);
	}

	@Override
	public List<CleaningTool> getCleaningTools(CleaningInstructions instructions) {
		Assistant assistant = staff.getAssistant();
		return assistant.getNeededCleaningTools(instructions);
	}

}
