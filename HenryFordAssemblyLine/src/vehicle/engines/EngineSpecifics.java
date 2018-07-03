package vehicle.engines;

import java.util.HashMap;
import java.util.Map;

public class EngineSpecifics {
	private Map<Integer, Integer> engineSpecifications;

	private void setSpecifications() {
		engineSpecifications = new HashMap<>();
		this.engineSpecifications.put(55, 1000);
		this.engineSpecifications.put(147, 2000);
		this.engineSpecifications.put(245, 3000);
		this.engineSpecifications.put(253, 4000);
		this.engineSpecifications.put(331, 5000);
		this.engineSpecifications.put(510, 6000);
		this.engineSpecifications.put(736, 8000);
	}

	public EngineSpecifics() {
		setSpecifications();
	}

	public Map<Integer, Integer> getEngineSpecifications() {
		return engineSpecifications;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engineSpecifications == null) ? 0 : engineSpecifications.hashCode());
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
		EngineSpecifics other = (EngineSpecifics) obj;
		if (engineSpecifications == null) {
			if (other.engineSpecifications != null)
				return false;
		} else if (!engineSpecifications.equals(other.engineSpecifications))
			return false;
		return true;
	}

	public void setEngineSpecifications(Map<Integer, Integer> engineSpecifications) {
		this.engineSpecifications = engineSpecifications;
	}

}
