package com.csg.cs.drawing.exceptions;

public class DrawingException extends Exception{

	static final long serialVersionUID = 1L;

    
    public DrawingException() {
        super();
    }

    
    public DrawingException(String message) {
        super(message);
    }

    
    public DrawingException(String message, Throwable cause) {
        super(message, cause);
    }

   
    public DrawingException(Throwable cause) {
        super(cause);
    }
}
