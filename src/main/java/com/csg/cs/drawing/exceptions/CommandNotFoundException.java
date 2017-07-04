package com.csg.cs.drawing.exceptions;

public class CommandNotFoundException extends DrawingException{

	static final long serialVersionUID = 1L;

    
    public CommandNotFoundException() {
        super();
    }

    
    public CommandNotFoundException(String message) {
        super(message);
    }

    
    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

   
    public CommandNotFoundException(Throwable cause) {
        super(cause);
    }
}
