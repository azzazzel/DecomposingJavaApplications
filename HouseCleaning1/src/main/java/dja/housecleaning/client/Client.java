package dja.housecleaning.client;

import java.io.IOException;
import java.util.List;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

import dja.housecleaning.Harry;
import other.things.CleaningTool;
import other.things.Van;

public class Client {

	public static void main(String[] args) throws IOException {
		new Client();
	}

	private Client() throws IOException {
		
		Terminal terminal = TerminalBuilder.terminal();
		StringsCompleter completer = new StringsCompleter("exit", "clean", "borrowVan", "borrowTools");
		
		LineReader reader = LineReaderBuilder.builder()
				.terminal(terminal)
				.completer(completer)
				.build();

		String javaVersion = new AttributedStringBuilder()
			.style(AttributedStyle.DEFAULT.foreground(AttributedStyle.RED))
			.append(System.getProperty("java.version"))
			.toAnsi();
		System.out.println("Java version is: " + javaVersion);

		Harry harry = Harry.PERSON;
		String line;
		while (true) {
			line = reader.readLine("house cleaning > ").trim();

			if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                break;
        	}
			ParsedLine parsedLine = reader.getParser().parse(line, 0);
			String command = parsedLine.words().get(0);
			String param = parsedLine.words().size() > 1 ? parsedLine.words().get(1) : null;
			
            try {
            	switch (command) {
					case "clean":
						harry.cleanHouse("some street", "clean the widows", 200);
						break;
					case "borrowVan":
						Van van = harry.borrowVan(param);
						van.drive("⛱️");
						System.out.println("Client: I'm on vacation! Will be back next week! May be!");
						break;
					case "borrowTools":
						List<CleaningTool> cleaningTools = harry.borrowTools(param);
						cleaningTools.clear();
						System.out.println("Client: Opps I lost your 🛠️. I'm so sorry!");
						break;
					default:
						break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
