package main;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import interpreter.commands.Command;
import main.exceptions.NoSuchCommandException;

public class Interpreter {
	
	private final Map<String, Command> commandMap;
	
	public Interpreter(Collection<Command> commands){
		commandMap = new HashMap<String,Command>();
		
		for(Command command : commands){
			commandMap.put(command.getCommandName(), command);
		}
	}
	
	
	
	public String interprete(String commandName,String text) throws NoSuchCommandException{
		if(commandMap.get(commandName) == null){
			throw new NoSuchCommandException("There is no such command");
		}
		return commandMap.get(commandName).execute(text);
		
}
	
	// uses user input
	public void interprete(){
		Scanner sc = new Scanner(System.in);
		String command = "";
		String input = "";
		
		
		while(command != "exit"){
			String text = sc.nextLine();
			input = "";
			String[] words = text.split(" ");
			command = words[0];
			for(int i = 1; i < words.length; i++){
				if(i == 1){
					input = input + words[i];
					
				}else{
					input = input + " "+ words[i];
				}
			}
			
			try {
				System.out.println(interprete(command,input));
			} catch (NoSuchCommandException e) {
				System.err.println(e.getMessage() + "try another one");
				continue;
			}
		}
			try {
				commandMap.get("exit").execute("");
			} catch (NoSuchCommandException e) {
				e.printStackTrace();
			}
			sc.close();
		
	}
	
	public int numberOfCommands(){
		return commandMap.size();
	}
	
}
