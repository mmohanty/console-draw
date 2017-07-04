package com.csg.cs.drawing.exceptions;

public class OutOfCanvasException extends DrawingException{

	static final long serialVersionUID = 1L;

    
    public OutOfCanvasException() {
        super();
    }

    
    public OutOfCanvasException(String message) {
        super(message);
    }

    
    public OutOfCanvasException(String message, Throwable cause) {
        super(message, cause);
    }

   
    public OutOfCanvasException(Throwable cause) {
        super(cause);
    }
}
