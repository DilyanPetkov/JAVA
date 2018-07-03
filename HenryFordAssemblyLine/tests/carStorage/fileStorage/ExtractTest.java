package carStorage.fileStorage;


import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import carStorage.manufacturer.CountryCode;
import carStorage.manufacturer.ManufacturingFacility;
import vehicle.Car;

class ExtractTest {

	@Test
	void testExtractMethod() {
		Map<String, Car> map = new HashMap<>();
		ManufacturingFacility facility = new ManufacturingFacility(map, CountryCode.BG);
		ExtractFromPersistantStorage e = new ExtractFromPersistantStorage(facility);
		e.extract("Storage.txt");
		assertFalse(facility.getCars().isEmpty());
	}

}
