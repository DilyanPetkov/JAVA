package interpreter.commands.calc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import interpreter.commands.Command;
import interpreter.variables.Variable;
import interpreter.variables.VariableFactory;


public class Calc implements Command{
	private final String name = "calc";
	Map<String,Variable> variablesTable;
	Map<String,Operation> operations;
	private static Calc instance;

	
	private Calc(){
		
	}
	
	public static Calc getInstance(Map<String,Variable> variablesTable, Collection<Operation> operations){
		if(instance == null){
			instance = new Calc();
			instance.variablesTable = variablesTable;
			instance.operations = new HashMap<String,Operation>();
			for(Operation operation : operations){
				instance.operations.put(operation.getOperationName(), operation);
			}
		}
		return instance;
	}
	
	@Override
	public String execute(String text){
		String[] words = text.split(" ");
		
		String nameOfOperation;
		nameOfOperation = variablesTable.get(words[1]).getType() + words[2] + variablesTable.get(words[3]).getType();
		
		// the name of the new variable and it's value
		String output = words[0] + " " + variablesTable.get(words[1]).getType() + " " + operations.get(nameOfOperation).execute(variablesTable.get(words[1]), variablesTable.get(words[3]));
		
		// split to save into the map
		String[] outputWords = output.split(" ");
			
		VariableFactory vf = new VariableFactory();
		Variable calculatedVariable = vf.getVariable(outputWords[1], outputWords[2]);
		variablesTable.put(outputWords[0], calculatedVariable);
		
		return output;
	}
	
	@Override
	public String getCommandName(){
		return name;
	}
	
}
