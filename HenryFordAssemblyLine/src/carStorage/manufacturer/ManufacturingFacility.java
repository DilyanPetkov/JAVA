package carStorage.manufacturer;

import java.util.Map;
import vehicle.Car;

public class ManufacturingFacility{
	Map<String, Car> cars;
	CountryCode countryCode;
	public ManufacturingFacility(Map<String, Car> cars, CountryCode countryCode) {
		super();
		this.cars = cars;
		this.countryCode = countryCode;
	}
	public CountryCode getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}
	
	public ManufacturingFacility getInstance() {
		return this;
	}

	public Map<String, Car> getCars() {
		return cars;
	}

	public void setCars(Map<String, Car> cars) {
		this.cars = cars;
	}

}
