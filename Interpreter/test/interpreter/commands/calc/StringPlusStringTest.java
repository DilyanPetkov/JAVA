package interpreter.commands.calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Text;

public class StringPlusStringTest {

	StringPlusString stringPlusString;
	
	@Before
	public void initialize(){
		stringPlusString = StringPlusString.getInstance();
	}
	
	@Test
	public void randomInputTest() {
		assertEquals("fuckoff",stringPlusString.execute(new Text("fuck"), new Text("off")));
		
	}
	
	@Test
	public void emptyInputTest(){
		assertEquals("",stringPlusString.execute(new Text(""), new Text("")));
	}
	
	@Test
	public void emptyFirstStringTest(){
		assertEquals("humpty",stringPlusString.execute(new Text(""), new Text("humpty")));
	}

	@Test
	public void emptySecondStringTest(){
		assertEquals("dumpty",stringPlusString.execute(new Text("dumpty"), new Text("")));
	}
}
