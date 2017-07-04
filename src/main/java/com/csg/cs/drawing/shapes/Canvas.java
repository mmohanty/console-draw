package com.csg.cs.drawing.shapes;

import static com.csg.cs.drawing.constants.DrawingAppConstant.H_BORDER;
import static com.csg.cs.drawing.constants.DrawingAppConstant.V_BORDER;

import com.csg.cs.drawing.constants.DrawingAppConstant;
import com.csg.cs.drawing.exceptions.CanvasNotFoundException;
import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.drawing.exceptions.IllegalArgumentException;
import com.csg.cs.drawing.exceptions.OutOfCanvasException;
import com.csg.cs.drawing.utils.LineUtils;
import com.csg.cs.models.CanvasTemplate;
/**
 * Canvas uses a template and makes a border across the four sides of template. 
 * It's used for different components to make different shapes on it.
 * 
 * @author mohanty
 *
 */
public class Canvas implements Shape {

	@Override
	public void makeShape(CanvasTemplate canvasTemplate, String []arguments) throws DrawingException{
		if(canvasTemplate == null){
			throw new CanvasNotFoundException("Draw a canvas before you make any shape!");
		}
		if(arguments == null || arguments.length != DrawingAppConstant.LENGTH_OF_CANVAS_CMD){
			throw new IllegalArgumentException("Pass valid argument! Try again[C width height].");
		}
		try{
			int width = canvasTemplate.getWidth();
			int height = canvasTemplate.getHeight();
			LineUtils.drawLine(canvasTemplate, 0, 0, width-1, 0, H_BORDER);
			LineUtils.drawLine(canvasTemplate, 0, height-1, width-1, height-1, H_BORDER);
			LineUtils.drawLine(canvasTemplate, 0, 1, 0, height-2, V_BORDER);
			LineUtils.drawLine(canvasTemplate, width-1, 1, width-1, height-2, V_BORDER);
		}catch(ArrayIndexOutOfBoundsException ex){
			throw new OutOfCanvasException("Coordinate is out of canvas range."+ canvasTemplate);
		}
	}
}
