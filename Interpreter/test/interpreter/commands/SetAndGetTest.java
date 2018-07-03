package interpreter.commands;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import interpreter.variables.Variable;

public class SetAndGetTest {
	Set set;
	Get get;
	
	@Before
	public void initialize(){
	HashMap<String,Variable> variables = new HashMap<String,Variable>();
	set = Set.getInstance(variables);
	get = Get.getInstance(variables);
	
	}
	
	@Test
	public void setAndGetTest(){
		set.execute("Humpty String Alice");
		//set humpty string alice
		assertEquals("String Alice",get.execute("Humpty"));
		
	}
	
	@Test
	public void notFoundTest(){
		assertEquals("Not Found",get.execute("zzz"));
	}

}
