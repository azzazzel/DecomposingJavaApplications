package dja.housecleaning.frontoffice;

import org.joda.money.Money;

import dja.housecleaning.usecases.CustomerUsecases;

public class FrontOffice {

	public static final FrontOffice PLACE = new FrontOffice();

	private FrontOffice() {
	}
	
	public void pleaseCleanMyHouse (OrderForm orderForm, double money, String curency) {
		 Money m = Money.parse(curency +  " " + money);	
		 CustomerUsecases.GET.cleanCustomerHouse(m, orderForm.getAddress(), orderForm.getInstructions());
	}
}
