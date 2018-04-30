import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.NewOrderProcess;
import dja.housecleaning.company.processes.PrepareForCleaningProcess;
import dja.housecleaning.company.processes.TransportProcess;

module dja.housecleaning.usecases {
	exports dja.housecleaning.usecases;

	requires dja.housecleaning.company;
	requires joda.money;
	requires things;
	
	uses NewOrderProcess;
	uses CleanHouseProcess;
	uses TransportProcess;
	uses PrepareForCleaningProcess;
}