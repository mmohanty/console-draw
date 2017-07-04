package com.csg.cs.drawing.exceptions;

public class IllegalArgumentException extends DrawingException{

	static final long serialVersionUID = 1L;

    
    public IllegalArgumentException() {
        super();
    }

    
    public IllegalArgumentException(String message) {
        super(message);
    }

    
    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

   
    public IllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
