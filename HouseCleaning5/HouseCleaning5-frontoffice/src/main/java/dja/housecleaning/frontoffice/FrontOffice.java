package dja.housecleaning.frontoffice;

import org.joda.money.Money;

import dja.housecleaning.usecases.CleaningRequest;
import dja.housecleaning.usecases.CustomerUsecases;

public class FrontOffice {

	public static final FrontOffice PLACE = new FrontOffice();

	private FrontOffice() {
	}
	
	public void pleaseCleanMyHouse (OrderForm orderForm, double money, String curency) {
		 Money payment = Money.parse(curency +  " " + money);	
		 
		 CleaningRequest cleaningRequest = new FrontOfficeCleaningRequest(
				 orderForm.getAddress(), 
				 orderForm.getInstructions(), 
				 payment);
		 
		 CustomerUsecases.GET.cleanCustomerHouse(cleaningRequest);	
	}
}
