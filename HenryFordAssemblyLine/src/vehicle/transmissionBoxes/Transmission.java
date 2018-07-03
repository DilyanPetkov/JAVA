package vehicle.transmissionBoxes;

import java.util.ArrayList;
import java.util.List;

public class Transmission implements Manual, Automatic {
	String gearBoxType;
	int gears;
	List<Integer> manualBox;
	List<Integer> automaticBox;

	public Transmission() {
		this.gearBoxType = "manual";
		this.gears = 4;
	}

	@Override
	public List<Integer> constructAutomaticBox() {
		this.automaticBox.add(4);
		this.automaticBox.add(5);
		this.automaticBox.add(6);
		this.automaticBox.add(8);
		return this.automaticBox;

	}

	@Override
	public List<Integer> constructManualBox() {
		this.manualBox.add(4);
		this.manualBox.add(5);
		this.manualBox.add(6);
		return this.manualBox;

	}

	public Transmission(String gearBoxType, int gears) {
		this.manualBox = new ArrayList<>();
		this.automaticBox = new ArrayList<>();
		this.gearBoxType = gearBoxType;
		
		constructManualBox();
		constructAutomaticBox();

		if (this.gearBoxType.trim().startsWith("a")) {
			if (this.automaticBox.contains(gears)) {
				this.gears = gears;
			}
		}
		if (this.gearBoxType.trim().startsWith("m")) {
			if (this.manualBox.contains(gears)) {
				this.gears = gears;
			}
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((automaticBox == null) ? 0 : automaticBox.hashCode());
		result = prime * result + ((gearBoxType == null) ? 0 : gearBoxType.hashCode());
		result = prime * result + gears;
		result = prime * result + ((manualBox == null) ? 0 : manualBox.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transmission other = (Transmission) obj;
		if (automaticBox == null) {
			if (other.automaticBox != null)
				return false;
		} else if (!automaticBox.equals(other.automaticBox))
			return false;
		if (gearBoxType == null) {
			if (other.gearBoxType != null)
				return false;
		} else if (!gearBoxType.equals(other.gearBoxType))
			return false;
		if (gears != other.gears)
			return false;
		if (manualBox == null) {
			if (other.manualBox != null)
				return false;
		} else if (!manualBox.equals(other.manualBox))
			return false;
		return true;
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public String getGearBoxType() {
		return gearBoxType;
	}

	public void setGearBoxType(String gearBoxType) {
		this.gearBoxType = gearBoxType;
	}

	@Override
	public String toString() {
		return "Transmission [gearBoxType=" + gearBoxType + ", gears=" + gears + "]";
	}

	
}
