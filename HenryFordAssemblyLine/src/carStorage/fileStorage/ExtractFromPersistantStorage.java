package carStorage.fileStorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import carStorage.manufacturer.ManufacturingFacility;
import vehicle.Car;
import vehicle.engines.Engine;
import vehicle.engines.Fuel;
import vehicle.engines.Standarts;
import vehicle.models.Coupe;
import vehicle.models.Model;
import vehicle.models.Type;
import vehicle.transmissionBoxes.Transmission;
import vehicle.vinCode.VIN;

public class ExtractFromPersistantStorage {
	ManufacturingFacility facility;

	public ExtractFromPersistantStorage(ManufacturingFacility facility) {
		this.facility = facility;
	}

	public void extract(String fileName) {
		Map<String, Car> extractedVehicles = new HashMap<>();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String> lines = new ArrayList<>();
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).trim();

			VIN vin = new VIN(this.facility.getCountryCode());
			vin.setVIN(lines.get(i).substring(3, 17));

			Model model = new Model();
			String coupe = lines.get(i).substring(27, lines.get(i).indexOf("type") - 2);
			if (coupe.startsWith("h")) {
				model.setCoupe(Coupe.hatchback);
			} else if (coupe.startsWith("c")) {
				model.setCoupe(Coupe.combi);
			} else if (coupe.startsWith("s"))
				;
			{
				model.setCoupe(Coupe.sedan);
			}
			//String type = lines.get(i).substring(lines.get(i).indexOf("type=")+5, lines.indexOf("type=" + 7));
			if (lines.get(i).contains("A1")) {
				model.setType(Type.A1);
			} else if (lines.get(i).contains("A2")) {
				model.setType(Type.A2);
			} else if (lines.get(i).contains("A3")) {
				model.setType(Type.A3);
			} else if (lines.get(i).contains("A4")) {
				model.setType(Type.A4);
			} else if (lines.get(i).contains("A5")) {
				model.setType(Type.A5);
			} else if (lines.get(i).contains("A6")) {
				model.setType(Type.A6);
			} else if (lines.get(i).contains("A7")) {
				model.setType(Type.A7);
			} else if (lines.get(i).contains("A8")) {
				model.setType(Type.A8);
			} else if (lines.get(i).contains("Q1")) {
				model.setType(Type.Q1);
			} else if (lines.get(i).contains("Q2")) {
				model.setType(Type.Q2);
			} else if (lines.get(i).contains("Q3")) {
				model.setType(Type.Q3);
			} else if (lines.get(i).contains("Q4")) {
				model.setType(Type.Q4);
			} else if (lines.get(i).contains("Q5")) {
				model.setType(Type.Q5);
			} else if (lines.get(i).contains("Q6")) {
				model.setType(Type.Q6);
			} else if (lines.get(i).contains("Q7")) {
				model.setType(Type.Q7);
			} else if (lines.get(i).contains("Q8")) {
				model.setType(Type.Q8);
			}

			Engine engine = new Engine();
			String fuel = lines.get(i).substring(lines.get(i).indexOf("fuel=")+5, lines.get(i).indexOf("turbo") - 2);
			if(fuel.startsWith("D")) {
				engine.setFuel(Fuel.Diesel);
			}else if(fuel.startsWith("G")) {
				engine.setFuel(Fuel.Gasilone);
			}
			String turbo = lines.get(i).substring(lines.get(i).indexOf("turbo=")+6, lines.get(i).indexOf("power")-2);
			if(turbo.equals("T")) {
				engine.setTurbo(true);
			}
			String power = lines.get(i).substring(lines.get(i).indexOf("power=")+6, lines.get(i).indexOf("standart")-2);
			Integer result = Integer.parseInt(power);
			engine.setPower(result);
			String standart = lines.get(i).substring(lines.get(i).indexOf("standart=")+9,lines.get(i).indexOf("standart=")+14);
			if(standart.contains("3")) {
				engine.setStandart(Standarts.euro3);
			}else if(standart.contains("4")) {
				engine.setStandart(Standarts.euro4);
			}
			else if(standart.contains("5")) {
				engine.setStandart(Standarts.euro5);
			}
			else if(standart.contains("6")) {
				engine.setStandart(Standarts.euro6);
			}
			
			Transmission transmission = new Transmission();
			String gearBox = lines.get(i).substring(lines.get(i).indexOf("gearBoxType=")+12, lines.get(i).indexOf("gears")-2);
			transmission.setGearBoxType(gearBox);
			
			String gears = lines.get(i).substring(lines.get(i).indexOf("gears=")+6, lines.get(i).indexOf("gears=")+7);
			Integer gear = Integer.parseInt(gears);
			transmission.setGears(gear);
			Car car = new Car(vin, model, engine, transmission);
			extractedVehicles.put(vin.getCode(), car);
		}

		facility.setCars(extractedVehicles);
	}
}
