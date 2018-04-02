package algorithms;

public class EmptyStackException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyStackException(){
		super("Stack Empty");
//		super();
	}
	
	public EmptyStackException(String message){
		super(message);
	}
	
	@Override
	public String getMessage(){
		return "空栈";
	}
}
