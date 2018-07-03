package interpreter.variables;

public class Number extends Variable{
	
	public Number(String value){
		this.type = "Number";
		this.value = value;
		
	}
	
	@Override
	public String getValue(){
		return value;
	}
	
	@Override
	public String getType(){
		return type;
	}
}
