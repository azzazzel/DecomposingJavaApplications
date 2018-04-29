package dja.housecleaning.test;

import org.junit.Test;

import dja.housecleaning.company.HouseCleaning;
import dja.housecleaning.company.assets.Storage;
import dja.housecleaning.company.policies.CleaningInstructions;
import dja.housecleaning.company.staff.HarryHouse;
import dja.housecleaning.frontoffice.FrontOffice;
import dja.housecleaning.frontoffice.OrderForm;
import other.things.Van;


public class TestHauseCleaning {

	@Test
	public void howItWorks() {
		
		System.out.println("--------------------");
		System.out.println("official way ...");
		System.out.println("--------------------");
		FrontOffice frontOffice = FrontOffice.PLACE;
		OrderForm orderForm = new OrderForm();
		orderForm.setAddress("some street");
		orderForm.addInstruction("clean the floors");
		orderForm.addInstruction("clean the windows");
		orderForm.addInstruction("...");
		frontOffice.pleaseCleanMyHouse(orderForm, 100, "EUR");
		
	}

	@Test
	public void howItShouldNotWork() {

		// figure out how to prepare proper cleaningInstructions
		CleaningInstructions cleaningInstructions = new CleaningInstructions();

		// then call Harry
		System.out.println("--------------------");
		System.out.println("call Harry ...");
		System.out.println("--------------------");
		HarryHouse harryHouse = HarryHouse.PERSON;
		harryHouse.cleanHouse(cleaningInstructions);
		
		// or any cleaner
		System.out.println("--------------------");
		System.out.println("call any cleaner ...");
		System.out.println("--------------------");
		HouseCleaning.COMPANY.getCleaner().cleanHouse(cleaningInstructions);
		
	}

	@Test
	public void dontMessWithMyStorage() {

		Storage storage = HouseCleaning.COMPANY.getStorage();
		storage.cleaningSupplies.get(0);

		System.out.println("--------------------");
		System.out.println("oops I just messed up with your storage ...");
		System.out.println("--------------------");

	}

	@Test
	public void dontMessWithMyVan() {

		Van companyVan = HouseCleaning.COMPANY.getCompanyVan();
		companyVan.drive("some place");

		System.out.println("--------------------");
		System.out.println("oops I just went somewhere with your van ...");
		System.out.println("--------------------");

	}

}
