package interpreter.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import interpreter.variables.Date;
import interpreter.variables.Number;
import interpreter.variables.Text;
import interpreter.variables.Variable;

public class Load implements Command{
	private String fileName;
	private static Load instance;
	private final String name = "load";
	Map<String,Variable> variablesTable;
	private Load() {
		
	}
	private Load(String fileName) {
		this.fileName = fileName;
	}
	public static Load getInstance(Map<String,Variable> variablesTable){
		if(instance == null){
			instance = new Load();
			instance.variablesTable = variablesTable;
		}
		return instance;
	}
	@Override
	public String execute(String fileName)  {
		FileReader fr = null;
		try {
			fr = new FileReader("fileToLoadFrom.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fr);
		ArrayList<String> lines = new ArrayList<String>();
        String line = null;        
        try {
			while ((line = bufferedReader.readLine()) != null) 
			{
			    lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        for(int k = 0;k<lines.size();k++) {
        	if(lines.get(k).equals("Variable:")) {
        		lines.remove("Variable:");
        	}
        }
        String[] arr = lines.toArray(new String[lines.size()]);
        String message = "";
        for(int j = 0; j<arr.length-2; j++) {
        	if(arr[j+1].equals("String")){
    			variablesTable.put(arr[j], 
    			new Text(arr[j+2]));
    			
    		}else if (arr[j+1].equals("Number")){
    			variablesTable.put(arr[j], 
    			new Number(arr[j+2]));
    			
    		}else if (arr[j+1].equals("Date")){
    			variablesTable.put(arr[j], 
    			new Date(arr[j+2]));
    		}
    		
    		if(variablesTable.containsKey(arr[j])){
    			message =  "Ok";
    		}
    		message = "Err";
        }
        return message;
        
	}

	@Override
	public String getCommandName() {
		return name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public static void main(String[] argc)  {
	}

}
