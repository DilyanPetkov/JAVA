package carStorage.fileCommands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import carStorage.manufacturer.ManufacturingFacility;
import carStorage.manufacturer.line.Line;
import vehicle.engines.Engine;
import vehicle.engines.Fuel;
import vehicle.engines.Standarts;
import vehicle.models.Coupe;
import vehicle.models.Model;
import vehicle.models.Type;
import vehicle.transmissionBoxes.Transmission;
import vehicle.vinCode.VIN;

public class CreateFromFile {
	private ManufacturingFacility mf;

	public CreateFromFile(ManufacturingFacility mf) {
		this.mf = mf;
	}

	String fileName;

	public void create(String fileName) {
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

			Model model = new Model();

			Transmission transmission = new Transmission();

			Engine engine = new Engine();

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
			if (lines.get(i).contains("combi")) {
				model.setCoupe(Coupe.combi);
			} else if (lines.get(i).contains("sedan")) {
				model.setCoupe(Coupe.sedan);
			} else if (lines.get(i).contains("hatchback")) {
				model.setCoupe(Coupe.hatchback);
			}

			if (lines.get(i).contains("B")) {
				engine.setFuel(Fuel.Gasilone);
				if (lines.get(i).contains("hp")) {
					String result = lines.get(i).substring(lines.get(i).indexOf("B{-"), lines.indexOf("hp"));
					Integer value = Integer.parseInt(result);
					engine.setPower(value);
				}
			}
			if (lines.get(i).contains("D")) {
				engine.setFuel(Fuel.Diesel);
				if (lines.get(i).contains("hp")) {
					String result = lines.get(i).substring(lines.get(i).indexOf("D{-") + 3, lines.get(i).indexOf("hp"));
					Integer value = Integer.parseInt(result);
					engine.setPower(value);
				}
			}

			if (lines.get(i).contains("euro3")) {
				engine.setStandart(Standarts.euro3);
			}
			if (lines.get(i).contains("euro4")) {
				engine.setStandart(Standarts.euro4);
			}
			if (lines.get(i).contains("euro5")) {
				engine.setStandart(Standarts.euro5);
			}
			if (lines.get(i).contains("euro6")) {
				engine.setStandart(Standarts.euro6);
			}
			if (lines.get(i).contains("T")) {

				engine.setTurbo(true);
			}
			if (lines.get(i).contains("Auto")) {
				transmission.setGearBoxType("Auto");
				String result = lines.get(i).substring(lines.get(i).indexOf("Auto{-") + 6,
						lines.get(i).lastIndexOf("}") - 1);
				Integer value = Integer.parseInt(result);
				transmission = new Transmission("Auto", value);

			}
			if (lines.get(i).contains("Manual")) {
				transmission.setGearBoxType("Manual");
				String result = lines.get(i).substring(lines.get(i).indexOf("Manual{-") + 8,
						lines.get(i).indexOf("}") - 1);
				Integer value = Integer.parseInt(result);
				transmission = new Transmission("Manual", value);
			}
			VIN vin = new VIN(this.mf.getCountryCode());
			Line myLine = new Line(this.mf, vin);
			myLine.assemble(model, engine, transmission);

		}

	}

}
