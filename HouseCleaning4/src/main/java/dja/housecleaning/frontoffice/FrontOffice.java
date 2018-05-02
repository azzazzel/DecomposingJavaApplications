package dja.housecleaning.frontoffice;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.company.assets.Storage;
import dja.housecleaning.company.assets.Vehicles;
import dja.housecleaning.usecases.CleaningRequest;
import dja.housecleaning.usecases.CustomerUsecases;
import other.things.CleaningTool;
import other.things.Van;

public class FrontOffice {

	public static final FrontOffice PLACE = new FrontOffice();

	private FrontOffice() {
	}

	public void cleanMyHousePlease(OrderForm orderForm, String money) {
		Money payment = Money.parse(money);

		CleaningRequest cleaningRequest = new FrontOfficeCleaningRequest(orderForm.getAddress(),
				orderForm.getInstructions(), payment);

		CustomerUsecases.GET.cleanCustomerHouse(cleaningRequest);
	}

	public Van borrowVan(String who) {
		return Vehicles.companyVan;
	}

	public List<CleaningTool> borrowTools(String who) {
		return Storage.PLACE.getCleaningTools();
	}

}
