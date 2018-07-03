package interpreter.variables;

public class VariableFactory {
	public Variable getVariable(String type, String value){
		
		if(type.equals("Text")){
			return new Text(value);
		}
		else if(type.equals("Number")){
			return new Number(value);
		}
		else if(type.equals("Date")){
			return new Date(value);
		}
		return null;
	}
}
