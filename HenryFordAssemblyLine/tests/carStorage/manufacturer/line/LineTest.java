package carStorage.manufacturer.line;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import carStorage.manufacturer.CountryCode;
import carStorage.manufacturer.ManufacturingFacility;
import carStorage.manufacturer.line.Line;
import vehicle.Car;
import vehicle.engines.Engine;
import vehicle.engines.Fuel;
import vehicle.engines.Standarts;
import vehicle.models.Coupe;
import vehicle.models.Model;
import vehicle.models.Type;
import vehicle.transmissionBoxes.Transmission;
import vehicle.vinCode.VIN;

class LineTest {

	@Test
	void testAssembleFuncion() {
		Map<String, Car> map = new HashMap<>();
		ManufacturingFacility facility = new ManufacturingFacility(map, CountryCode.BG);
		VIN vin = new VIN(facility.getCountryCode());
		Line line = new Line(facility, vin);

		Model model = new Model(Coupe.sedan, Type.A1);
		Engine engine = new Engine(Fuel.Diesel, false, 55, Standarts.euro6);
		Transmission transmission = new Transmission("manual", 5);
		Car car = new Car(line.getVin(), model, engine, transmission);

		line.assemble(model, engine, transmission);
		// facility.getCars().put(vin.getCode(), car);
		assertEquals(car, facility.getCars().get(vin.getCode()));
	}

	@Test
	void testDisassembleFunction() {
		Map<String, Car> map = new HashMap<>();
		ManufacturingFacility facility = new ManufacturingFacility(map, CountryCode.BG);
		VIN vin = new VIN(facility.getCountryCode());
		Line line = new Line(facility, vin);

		Model model = new Model(Coupe.sedan, Type.A1);
		Engine engine = new Engine(Fuel.Diesel, false, 55, Standarts.euro6);
		Transmission transmission = new Transmission("manual", 5);
		Car car = new Car(line.getVin(), model, engine, transmission);

		line.assemble(model, engine, transmission);
		line.disassemble(line.getVin());
		assertNotEquals(car, facility.getCars().get(vin.getCode()));
	}
}