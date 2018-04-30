package dja.housecleaning.usecases;

import java.util.Comparator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.CleaningInstructions;
import dja.housecleaning.company.processes.InsufficientAmountException;
import dja.housecleaning.company.processes.NewOrderProcess;
import dja.housecleaning.company.processes.PrepareForCleaningProcess;
import dja.housecleaning.company.processes.TransportProcess;
import other.things.CleaningSupply;
import other.things.CleaningTool;

@Component (service=CustomerUsecases.class)
public class CustomerUsecases {

	@Reference CleanHouseProcess cleanHouseProcess;
	@Reference NewOrderProcess newOrderProcess;
	@Reference PrepareForCleaningProcess prepareForCleaningProcess;
	@Reference (policy = ReferencePolicy.DYNAMIC) volatile List<TransportProcess> transportProcesses;
	
	public void cleanCustomerHouse (CleaningRequest cleaningRequest) {
		
		if (newOrderProcess == null) {
			throw new RuntimeException("Uhhh seems like out new order process is missing 😢");
		}

		if (prepareForCleaningProcess == null) {
			throw new RuntimeException("Uhhh seems like out prepare cleaning process is missing 😢");
		}
		
		if (cleanHouseProcess == null) {
			throw new RuntimeException("Uhhh seems like out cleaning process is missing 😢");
		}

		TransportProcess transportProcess = transportProcesses.stream()
				.sorted(Comparator.comparing(TransportProcess::priority))
				.filter(process -> process.isCurrentlyAvailable())
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Uhhh seems like out transport process is missing! No way to go to the client 😢"));
		
		boolean sucessfulPayment = false;
		do {
			try {
				newOrderProcess.checkPayment(cleaningRequest.getPayment());
				sucessfulPayment = true;
			} catch (InsufficientAmountException e) {
				cleaningRequest.fixPayment(e.getExpected(), e.getReceived());
			}
		} while (!sucessfulPayment);
		
		CleaningInstructions cleaningInstructions = newOrderProcess.prepareInstructions(cleaningRequest.getAddress(), cleaningRequest.getInstructions());
		List<CleaningSupply> supplies = prepareForCleaningProcess.getCleaningSupplies(cleaningInstructions);
		List<CleaningTool> tools = prepareForCleaningProcess.getCleaningTools(cleaningInstructions);
		Cleaner cleaner = prepareForCleaningProcess.selectCleaner(cleaningInstructions);
		transportProcess.goTo(cleaningRequest.getAddress(), cleaner, supplies, tools);
		cleanHouseProcess.cleanHouse(cleaner, cleaningInstructions);
		transportProcess.goTo("office", cleaner, supplies, tools);
	}

}
