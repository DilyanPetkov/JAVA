package interpreter.commands.calc;

import interpreter.variables.Variable;

public interface Operation {
	public String getOperationName();
	public String execute(Variable v1, Variable v2);
}
