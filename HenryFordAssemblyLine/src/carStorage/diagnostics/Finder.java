package carStorage.diagnostics;

import java.util.Iterator;

import carStorage.manufacturer.ManufacturingFacility;
import carStorage.manufacturer.line.Line;
import vehicle.engines.Standarts;
import vehicle.vinCode.VIN;

public class Finder {
	ManufacturingFacility facility;

	public Finder(ManufacturingFacility facility) {
		this.facility = facility;
	}

	public void find() {
		Updater update = new Updater(facility);
		VIN vin = new VIN(facility.getCountryCode());
		Iterator iterator = this.facility.getCars().keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().toString();
			if(facility.getCars().get(key).getEngine().getStandart().equals(Standarts.euro4)) {
				vin.setVIN(key);
				Line line = new Line(facility, vin);
				line.printCustomCar(vin);
				update.update(vin);
			}
		}
			
	}
}
