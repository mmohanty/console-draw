package com.csg.cs.drawing.shapes;

import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.models.CanvasTemplate;

public interface Shape {

	/**
	 * Creates the shape on given canvas.
	 * @param canvasTemplate Canvas paper.
	 * @param arguments Coordinate commands.
	 */
	public void makeShape(CanvasTemplate canvasTemplate, String []arguments) throws DrawingException;
}
