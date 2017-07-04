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

public class TestLine {

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
		shape = new Line();
	}
	
	@Test
	public void testLine_when_canvas_isNot_configured() throws Exception{
		//do
		thrown.expect(CanvasNotFoundException.class);
		
		//test message
        thrown.expectMessage(is("Draw a canvas before you make any shape!"));
		
		//when
		shape.makeShape(canvasTemplate, "L 1 2 6 2".split(" "));
	}
	@Test
	public void testLine_when_command_is_null() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Please check the argument passed to Line command! Try again[L x1 y1 x2 y2]."));
		
		//when
		shape.makeShape(canvasTemplate, null);
	}
	
	@Test
	public void testLine_when_command_isNot_valid() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Please check the argument passed to Line command! Try again[L x1 y1 x2 y2]."));
		
		//when
		shape.makeShape(canvasTemplate, "L 1 2".split(" "));
	}
	
	@Test
	public void testLine_when_cordinates_are_wrong() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Illegal argument. Pass numeric values for x1, y1, x2 and y2. Try again[L x1 y1 x2 y2]."));
		
		//when
		shape.makeShape(canvasTemplate, "L R 2 Q 2".split(" "));
	}
	
	@Test
	public void testLine_when_height_width_are_outOf_range() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(OutOfCanvasException.class);
		
		//test message
        thrown.expectMessage(containsString("Coordinate is out of canvas range."));
		
		//when
		shape.makeShape(canvasTemplate, "L 1 2 24 2".split(" "));
	}
	
	@Test
	public void testLine_when_command_is_valid() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		CanvasTestUtil.createBorder(canvasTemplate);
		
		//when
		shape.makeShape(canvasTemplate, "L 1 2 6 2".split(" "));
		
		//then
		char [][]bitmap = canvasTemplate.getCanvasPaper();
		Assert.assertSame(bitmap[2][1], 'X');
		Assert.assertSame(bitmap[2][2], 'X');
		Assert.assertSame(bitmap[2][3], 'X');
		Assert.assertSame(bitmap[2][4], 'X');
		Assert.assertSame(bitmap[2][5], 'X');
		Assert.assertSame(bitmap[2][6], 'X');
	}
	
}
