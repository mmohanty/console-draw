package com.csg.cs.drawing.paint.apies;

import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.drawing.shapes.Shape;
import com.csg.cs.models.CanvasTemplate;

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void makeShape(CanvasTemplate canvasTemplate, String[] arguments) throws DrawingException {
		decoratedShape.makeShape(canvasTemplate, arguments);
	}

}
