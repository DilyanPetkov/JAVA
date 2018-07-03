package vehicle.engines;

public class Engine {
	Fuel fuel;
	boolean turbo;
	int power;
	Standarts standart;
	EngineSpecifics specifics;
	public Engine() {
		this.fuel = Fuel.Diesel;
		this.turbo = false;
		this.power = 55;
		this.standart = Standarts.euro3;
	}
	public Engine(Fuel fuel, boolean turbo, int power, Standarts standart) {
		this.specifics = new EngineSpecifics();
		this.fuel = fuel;
		this.turbo = turbo;
		if(specifics.getEngineSpecifications().containsKey(power)) {
			this.power = power;
		}		
		this.standart = standart;
	}
	public int addTurbo() {
		if(this.turbo) {
			this.power += 0.3 * this.power;
		}
		return this.power;
	}
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	public String getTurbo() {
		String result = "F";
		if(this.turbo) {
			result = "T";
		}
		return result;
	}
	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}
	public boolean isTurbo() {
		return this.turbo;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Standarts getStandart() {
		return standart;
	}
	public void setStandart(Standarts standart) {
		this.standart = standart;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + power;
		result = prime * result + ((specifics == null) ? 0 : specifics.hashCode());
		result = prime * result + ((standart == null) ? 0 : standart.hashCode());
		result = prime * result + (turbo ? 1231 : 1237);
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
		Engine other = (Engine) obj;
		if (fuel != other.fuel)
			return false;
		if (power != other.power)
			return false;
		if (specifics == null) {
			if (other.specifics != null)
				return false;
		} else if (!specifics.equals(other.specifics))
			return false;
		if (standart != other.standart)
			return false;
		if (turbo != other.turbo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Engine [fuel=" + fuel + ", turbo=" + turbo + ", power=" + power + ", standart=" + standart + "]";
	}
	
}
