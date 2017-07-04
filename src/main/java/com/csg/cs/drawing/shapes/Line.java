package com.csg.cs.drawing.shapes;

import com.csg.cs.drawing.constants.DrawingAppConstant;
import com.csg.cs.drawing.exceptions.CanvasNotFoundException;
import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.drawing.exceptions.IllegalArgumentException;
import com.csg.cs.drawing.exceptions.OutOfCanvasException;
import com.csg.cs.drawing.utils.LineUtils;
import com.csg.cs.models.CanvasTemplate;

/**
 * Line uses x and y coordinate to build either vertical or horizontal lines. 
 * It takes canvas template as an input and builds Line on it.
 * @author mohanty
 * @version 1.0
 */
public class Line implements Shape {

	@Override
	public void makeShape(CanvasTemplate canvasTemplate, String []arguments) throws DrawingException{
		if(canvasTemplate == null){
			throw new CanvasNotFoundException("Draw a canvas before you make any shape!");
		}
		if(arguments == null || arguments.length != DrawingAppConstant.LENGTH_OF_LINE_CMD){
			throw new IllegalArgumentException("Please check the argument passed to Line command! Try again[L x1 y1 x2 y2].");
		}
		try{
			int x1 = Integer.parseInt(arguments[1]);
			int y1 = Integer.parseInt(arguments[2]);
			int x2 = Integer.parseInt(arguments[3]);
			int y2 = Integer.parseInt(arguments[4]);
			if((x1 == x2 && y1 < y2) || (y1 == y2 && x1 < x2)){
				LineUtils.drawLine(canvasTemplate, x1, y1, x2, y2, DrawingAppConstant.LINE_FEED);
			}else{
				throw new IllegalArgumentException("Illegal argument. Should be either x1 = x2 and y1 < y2 Or y1= y2 and x1 < x2. Try again[L x1 y1 x2 y2].");
			}
		}catch(NumberFormatException ex){
			throw new IllegalArgumentException("Illegal argument. Pass numeric values for x1, y1, x2 and y2. Try again[L x1 y1 x2 y2].");
		}catch(ArrayIndexOutOfBoundsException ex){
			throw new OutOfCanvasException("Coordinate is out of canvas range."+ canvasTemplate);
		}
		
	}

}
