package interpreter.variables;

public abstract class Variable {
	protected String type = "";
	protected String value = "";
	
	public abstract String getType();
	public abstract String getValue();
}
