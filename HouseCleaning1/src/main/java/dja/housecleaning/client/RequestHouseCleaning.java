package dja.housecleaning.client;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import dja.housecleaning.HarryHouse;

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
		
		HarryHouse harryHouse = HarryHouse.PERSON;
		harryHouse.cleanHouseOrder("some street", "clean the widows", 200);
		
		

	}

	void harryClean() {

		// then call Harry
		System.out.println("--------------------");
		System.out.println("call Harry ...");
		System.out.println("--------------------");
		HarryHouse harryHouse = HarryHouse.PERSON;
		harryHouse.cleanHouseOrder("address", "instructions", 5);
		
	}

	


}
