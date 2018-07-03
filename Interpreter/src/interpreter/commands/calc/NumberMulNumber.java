package interpreter.commands.calc;

import interpreter.variables.Variable;

public class NumberMulNumber implements Operation{
	private final String name = "Number*Number";
	private static NumberMulNumber instance;
	
	private NumberMulNumber(){
		
	}
	
	public static NumberMulNumber getInstance(){
		if(instance == null){
			instance = new NumberMulNumber();
		}
		return instance;
	}
	
	@Override
	public String getOperationName(){
		return name;
	}
	
	@Override
	public String execute(Variable leftVariable, Variable rightVariable){
		//or throw exception
		if(! (leftVariable.getType().equals("Number") && rightVariable.getType().equals("Number"))){
			return "No such operation";
		}
		
		
		return Integer.toString(Integer.parseInt(leftVariable.getValue()) * Integer.parseInt(rightVariable.getValue()));
	}
}
