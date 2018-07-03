package carStorage.fileStorage;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import carStorage.manufacturer.ManufacturingFacility;

public class PersistantStorage {
	ManufacturingFacility facility;
	public PersistantStorage(ManufacturingFacility facility) {
		this.facility = facility;
	}
	public ManufacturingFacility getFacility() {
		return this.facility;
	}
	public void saveToFile(String fileName) throws FileNotFoundException  {
		String vin = "VIN:";
		try {
			@SuppressWarnings("resource")
			DataOutputStream os = new DataOutputStream(new FileOutputStream(fileName));
			Iterator<String> iterator = this.facility.getCars().keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next().toString();
				os.writeBytes(vin);
				os.writeBytes(key);
				os.writeBytes(this.facility.getCars().get(key).getModel().toString());
				os.writeBytes(this.facility.getCars().get(key).getEngine().toString());
				os.writeBytes(this.facility.getCars().get(key).getTransmission().toString());
				String newLine = System.getProperty("line.separator");
				os.writeBytes(newLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
