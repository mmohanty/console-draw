package com.csg.cs.drawing.shapes;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.csg.cs.drawing.exceptions.CanvasNotFoundException;
import com.csg.cs.drawing.exceptions.IllegalArgumentException;
import com.csg.cs.drawing.exceptions.OutOfCanvasException;
import com.csg.cs.drawing.utils.CanvasTestUtil;
import com.csg.cs.models.CanvasTemplate;

public class TestRectangle {

	private CanvasTemplate canvasTemplate;
	private int height;
	private int width;
	Shape shape;
	
	
	 @Rule
	 public ExpectedException thrown = ExpectedException.none();
	
	
	@Before
	public void setup(){
		height = 4;
		width = 20;
		shape = new Rectangle();
	}
	
	@Test
	public void testRectangle_when_canvas_isNot_configured() throws Exception{
		//do
		thrown.expect(CanvasNotFoundException.class);
		
		//test message
        thrown.expectMessage(is("Draw a canvas before you make any shape!"));
		
		//when
		shape.makeShape(canvasTemplate, "R 14 1 18 3".split(" "));
	}
	@Test
	public void testRectangle_when_command_is_null() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Pass valid arguments to Rectangle command! Try again[R x1 y1 x2 y2]."));
		
		//when
		shape.makeShape(canvasTemplate, null);
	}
	
	@Test
	public void testRectangle_when_command_isNot_valid() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Pass valid arguments to Rectangle command! Try again[R x1 y1 x2 y2]."));
		
		//when
		shape.makeShape(canvasTemplate, "R 14 1 18".split(" "));
	}
	
	@Test
	public void testRectangle_when_cordinates_are_wrong() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Illegal argument.Pass numeric argument for x1, y1, x2 and y2. Try again[R x1 y1 x2 y2]."));
		
		//when
		shape.makeShape(canvasTemplate, "R R 2 Q 2".split(" "));
	}
	
	@Test
	public void testRectangle_when_height_width_are_outOf_range() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(OutOfCanvasException.class);
		
		//test message
        thrown.expectMessage(containsString("Coordinate is out of canvas range."));
		
		//when
		shape.makeShape(canvasTemplate, "R 14 1 28 3".split(" "));
	}
	
	@Test
	public void testRectangle_when_command_is_valid() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		CanvasTestUtil.createBorder(canvasTemplate);
		
		//when
		shape.makeShape(canvasTemplate, "R 14 1 18 3".split(" "));
		
		//then
		char [][]bitmap = canvasTemplate.getCanvasPaper();
		Assert.assertSame(bitmap[1][14], 'X');
		Assert.assertSame(bitmap[1][15], 'X');
		Assert.assertSame(bitmap[1][16], 'X');
		Assert.assertSame(bitmap[1][17], 'X');
		Assert.assertSame(bitmap[1][18], 'X');
		Assert.assertSame(bitmap[2][14], 'X');
		Assert.assertSame(bitmap[2][18], 'X');
		Assert.assertSame(bitmap[3][14], 'X');
		Assert.assertSame(bitmap[3][18], 'X');
	}
	
}
