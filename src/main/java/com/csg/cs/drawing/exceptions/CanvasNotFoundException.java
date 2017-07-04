package com.csg.cs.drawing.exceptions;

public class CanvasNotFoundException extends DrawingException{

	static final long serialVersionUID = 1L;

    
    public CanvasNotFoundException() {
        super();
    }

    
    public CanvasNotFoundException(String message) {
        super(message);
    }

    
    public CanvasNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

   
    public CanvasNotFoundException(Throwable cause) {
        super(cause);
    }
}
