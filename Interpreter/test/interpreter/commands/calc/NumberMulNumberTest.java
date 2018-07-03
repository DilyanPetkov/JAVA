package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Number;

public class NumberMulNumberTest {

	NumberMulNumber numberMulNumber;
	
	@Before
	public void initialize(){
		numberMulNumber = NumberMulNumber.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("15",numberMulNumber.execute(new Number("5"), new Number("3")));
	}
	
	@Test 
	public void negativeValueTest(){
		assertEquals("0",numberMulNumber.execute(new Number("5"), new Number("0")));
	}
	
}
