package dja.housecleaning.usecases;

import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.CleaningInstructions;
import dja.housecleaning.company.processes.InsufficientAmountException;
import dja.housecleaning.company.processes.NewOrderProcess;
import dja.housecleaning.company.processes.PrepareForCleaningProcess;
import dja.housecleaning.company.processes.TransportProcess;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public class CustomerUsecases {

	public static CustomerUsecases GET = new CustomerUsecases();
	
	public void cleanCustomerHouse (CleaningRequest cleaningRequest) {
		
		ServiceLoader<NewOrderProcess> newOrderProcessLoader = ServiceLoader.load(NewOrderProcess.class); 
		NewOrderProcess newOrderProcess  = newOrderProcessLoader.findFirst()
				.orElseThrow(() -> new RuntimeException("Uhhh seems like out new order process is missing 😢"));

		ServiceLoader<CleanHouseProcess> cleanHouseProcessLoader = ServiceLoader.load(CleanHouseProcess.class); 
		CleanHouseProcess cleanHouseProcess  = cleanHouseProcessLoader.findFirst()
				.orElseThrow(() -> new RuntimeException("Uhhh seems like out cleaning process is missing 😢"));

		ServiceLoader<PrepareForCleaningProcess> prepareForCleaningProcessLoader = ServiceLoader.load(PrepareForCleaningProcess.class); 
		PrepareForCleaningProcess prepareForCleaningProcess = prepareForCleaningProcessLoader.findFirst()
				.orElseThrow(() -> new RuntimeException("Uhhh seems like out prepare cleaning process is missing 😢"));
		
		ServiceLoader<TransportProcess> transportProcessLoader = ServiceLoader.load(TransportProcess.class); 
		TransportProcess transportProcess = transportProcessLoader.stream()
				.map(provider -> provider.get())
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
