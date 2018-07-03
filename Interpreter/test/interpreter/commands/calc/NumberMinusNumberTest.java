package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Number;

public class NumberMinusNumberTest {

	NumberMinusNumber numberMinusNumber;
	
	@Before
	public void initialize(){
		numberMinusNumber = NumberMinusNumber.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("10",numberMinusNumber.execute(new Number("15"), new Number("5")));
		
	}
	
	@Test
	public void inputZerosTest(){
		assertEquals("0",numberMinusNumber.execute(new Number("0"), new Number("0")));
	}
	
	@Test 
	public void negativeValueTest(){
		assertEquals("-5",numberMinusNumber.execute(new Number("5"), new Number("10")));
	}

}
