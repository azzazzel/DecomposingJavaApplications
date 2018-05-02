package dja.housecleaning.client;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import dja.housecleaning.Garage;
import dja.housecleaning.HarryHouse;
import dja.housecleaning.OrderForm;
import dja.housecleaning.Receptionist;
import other.things.Van;

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
		} while (!"exit".equals(line));

	}

	void clean() {

		System.out.println("Java version is: " + System.getProperty("java.version"));

		System.out.println("--------------------");
		System.out.println("official way ...");
		System.out.println("--------------------");
		
		Receptionist receptionist = Receptionist.PERSON;
		OrderForm orderForm = receptionist.getOrderForm();
		orderForm.setAddress("some street");
		orderForm.setInstructions("clean the floor");
		receptionist.cleanMyHousePlease(orderForm, 200);
		

	}

	void harryClean() {

		// then call Harry
		System.out.println("--------------------");
		System.out.println("call Harry ...");
		System.out.println("--------------------");
		HarryHouse harryHouse = HarryHouse.PERSON;
		harryHouse.cleanHouseOrder("address", "instructions", 5);
		
	}

	
	void useStorage() {
		Garage garage = Garage.PLACE;
		garage.getMyCleaningSupplies().clear();

		System.out.println("--------------------");
		System.out.println("oops I just messed up with your cleaning supplies ...");
		System.out.println("--------------------");

	}

	void useVan() {

		Van companyVan = Garage.PLACE.getMyVan();
		companyVan.drive("some place");

		System.out.println("--------------------");
		System.out.println("oops I just went somewhere with your van ...");
		System.out.println("--------------------");

	}

}
