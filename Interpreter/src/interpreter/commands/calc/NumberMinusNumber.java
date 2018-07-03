package interpreter.commands.calc;

import interpreter.variables.Variable;

public class NumberMinusNumber implements Operation{
	private final String name = "Number-Number";
	private static NumberMinusNumber instance;
	
	private NumberMinusNumber(){
		
	}
	
	public static NumberMinusNumber getInstance(){
		if(instance == null){
			instance = new NumberMinusNumber();
		}
		return instance;
	}
	
	@Override
	public String execute(Variable leftVariable, Variable rightVariable){
		//or throw exception
		if(! (leftVariable.getType().equals("Number") && rightVariable.getType().equals("Number"))){
			return "No such operation";
		}
		
		
		return Integer.toString(Integer.parseInt(leftVariable.getValue()) - Integer.parseInt(rightVariable.getValue()));
	}
	
	@Override
	public String getOperationName(){
		return name;
	}
}
