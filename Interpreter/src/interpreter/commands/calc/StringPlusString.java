package interpreter.commands.calc;

import interpreter.variables.Variable;

public class StringPlusString implements Operation{
	private final String name = "String+String";
	private static StringPlusString instance;
	
	private StringPlusString(){
		
	}
	
	public static StringPlusString getInstance(){
		if(instance == null){
			instance = new StringPlusString();
		}
		return instance;
	}
	
	
	@Override
	public String execute(Variable leftVariable, Variable rightVariable){
		if(!(leftVariable.getType().equals("String") && rightVariable.getType().equals("String"))){
			return "No such operation";
		}
		
		
		return leftVariable.getValue() + rightVariable.getValue();
	}
	
	@Override
	public String getOperationName(){
		return name;
	}
}
