package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import interpreter.commands.*;
import interpreter.commands.calc.*;
import interpreter.variables.Variable;

public class Main {
	public static void main(String[] args) {
		
//should be made to work with a Collection not just with an ArrayList
		HashMap<String,Variable> variablesTable = new HashMap<String,Variable>();
		
		Collection<Operation> operations = new ArrayList<Operation>(Arrays.asList(new Operation[] {
				NumberMinusNumber.getInstance(),
				NumberMulNumber.getInstance(),
				NumberPlusNumber.getInstance(),
				StringPlusString.getInstance(),
				StringPlusNumber.getInstance(),
				StringMulNumber.getInstance(),
				DatePlusNumber.getInstance(),
				DateMinusNumber.getInstance()
	}));
		
		
		Collection<Command> commands = new ArrayList<Command>(Arrays.asList(new Command[] {
						Set.getInstance(variablesTable),
						Get.getInstance(variablesTable),
						Calc.getInstance(variablesTable, operations)
			}));

		
		
		Interpreter in = new Interpreter(commands);
		in.interprete();

	}
}
