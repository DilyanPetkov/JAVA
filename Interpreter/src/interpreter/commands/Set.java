package interpreter.commands;

import java.util.Map;

import interpreter.variables.Date;
import interpreter.variables.Text;
import interpreter.variables.Variable;
import interpreter.variables.Number;

public class Set implements Command{
	private final String  name = "set";
	private static Set instance;
	Map<String,Variable> variablesTable;
	
	private Set(){
		
	}
	
	public static Set getInstance(Map<String,Variable> variablesTable){
		if(instance == null){
			instance = new Set();
			instance.variablesTable = variablesTable;
		}
		return instance;
	}
	
	@Override
	public String getCommandName(){
		return name;
	}
	
	@Override
	public String execute(String text){
		String[] variableInformation = text.split(" ");
		
		//maybe use a factory
		
		if(variableInformation[1].equals("String")){
			variablesTable.put(variableInformation[0], 
			new Text(variableInformation[2]));
			
		}else if (variableInformation[1].equals("Number")){
			variablesTable.put(variableInformation[0], 
			new Number(variableInformation[2]));
			
		}else if (variableInformation[1].equals("Date")){
			variablesTable.put(variableInformation[0], 
			new Date(variableInformation[2]));
		}
		
		if(variablesTable.containsKey(variableInformation[0])){
			return "Ok";
		}
		return "Err";
	}
}

