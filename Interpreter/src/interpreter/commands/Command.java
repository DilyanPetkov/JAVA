package interpreter.commands;

import main.exceptions.NoSuchCommandException;

public interface Command{
	public String execute(String command) throws NoSuchCommandException;
	public String getCommandName();
	
}
