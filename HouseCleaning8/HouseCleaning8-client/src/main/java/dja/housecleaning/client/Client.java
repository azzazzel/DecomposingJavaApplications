package dja.housecleaning.client;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import dja.housecleaning.frontoffice.FrontOffice;
import dja.housecleaning.frontoffice.OrderForm;
import other.things.CleaningTool;
import other.things.Van;


@Component( //
		property = { //
				"osgi.command.function=clean", //
				"osgi.command.function=borrowVan", //
				"osgi.command.function=borrowTools", //
				"osgi.command.scope=hc" //
		}, //
		service = Object.class //
)
public class Client {

	@Reference FrontOffice frontOffice;
	
	public Client() {
		System.out.println("Java version is: " + System.getProperty("java.version"));
	}
		
	public void clean (String money) {
		OrderForm orderForm = new OrderForm();
		orderForm.setAddress("some street");
		orderForm.addInstruction("clean the floor");
		frontOffice.cleanMyHousePlease(orderForm, money);
	}
	

	public void borrowVan(String param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method borrowVan = frontOffice.getClass().getMethod("borrowVan", String.class);
		Van van = (Van)borrowVan.invoke(frontOffice, param);
		van.drive("⛱️");
		System.out.println("Client: I'm on vacation! Will be back next week! May be!");

	}

	public void borrowTools(String param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method borrowTools = frontOffice.getClass().getMethod("borrowTools", String.class);
		List<CleaningTool> cleaningTools = (List<CleaningTool>)borrowTools.invoke(frontOffice, param);
		cleaningTools.clear();
		System.out.println("Client: Opps I lost your 🛠️. I'm so sorry!");
	}

}
