package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Number;
import interpreter.variables.Variable;

public class NumberPlusNumberTest {
	Variable leftVariable;
	Variable rightVariable;
	NumberPlusNumber numberPlusNumber;
	
	@Before
	public void initialize(){
		numberPlusNumber = NumberPlusNumber.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("20",numberPlusNumber.execute(new Number("15"), new Number("5")));
		
	}
	
	@Test
	public void inputZerosTest(){
		assertEquals("0",numberPlusNumber.execute(new Number("0"), new Number("0")));
	}
	@Test
	public void inputNegativeIntegers() {
		assertEquals("-6", numberPlusNumber.execute(new Number("-3"), new Number ("-3")));
	}
}
