package interpreter.variables;

public class Text extends Variable{
	protected String type = "String";
	protected String value = "";
	
	@Override
	public String getValue(){
		return value;
	}
	
	
	@Override
	public String getType(){
		return type;
	}
	
	public Text(String value){
		type = "String";
		this.value = value;
	}
	
	public String concatenate(String text){
		return value + text;
	}
	
	public String multiply(int n){
		String emptyString = "";
		for(int i = 0; i < n; i++){
			emptyString = emptyString + value;
		}
		return emptyString;
	}
}
