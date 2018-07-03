package main.exceptions;

public class NoSuchCommandException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1820329133446807002L;

	public NoSuchCommandException(String message){
		super(message);
	}
	
	public NoSuchCommandException(Throwable cause){
		super("No such command " + cause.getMessage(), cause);
	}
	
    public NoSuchCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
