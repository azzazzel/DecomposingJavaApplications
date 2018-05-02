package dja.housecleaning.usecases;

import java.util.List;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.NewOrderProcess;
import dja.housecleaning.company.processes.PrepareForCleaningProcess;
import dja.housecleaning.company.processes.TransportProcess;
import dja.housecleaning.company.shared.CleaningInstructions;
import dja.housecleaning.company.shared.InsufficientAmountException;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public class CustomerUsecases {

	public static CustomerUsecases GET = new CustomerUsecases();

	public void cleanCustomerHouse(CleaningRequest cleaningRequest) {

		NewOrderProcess newOrderProcess = new NewOrderProcess();
		PrepareForCleaningProcess prepareForCleaningProcess = new PrepareForCleaningProcess();
		CleanHouseProcess cleanHouseProcess = new CleanHouseProcess();
		TransportProcess transportProcess = new TransportProcess();

		// check customer's order  
		try {
			newOrderProcess.checkPayment(cleaningRequest.getPayment());
		} catch (InsufficientAmountException e) {
			cleaningRequest.fixPayment(e.getExpected(), e.getReceived());
			return;
		}

		CleaningInstructions cleaningInstructions = newOrderProcess.prepareInstructions(cleaningRequest.getAddress(),
				cleaningRequest.getInstructions());
		
		// prepare   
		List<CleaningSupply> supplies = prepareForCleaningProcess.getCleaningSupplies(cleaningInstructions);
		List<CleaningTool> tools = prepareForCleaningProcess.getCleaningTools(cleaningInstructions);
		Cleaner cleaner = prepareForCleaningProcess.selectCleaner(cleaningInstructions);

		// send cleaner   
		transportProcess.goTo(cleaningRequest.getAddress(), cleaner, supplies, tools);

		// clean   
		cleanHouseProcess.cleanHouse(cleaner, cleaningInstructions);

		// make sure the cleaner can go back   
		transportProcess.goTo("office", cleaner, supplies, tools);
	}

}
