package interpreter.commands.calc;

import interpreter.variables.Variable;

public class StringMulNumber implements Operation{
	private final String name = "String*Number";
	private static StringMulNumber instance;
	
	private StringMulNumber(){
		
	}
	
	public static StringMulNumber getInstance(){
		if(instance == null){
			instance = new StringMulNumber();
		}
		return instance;
	}
	
	@Override
	public String execute(Variable leftVariable, Variable rightVariable){
		
		if(! (leftVariable.getType().equals("String") && rightVariable.getType().equals("Number"))){
			return "No such operation";
		}
		
		
		String newValue = "";
		for(int i = 0; i < Integer.parseInt(rightVariable.getValue()); i++){
			newValue = newValue + leftVariable.getValue();
		}
		
		return newValue;
	}
	
	@Override
	public String getOperationName(){
		return name;
	}
}