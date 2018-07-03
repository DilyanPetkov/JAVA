package fileCommands;

import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import carStorage.fileCommands.CreateFromFile;
import carStorage.manufacturer.CountryCode;
import carStorage.manufacturer.ManufacturingFacility;
import vehicle.Car;

class CreateFromFileTest {

	@Test
	void test() {
		Map<String, Car> map = new HashMap<>();
		ManufacturingFacility facility = new ManufacturingFacility(map, CountryCode.BG);
		CreateFromFile c = new CreateFromFile(facility);
		c.create("fileWithCars.txt");
		assertFalse(map.isEmpty());
	}

}
