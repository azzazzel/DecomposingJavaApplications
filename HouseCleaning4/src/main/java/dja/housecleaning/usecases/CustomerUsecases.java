package dja.housecleaning.usecases;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.ReceivePaymentProcess;

public class CustomerUsecases {

	public static CustomerUsecases GET = new CustomerUsecases();
	
	public void cleanCustomerHouse (Money money, String address, List<String> instructions) {
		 ReceivePaymentProcess receivePaymentProcess  = new ReceivePaymentProcess();
		 if (receivePaymentProcess.process(money)) {
			 CleanHouseProcess cleanHouseProcess = new CleanHouseProcess();
			 cleanHouseProcess.cleanHouse(address, instructions);
		 }
	}

//	public void cleanCustomerHouseForFree (String address, List<String> instructions) {
//		 CleanHouseProcess cleanHouseProcess = new CleanHouseProcess();
//		 cleanHouseProcess.cleanHouse(address, instructions);
//	}
}
