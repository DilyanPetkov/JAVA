package vehicle.vinCode;

import java.util.Random;

import carStorage.manufacturer.CountryCode;

public class VIN {
	private String code;
	private CountryCode countryCode;
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int UNIQUE_CODE_SIZE = 14;

	private String getLocation() {
		return this.countryCode.toString();
	}
	public void setVIN(String code) {
		this.code = code;
	}
	private String uniqueCode() {
		int n = ALPHABET.length();
		String result = new String();
		Random r = new Random();
		for (int i = 0; i < UNIQUE_CODE_SIZE; i++) {
			result = result + ALPHABET.charAt(r.nextInt(n));
		}
		return result;
	}

	private String randomNumber() {
		Random rand = new Random();
		Integer n = rand.nextInt(9) + 0;
		return n.toString();
	}

	/*
	 * public String createVINnumber() { return getLocation().toString() +
	 * randomNumber().toString() + uniqueCode(); }
	 */

	public VIN(CountryCode countryCode) {
		this.countryCode = countryCode;
		this.code = getLocation() + randomNumber() + uniqueCode();
	}

	public String getCode() {
		return this.code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
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
		VIN other = (VIN) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (countryCode != other.countryCode)
			return false;
		return true;
	}	
}
