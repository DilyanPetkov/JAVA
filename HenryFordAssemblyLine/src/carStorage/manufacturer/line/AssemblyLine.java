package carStorage.manufacturer.line;

import vehicle.engines.Engine;
import vehicle.models.Model;
import vehicle.transmissionBoxes.Transmission;
import vehicle.vinCode.VIN;

public interface AssemblyLine {
	public void assemble(Model model, Engine engine, Transmission transmission);
	public void disassemble(VIN vin);
	public void printCustomCar(VIN vin);
	public void printAllCars();
}
