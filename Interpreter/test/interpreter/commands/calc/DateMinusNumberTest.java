package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Date;
import interpreter.variables.Number;

public class DateMinusNumberTest {

	DateMinusNumber dateMinusNumber;
	
	@Before
	public void initialize(){
		dateMinusNumber = DateMinusNumber.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("20-1-2011",dateMinusNumber.execute(new Date("25-01-2011"), new Number("5")));
	}
	

}
