package carStorage.manufacturer.line;

import java.util.Iterator;

import carStorage.manufacturer.ManufacturingFacility;
import vehicle.Car;
import vehicle.engines.Engine;
import vehicle.models.Model;
import vehicle.transmissionBoxes.Transmission;
import vehicle.vinCode.VIN;

public class Line implements AssemblyLine {
	ManufacturingFacility facility;
	VIN vin;
	public Line(ManufacturingFacility facility, VIN vin) {
		this.facility = facility;
		this.vin = vin;
	}
	public Line() {
		this.facility = null;
		this.vin = null;
	}
	@Override
	public void  assemble(Model model, Engine engine, Transmission transmission) {		
			Car car = new Car(this.vin, model, engine, transmission);
			facility.getCars().put(this.vin.getCode(), car);
		
	}

	@Override
	public void disassemble(VIN vin) {
		if (facility.getCars().containsKey(vin.getCode())) {
			facility.getCars().remove(vin.getCode());
		}
	}
	public VIN getVin() {
		return vin;
	}
	@Override
	public void printCustomCar(VIN vin) {
		if(facility.getCars().containsKey(vin.getCode())) {
			System.out.println("VIN: " + vin.getCode() + " Model = "
					+ this.facility.getCars().get(vin.getCode()).getModel().getType().toString() + "{"
					+ this.facility.getCars().get(vin.getCode()).getModel().getCoupe().toString() + "}" + " Engine = "
					+ this.facility.getCars().get(vin.getCode()).getEngine().getFuel().toString() + "{"
					+ this.facility.getCars().get(vin.getCode()).getEngine().getPower() + ", "
					+ this.facility.getCars().get(vin.getCode()).getEngine().getTurbo() + ", "
					+ this.facility.getCars().get(vin.getCode()).getEngine().getStandart().toString() +"}" +" Transmission = " + "{"
					+ this.facility.getCars().get(vin.getCode()).getTransmission().getGearBoxType() + "{"
					+ this.facility.getCars().get(vin.getCode()).getTransmission().getGears() + "}" + "}");
		}
		
	}
	@Override
	public void printAllCars() {
		Iterator iterator = this.facility.getCars().keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().toString();
			System.out.println("VIN: " + key + " Model = "
					+ this.facility.getCars().get(key).getModel().getType().toString() + "{"
					+ this.facility.getCars().get(key).getModel().getCoupe().toString() + "}" + " Engine = "
					+ this.facility.getCars().get(key).getEngine().getFuel().toString() + "{"
					+ this.facility.getCars().get(key).getEngine().getPower() + ", "
					+ this.facility.getCars().get(key).getEngine().getTurbo() + ", "
					+ this.facility.getCars().get(key).getEngine().getStandart().toString() + "}" +" Transmission = " + "{"
					+ this.facility.getCars().get(key).getTransmission().getGearBoxType() + "{"
					+ this.facility.getCars().get(key).getTransmission().getGears() + "}" + "}");
		
		}
		
	}
	public void setVin(VIN vin) {
		this.vin = vin;
	}
	public ManufacturingFacility getFacility() {
		return facility;
	}
	public void setFacility(ManufacturingFacility facility) {
		this.facility = facility;
	}
}
