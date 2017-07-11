package com.csg.cs.drawing.paint.apies;

import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.drawing.shapes.Shape;
import com.csg.cs.models.CanvasTemplate;

public class ConsoleShapeDecorator extends ShapeDecorator {

	public ConsoleShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	public void makeShape(final CanvasTemplate canvasTemplate, final String []cmd) throws DrawingException{
	    decoratedShape.makeShape(canvasTemplate, cmd);
	    drawShape(canvasTemplate);
	 }
	
	private void drawShape(final CanvasTemplate canvas){
		char [][]bitmap = canvas.getCanvasPaper();
		for(int i=0; i< canvas.getHeight(); i++) {
			for(int j=0; j<canvas.getWidth(); j++) {				 
				System.out.print(bitmap[i][j]);
			}
			System.out.println();
		}
	}

}
