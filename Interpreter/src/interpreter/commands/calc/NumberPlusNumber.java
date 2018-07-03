package interpreter.commands.calc;

import interpreter.variables.Variable;

public class NumberPlusNumber implements Operation{
	private final String name = "Number+Number";
	private static NumberPlusNumber instance;
	
	private NumberPlusNumber(){
		
	}
	
	public static NumberPlusNumber getInstance(){
		if(instance == null){
			instance = new NumberPlusNumber();
		}
		return instance;
	}
	
	
	@Override
	public String execute(Variable leftVariable, Variable rightVariable){
		//or throw exception
		if(! (leftVariable.getType().equals("Number") && rightVariable.getType().equals("Number"))){
			return "No such operation";
		}
		
		
		
		return Integer.toString(Integer.parseInt(leftVariable.getValue()) + Integer.parseInt(rightVariable.getValue()));
	}
	
	@Override
	public String getOperationName(){
		return name;
	}
}
