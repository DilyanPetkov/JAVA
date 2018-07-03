package interpreter.commands;

import java.util.Map;

import interpreter.variables.Variable;

public class Get implements Command{
	private final String name = "get";
	public static Get instance;
	
	private Map<String,Variable> variablesTable;
	
	private Get(){
		
	}
	
	public static Get getInstance(Map <String,Variable> variablesTable){
		if(instance == null){
			instance = new Get();
			instance.variablesTable = variablesTable;
		}
		return instance; 
	}
	
	@Override
	public String getCommandName(){
		return name;
	}
	
	@Override
	//text = variable name
	public String execute(String text){
		if(variablesTable.get(text) == null){
			return "Err";
		}
		return (variablesTable.get(text).getType() + " "
		+ variablesTable.get(text).getValue() );
		
	}
}
