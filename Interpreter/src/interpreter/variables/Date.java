package interpreter.variables;


public class Date extends Variable{
	
	public Date(String value){
		this.value = value;
		this.type = "Date";
		
	}
	
	@Override
	public String getType(){
		return type;
	}
	
	@Override
	public String getValue(){
		return value;
	}
	
	
}
