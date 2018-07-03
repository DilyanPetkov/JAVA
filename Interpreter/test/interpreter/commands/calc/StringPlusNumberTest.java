package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Number;
import interpreter.variables.Text;

public class StringPlusNumberTest {

	StringPlusNumber stringPlusNumber;
	
	@Before
	public void initialize(){
		stringPlusNumber = StringPlusNumber.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("asd5",stringPlusNumber.execute(new Text("asd"), new Number("5")));
		
	}
	
	@Test
	public void emptyInputTest(){
		assertEquals("",stringPlusNumber.execute(new Text(""), new Number("")));
	}
	
	@Test
	public void emptyStringInputTest(){
		assertEquals("3",stringPlusNumber.execute(new Text(""), new Number("3")));
	}
}
