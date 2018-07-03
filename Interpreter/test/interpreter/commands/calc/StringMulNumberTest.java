package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Number;
import interpreter.variables.Text;

public class StringMulNumberTest {

	StringMulNumber stringMulNumber;
	
	@Before
	public void initialize(){
		stringMulNumber = StringMulNumber.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("asasas",stringMulNumber.execute(new Text("as"), new Number("3")));
		
	}
	
	@Test
	public void emptyInputTest(){
		assertEquals("",stringMulNumber.execute(new Text(""), new Number("3")));
	}

}
