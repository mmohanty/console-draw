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

public class TestBucketFill {

	private CanvasTemplate canvasTemplate;
	private int height;
	private int width;
	private Shape shape;
	
	
	 @Rule
	 public ExpectedException thrown = ExpectedException.none();
	
	
	@Before
	public void setup(){
		height =4;
		width = 20;
		shape = new BucketFill();
	}
	
	@Test
	public void testBucketFill_when_canvas_isNot_configured() throws Exception{
		//do
		thrown.expect(CanvasNotFoundException.class);
		
		//test message
        thrown.expectMessage(is("Draw a canvas before you make any shape!"));
		
		//when
		shape.makeShape(canvasTemplate, "B 10 3 o".split(" "));
	}
	@Test
	public void testBucketFill_when_command_is_null() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Illegal argument. Pass a valid argument. Try again[B x y c]."));
		
		//when
		shape.makeShape(canvasTemplate, null);
	}
	
	@Test
	public void testBucketFill_when_command_isNot_valid() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Illegal argument. Pass a valid argument. Try again[B x y c]."));
		
		//when
		shape.makeShape(canvasTemplate, "B 10 3".split(" "));
	}
	
	@Test
	public void testBucketFill_when_height_width_are_wrong() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(IllegalArgumentException.class);
		
		//test message
        thrown.expectMessage(is("Illegal argument. Pass numeric value for X and Y coordinate. Try again[B x y c]."));
		
		//when
		shape.makeShape(canvasTemplate, "B R Q o".split(" "));
	}
	
	@Test
	public void testBucketFill_when_height_width_are_outOf_range() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		thrown.expect(OutOfCanvasException.class);
		
		//test message
        thrown.expectMessage(containsString("Coordinate is out of canvas range."));
		
		//when
		shape.makeShape(canvasTemplate, "B 21 5 o".split(" "));
	}
	
	@Test
	public void testBucketFill_when_command_is_valid() throws Exception{
		//do
		canvasTemplate = new CanvasTemplate(width, height);
		CanvasTestUtil.createBorder(canvasTemplate);
		
		//when
		shape.makeShape(canvasTemplate, "B 10 3 o".split(" "));
		
		//then
		char [][]bitmap = canvasTemplate.getCanvasPaper();
		Assert.assertSame(bitmap[1][1], 'o');
		Assert.assertSame(bitmap[3][3], 'o');
	}
	
}
