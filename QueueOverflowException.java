package algorithms;

public class QueueOverflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QueueOverflowException(){
		super();
	}
	
	public QueueOverflowException(String message) {
		super(message);
	}
	
	@Override  
    public String getMessage() {  
        return "队列溢出";  
    }  

}
