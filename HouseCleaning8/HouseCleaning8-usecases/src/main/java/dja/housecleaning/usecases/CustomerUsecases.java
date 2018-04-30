package dja.housecleaning.usecases;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.InsufficientAmountException;
import dja.housecleaning.company.processes.ReceivePaymentProcess;

public class CustomerUsecases {

	ServiceTracker<ReceivePaymentProcess, ReceivePaymentProcess> receivePaymentProcessTracker;
	ServiceTracker<CleanHouseProcess, CleanHouseProcess> cleanHouseProcessesTracker;

	public static CustomerUsecases GET = new CustomerUsecases();

	public CustomerUsecases() {
		BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		receivePaymentProcessTracker = new ServiceTracker<>(context, ReceivePaymentProcess.class, null);
		receivePaymentProcessTracker.open();	
		
		cleanHouseProcessesTracker  = new ServiceTracker<>(context, CleanHouseProcess.class, null);
		cleanHouseProcessesTracker.open();
	}
	
	public void cleanCustomerHouse (CleaningRequest cleaningRequest) {
		
		ReceivePaymentProcess receivePaymentProcess  = receivePaymentProcessTracker.getService();
		if (receivePaymentProcess == null) {
			throw new RuntimeException("Uhhh seems like out payment process is missing 😢");
		}
				
		boolean sucessfulPayment = false;
		do {
			try {
				receivePaymentProcess.process(cleaningRequest.getPayment());
				sucessfulPayment = true;
			} catch (InsufficientAmountException e) {
				cleaningRequest.fixPayment(e.getExpected(), e.getReceived());
			}
		} while (!sucessfulPayment);
		
		CleanHouseProcess cleanHouseProcess = cleanHouseProcessesTracker.getService();
		if (cleanHouseProcess == null) {
			throw new RuntimeException("Uhhh seems like out cleaning process is missing 😢");
		}
		cleanHouseProcess.cleanHouse(cleaningRequest.getAddress(), cleaningRequest.getInstructions());
	}

//	public void cleanCustomerHouseForFree (String address, List<String> instructions) {
//		 CleanHouseProcess cleanHouseProcess = new CleanHouseProcess();
//		 cleanHouseProcess.cleanHouse(address, instructions);
//	}
}
