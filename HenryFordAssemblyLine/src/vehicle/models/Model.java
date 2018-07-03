package vehicle.models;

public class Model {
	Coupe coupe;
	Type type;
	public Model() {
		this.coupe = Coupe.hatchback;
		this.type = Type.A1;
	}
	public Model(Coupe coupe, Type type) {
		this.type = type;
		this.coupe = coupe;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coupe == null) ? 0 : coupe.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Model other = (Model) obj;
		if (coupe != other.coupe)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public Coupe getCoupe() {
		return coupe;
	}

	public void setCoupe(Coupe coupe) {
		this.coupe = coupe;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Model [coupe=" + coupe + ", type=" + type + "]";
	}
	
	

}
