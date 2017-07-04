package com.csg.cs.drawing.shapes;

import com.csg.cs.drawing.constants.DrawingAppConstant;
import com.csg.cs.drawing.exceptions.CanvasNotFoundException;
import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.drawing.exceptions.IllegalArgumentException;
import com.csg.cs.drawing.exceptions.OutOfCanvasException;
import com.csg.cs.models.CanvasTemplate;
/**
 * This will search for all the positions in the canvas which are reachable from the given coordinate. And it will be filled by the given 
 * alphabet/character. It will not move further if any blocker or boundary comes in its path.
 * @author mohanty
 * @version 1.0
 *
 */
public class BucketFill implements Shape {

	@Override
	public void makeShape(CanvasTemplate canvasTemplate, String[] arguments) throws DrawingException {
		if(canvasTemplate == null){
			throw new CanvasNotFoundException("Draw a canvas before you make any shape!");
		}
		if(arguments == null || arguments.length != DrawingAppConstant.LENGTH_OF_FILL_CMD){
			throw new IllegalArgumentException("Illegal argument. Pass a valid argument. Try again[B x y c].");
		}
		try{
			int x = Integer.valueOf(arguments[1]);
			int y = Integer.valueOf(arguments[2]);
			bucketFill(x, y, canvasTemplate, arguments[3].charAt(0));
		}catch(NumberFormatException ex){
			throw new IllegalArgumentException("Illegal argument. Pass numeric value for X and Y coordinate. Try again[B x y c].");
		}catch(ArrayIndexOutOfBoundsException ex){
			throw new OutOfCanvasException("Coordinate is out of canvas range."+ canvasTemplate);
		}
		
	}
	private void bucketFill(int x, int y, CanvasTemplate template, char key) throws DrawingException{
		char[][] bitmap = template.getCanvasPaper();

		// if position is filled, terminate the recursion.
		if ((int) bitmap[y][x] != 0) {
			return;
		}
		// check the boundary
		if (x > 0 || x < template.getHeight() || y > 0 || y < template.getWidth()) {
			// if position is not filled, fill with the key.
			if ((int) bitmap[y][x] == 0) {
				template.addBitToCanvasPaper(y, x, key);
			}
			bucketFill(x + 1, y, template, key);
			bucketFill(x - 1, y, template, key);
			bucketFill(x, y - 1, template, key);
			bucketFill(x, y + 1, template, key);
		}
		
	}

}
