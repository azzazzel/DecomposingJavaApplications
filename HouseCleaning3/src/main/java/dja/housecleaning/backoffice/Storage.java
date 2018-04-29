package dja.housecleaning.backoffice;

import java.util.ArrayList;
import java.util.List;

import other.things.CleaningSupply;
import other.things.CleaningTool;

public class Storage {

	public List<CleaningTool> myCleaningTools = new ArrayList<>();
	public List<CleaningSupply> myCleaningSupplies = new ArrayList<>();

	public static final Storage PLACE = new Storage();
	
}
