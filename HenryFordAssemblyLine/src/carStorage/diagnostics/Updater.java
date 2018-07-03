package carStorage.diagnostics;

import carStorage.manufacturer.ManufacturingFacility;
import vehicle.engines.Standarts;
import vehicle.vinCode.VIN;

public class Updater {
	ManufacturingFacility facility;

	public Updater(ManufacturingFacility facility) {
		this.facility = facility;
	}

	public void update(VIN vin) {
		vin = new VIN(this.facility.getCountryCode());
		if(facility.getCars().get(vin.getCode()).getEngine().getStandart().equals(Standarts.euro4)){
			facility.getCars().get(vin.getCode()).getEngine().setStandart(Standarts.euro5);
		}
		
		
	}
}
