package dja.housecleaning.usecases;

import java.util.ServiceLoader;

import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.InsufficientAmountException;
import dja.housecleaning.company.processes.ReceivePaymentProcess;

public class CustomerUsecases {

	public static CustomerUsecases GET = new CustomerUsecases();
	
	public void cleanCustomerHouse (CleaningRequest cleaningRequest) {
		
		ServiceLoader<ReceivePaymentProcess> receivePaymentProcessLoader = ServiceLoader.load(ReceivePaymentProcess.class); 
		ServiceLoader<CleanHouseProcess> cleanHouseProcessLoader = ServiceLoader.load(CleanHouseProcess.class); 

		ReceivePaymentProcess receivePaymentProcess  = receivePaymentProcessLoader.findFirst()
				.orElseThrow(() -> new RuntimeException("Uhhh seems like out payment process is missing 😢"));

		
		boolean sucessfulPayment = false;
		do {
			try {
				receivePaymentProcess.process(cleaningRequest.getPayment());
				sucessfulPayment = true;
			} catch (InsufficientAmountException e) {
				cleaningRequest.fixPayment(e.getExpected(), e.getReceived());
			}
		} while (!sucessfulPayment);
		
		CleanHouseProcess cleanHouseProcess = cleanHouseProcessLoader.findFirst()
				.orElseThrow(() -> new RuntimeException("Uhhh seems like out cleaning process is missing 😢"));
		cleanHouseProcess.cleanHouse(cleaningRequest.getAddress(), cleaningRequest.getInstructions());
	}

//	public void cleanCustomerHouseForFree (String address, List<String> instructions) {
//		 CleanHouseProcess cleanHouseProcess = new CleanHouseProcess();
//		 cleanHouseProcess.cleanHouse(address, instructions);
//	}
}
