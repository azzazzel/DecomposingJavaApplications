package dja.housecleaning.company.internal.assets;

import java.util.ArrayList;
import java.util.List;

import other.things.CleaningSupply;
import other.things.CleaningTool;

public class Storage {

	public List<CleaningTool> cleaningTools = new ArrayList<>();
	public List<CleaningSupply> cleaningSupplies = new ArrayList<>();

	public static final Storage PLACE = new Storage();
	
}
