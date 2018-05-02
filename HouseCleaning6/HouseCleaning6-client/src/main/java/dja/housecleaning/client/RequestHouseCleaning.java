package dja.housecleaning.client;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import dja.housecleaning.frontoffice.FrontOffice;
import dja.housecleaning.frontoffice.OrderForm;

public class RequestHouseCleaning {

	public static void main(String[] args) throws IOException {

		RequestHouseCleaning requestHouseCleaning = new RequestHouseCleaning();
		
		Terminal terminal = TerminalBuilder.terminal();
		StringsCompleter completer = new StringsCompleter("clean", "harryClean", "useStorage","useVan");
		
		LineReader reader = LineReaderBuilder.builder()
				.terminal(terminal)
				.completer(completer)
				.build();

		String line;
		do {
			line = reader.readLine("house cleaning > ");
			try {
				switch (line.trim()) {
				case "clean":
					requestHouseCleaning.clean();
					break;
				case "harryClean":
					requestHouseCleaning.harryClean();
					break;
				case "cleanerClean":
					requestHouseCleaning.cleanerClean();
					break;
				case "useStorage":
					requestHouseCleaning.useStorage();
					break;
				case "useVan":
					requestHouseCleaning.useVan();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (line != "exit");

	}

	void clean() {

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

	void harryClean() {

//		// figure out how to prepare proper cleaningInstructions
//		CleaningInstructions cleaningInstructions = new CleaningInstructions();
//
//		// then call Harry
//		System.out.println("--------------------");
//		System.out.println("call Harry ...");
//		System.out.println("--------------------");
//		HarryHouse harryHouse = HarryHouse.PERSON;
//		harryHouse.cleanHouse(cleaningInstructions);
		
	}

	void cleanerClean() {

//		// figure out how to prepare proper cleaningInstructions
//		CleaningInstructions cleaningInstructions = new CleaningInstructions();
//
//		// then call any cleaner
//		System.out.println("--------------------");
//		System.out.println("call any cleaner ...");
//		System.out.println("--------------------");
//		HouseCleaning.COMPANY.getCleaner().cleanHouse(cleaningInstructions);
		
	}
	
	
	void useStorage() {
//		Storage storage = HouseCleaning.COMPANY.getStorage();
//		storage.cleaningSupplies.clear();
//
//		System.out.println("--------------------");
//		System.out.println("oops I just messed up with your storage ...");
//		System.out.println("--------------------");

	}

	void useVan() {

//		Van companyVan = HouseCleaning.COMPANY.getCompanyVan();
//		companyVan.drive("some place");
//
//		System.out.println("--------------------");
//		System.out.println("oops I just went somewhere with your van ...");
//		System.out.println("--------------------");

	}

}
