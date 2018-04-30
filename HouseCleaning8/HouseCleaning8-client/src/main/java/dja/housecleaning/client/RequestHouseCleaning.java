package dja.housecleaning.client;


import org.osgi.service.component.annotations.Component;

import dja.housecleaning.frontoffice.FrontOffice;
import dja.housecleaning.frontoffice.OrderForm;


@Component( //
		property = { //
				"osgi.command.function=clean", //
				"osgi.command.scope=hc" //
		}, //
		service = Object.class //
)
public class RequestHouseCleaning {

	public static void main(String[] args) {
		howItWorks();
		howItShouldNotWork();
		dontMessWithMyStorage();
		dontMessWithMyVan();		
	}
	
	public void clean () {
		RequestHouseCleaning.howItWorks();
	}
	
	static void howItWorks() {
		
		System.out.println("Java version is: " + System.getProperty("java.version"));
		
		System.out.println("--------------------");
		System.out.println("official way ...");
		System.out.println("--------------------");
		FrontOffice frontOffice = FrontOffice.PLACE;
		OrderForm orderForm = new OrderForm();
		orderForm.setAddress("some street");
		orderForm.addInstruction("clean the floors");
		orderForm.addInstruction("clean the windows");
		orderForm.addInstruction("...");
		frontOffice.pleaseCleanMyHouse(orderForm, 55, "EUR");
		
	}

	static void howItShouldNotWork() {

//		// figure out how to prepare proper cleaningInstructions
//		CleaningInstructions cleaningInstructions = new CleaningInstructions();
//
//		// then call Harry
//		System.out.println("--------------------");
//		System.out.println("call Harry ...");
//		System.out.println("--------------------");
//		HarryHouse harryHouse = HarryHouse.PERSON;
//		harryHouse.cleanHouse(cleaningInstructions);
//		
//		// or any cleaner
//		System.out.println("--------------------");
//		System.out.println("call any cleaner ...");
//		System.out.println("--------------------");
//		HouseCleaning.COMPANY.getCleaner().cleanHouse(cleaningInstructions);
		
	}

	static void dontMessWithMyStorage() {

//		Storage storage = HouseCleaning.COMPANY.getStorage();
//		storage.cleaningSupplies.get(0);
//
//		System.out.println("--------------------");
//		System.out.println("oops I just messed up with your storage ...");
//		System.out.println("--------------------");

	}

	static void dontMessWithMyVan() {

//		Van companyVan = HouseCleaning.COMPANY.getCompanyVan();
//		companyVan.drive("some place");
//
//		System.out.println("--------------------");
//		System.out.println("oops I just went somewhere with your van ...");
//		System.out.println("--------------------");

	}

}
