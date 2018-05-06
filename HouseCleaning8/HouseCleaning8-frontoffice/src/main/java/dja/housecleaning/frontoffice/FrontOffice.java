package dja.housecleaning.frontoffice;

import java.util.List;

import org.joda.money.Money;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import dja.housecleaning.company.internal.assets.Storage;
import dja.housecleaning.company.internal.assets.Vehicles;
import dja.housecleaning.frontoffice.internal.FrontOfficeCleaningRequest;
import dja.housecleaning.usecases.CleaningRequest;
import dja.housecleaning.usecases.CustomerUsecases;
import other.things.CleaningTool;
import other.things.Van;

@Component (service=FrontOffice.class)
public class FrontOffice {

	@Reference
	CustomerUsecases customerUsecases;


	public void cleanMyHousePlease(OrderForm orderForm, String money) {
		Money payment = Money.parse(money);

		CleaningRequest cleaningRequest = new FrontOfficeCleaningRequest(orderForm.getAddress(),
				orderForm.getInstructions(), payment);

		customerUsecases.cleanCustomerHouse(cleaningRequest);
	}

	public Van borrowVan(String who) {
		// return Vehicles.companyVan;
		throw new UnsupportedOperationException();
	}

	public List<CleaningTool> borrowTools(String who) {
		// return Storage.PLACE.getCleaningTools();
		throw new UnsupportedOperationException();
	}

}
