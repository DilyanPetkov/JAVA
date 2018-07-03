package carStorage.diagnostics;


import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import carStorage.fileStorage.ExtractFromPersistantStorage;
import carStorage.manufacturer.CountryCode;
import carStorage.manufacturer.ManufacturingFacility;
import vehicle.Car;
import vehicle.engines.Standarts;

class TestForEmissions {

	@Test
	void test() {
		Map<String, Car> map = new HashMap<>();
		ManufacturingFacility facility = new ManufacturingFacility(map, CountryCode.BG);
		ExtractFromPersistantStorage e = new ExtractFromPersistantStorage(facility);
		e.extract("Storage.txt");
		Finder finder = new Finder(facility);
		finder.find();
		Iterator iterator = facility.getCars().keySet().iterator();
		while(iterator.hasNext()) {
		String key = iterator.next().toString();
		assertNotEquals("euro4", facility.getCars().get(key).getEngine().getStandart().equals(Standarts.euro4));
		}
	}

}
