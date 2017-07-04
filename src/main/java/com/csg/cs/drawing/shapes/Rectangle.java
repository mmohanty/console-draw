package com.csg.cs.drawing.shapes;

import com.csg.cs.drawing.constants.DrawingAppConstant;
import com.csg.cs.drawing.exceptions.CanvasNotFoundException;
import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.drawing.exceptions.IllegalArgumentException;
import com.csg.cs.drawing.exceptions.OutOfCanvasException;
import com.csg.cs.drawing.utils.LineUtils;
import com.csg.cs.models.CanvasTemplate;
/**
 * This takes (x1, y1) and (x2,y2) coordinate to build a rectangle on the template.
 *  <br>
 *  <br>
 *   (x1,y1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp(x2,y1)<br>
 *    XXXXXXXXXXXX<br>
 *    X &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp X<br>
 *    X &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp X<br>
 *    XXXXXXXXXXXX<br>
 *   (x1,y2)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp(x2,y2)
 *  
 * @author mohanty
 * @version 1.0
 */
public class Rectangle implements Shape {

	@Override
	public void makeShape(CanvasTemplate canvasTemplate, String []arguments) throws DrawingException{
		if(canvasTemplate == null){
			throw new CanvasNotFoundException("Draw a canvas before you make any shape!");
		}
		if(arguments == null || arguments.length != DrawingAppConstant.LENGTH_OF_RECTANGLE_CMD){
			throw new IllegalArgumentException("Pass valid arguments to Rectangle command! Try again[R x1 y1 x2 y2].");
		}
		try{
			int x1 = Integer.parseInt(arguments[1]);
			int y1 = Integer.parseInt(arguments[2]);
			int x2 = Integer.parseInt(arguments[3]);
			int y2 = Integer.parseInt(arguments[4]);
			if(x1 < x2 && y1 < y2){
				LineUtils.drawLine(canvasTemplate, x1, y1, x2, y1, DrawingAppConstant.LINE_FEED);
				LineUtils.drawLine(canvasTemplate, x1, y1, x1, y2, DrawingAppConstant.LINE_FEED);
				LineUtils.drawLine(canvasTemplate, x2, y1, x2, y2, DrawingAppConstant.LINE_FEED);
				LineUtils.drawLine(canvasTemplate, x1, y2, x2, y2, DrawingAppConstant.LINE_FEED);
			}else{
				throw new IllegalArgumentException("Illegal argument. Should be x1 < x2 and y1 < y2. Try again[R x1 y1 x2 y2].");
			}
		}catch(NumberFormatException ex){
			throw new IllegalArgumentException("Illegal argument.Pass numeric argument for x1, y1, x2 and y2. Try again[R x1 y1 x2 y2].");
		}catch(ArrayIndexOutOfBoundsException ex){
			throw new OutOfCanvasException("Coordinate is out of canvas range."+ canvasTemplate);
		}
	}

}
