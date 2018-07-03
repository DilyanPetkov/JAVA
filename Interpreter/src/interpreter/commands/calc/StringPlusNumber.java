package interpreter.commands.calc;

import interpreter.variables.Variable;

public class StringPlusNumber implements Operation{
	private final String name = "String+Number";
	private static StringPlusNumber instance;
	
	private StringPlusNumber(){
		
	}
	
	public static StringPlusNumber getInstance(){
		if(instance == null){
			instance = new StringPlusNumber();
		}
		return instance;
	}
	@Override
	public String execute(Variable leftVariable,Variable rightVariable){
		if(! (leftVariable.getType().equals("String") && rightVariable.getType().equals("Number"))){
			return "No such operation";
		}
		
		
		
		return leftVariable.getValue() + rightVariable.getValue();
	}
	
	@Override
	public String getOperationName(){
		return name;
	}
}
