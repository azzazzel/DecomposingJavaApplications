package dja.housecleaning.frontoffice;

import org.joda.money.Money;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import dja.housecleaning.frontoffice.internal.FrontOfficeCleaningRequest;
import dja.housecleaning.usecases.CleaningRequest;
import dja.housecleaning.usecases.CustomerUsecases;

@Component (service=FrontOffice.class)
public class FrontOffice {

	@Reference
	CustomerUsecases customerUsecases;

	
	public void pleaseCleanMyHouse (OrderForm orderForm, double money, String curency) {
		 Money payment = Money.parse(curency +  " " + money);	
		 
		 CleaningRequest cleaningRequest = new FrontOfficeCleaningRequest(
				 orderForm.getAddress(), 
				 orderForm.getInstructions(), 
				 payment);
		 
		 customerUsecases.cleanCustomerHouse(cleaningRequest);
	}
}
