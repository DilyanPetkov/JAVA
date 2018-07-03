package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Date;
import interpreter.variables.Number;

public class DatePlusNumberTest {
	DatePlusNumber datePlusNumber;
	
	@Before
	public void initialize(){
		datePlusNumber = DatePlusNumber.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("15-1-2011",datePlusNumber.execute(new Date("10-01-2011"), new Number("5")));
	}

}
