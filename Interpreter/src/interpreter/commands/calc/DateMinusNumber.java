package interpreter.commands.calc;

import java.util.Calendar;

import interpreter.variables.Variable;

public class DateMinusNumber implements Operation{
	private final String name = "Date-Number";
	private Calendar cal;
	private static DateMinusNumber instance;
	
	private DateMinusNumber(){
		
	}
	
	public static DateMinusNumber getInstance(){
		if(instance == null){
			instance = new DateMinusNumber();
		}
		return instance;
	}
	
	@Override
	public String execute(Variable leftVariable, Variable rightVariable){
		//or throw exception
		if(! (leftVariable.getType().equals("Date") && rightVariable.getType().equals("Number"))){
			return "No such operation";
		}
		
		cal = Calendar.getInstance();
		String[] dateNumbers = leftVariable.getValue().split("-");
		cal.set(Integer.parseInt(dateNumbers[2]),Integer.parseInt(dateNumbers[1]), Integer.parseInt(dateNumbers[0]));
		cal.add(Calendar.DATE, -(Integer.parseInt(rightVariable.getValue())));
		
		return Integer.toString(cal.get(Calendar.DATE)) + "-"
				+ Integer.toString(cal.get(Calendar.MONTH)) + "-" + Integer.toString(cal.get(Calendar.YEAR));
	}
	
	
	
	
	@Override
	public String getOperationName(){
		return name;
	}
	

}
