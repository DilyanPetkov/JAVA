import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import carStorage.fileStorage.PersistantStorage;
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

public class App {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Map<String, Car> map = new ConcurrentHashMap<>();
		ManufacturingFacility facility = new ManufacturingFacility(map, CountryCode.BG);
		Line line = new Line();
		line.setFacility(facility);
		Line lineTwo = new Line();
		lineTwo.setFacility(facility);
		Thread threadOne = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e);
				}

				VIN vin = new VIN(facility.getCountryCode());

				Model model = new Model(Coupe.sedan, Type.A1);
				Engine engine = new Engine(Fuel.Diesel, false, 55, Standarts.euro6);
				Transmission transmission = new Transmission("manual", 5);
				line.setVin(vin);
				line.assemble(model, engine, transmission);
				lineTwo.printCustomCar(vin);
				PersistantStorage p = new PersistantStorage(facility);
				 try {
					p.saveToFile("Storage.txt");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}

		});



		Thread threadTwo = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e);
				}

				VIN vin1 = new VIN(facility.getCountryCode());
				Model model1 = new Model(Coupe.combi, Type.A1);
				Engine engine1 = new Engine(Fuel.Gasilone, true, 55, Standarts.euro5);
				Transmission transmission1 = new Transmission("automatic", 6);
				lineTwo.setVin(vin1);
				lineTwo.assemble(model1, engine1, transmission1);
				lineTwo.printCustomCar(vin1);
				PersistantStorage p = new PersistantStorage(facility);
				 try {
					p.saveToFile("Storage.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}

		});

		System.out.println("Printing all cars: ");

		threadOne.start();
		threadTwo.start();

		 
	}
}
