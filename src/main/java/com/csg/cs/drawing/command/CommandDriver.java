package com.csg.cs.drawing.command;

import com.csg.cs.drawing.constants.DrawingAppConstant;
import com.csg.cs.drawing.exceptions.DrawingException;
import com.csg.cs.drawing.exceptions.IllegalArgumentException;
import com.csg.cs.drawing.paint.apies.DefaultShapeDecorator;
import com.csg.cs.drawing.shapes.BucketFill;
import com.csg.cs.drawing.shapes.Canvas;
import com.csg.cs.drawing.shapes.Line;
import com.csg.cs.drawing.shapes.Rectangle;
import com.csg.cs.drawing.shapes.Shape;
import com.csg.cs.models.CanvasTemplate;
/**
 * Drives the command and calls Shape API to make a shape on canvas template.
 * @author mohanty
 * @version 1.0
 */
public class CommandDriver {

	private static CanvasTemplate canvasTemplate;
	
	public enum Command {
		LINE("L") {
			@Override
			public void execute() throws DrawingException{
				Shape shape = new DefaultShapeDecorator(new Line());
				shape.makeShape(canvasTemplate, getParams().split(" "));
			}
		}, RECTANGLE("R") {
			@Override
			public void execute() throws DrawingException{
				Shape shape = new DefaultShapeDecorator(new Rectangle());
				shape.makeShape(canvasTemplate, getParams().split(" "));
			}
		}, FILL("B") {
			@Override
			public void execute() throws DrawingException{
				Shape shape = new DefaultShapeDecorator(new BucketFill());
				shape.makeShape(canvasTemplate, getParams().split(" "));
			}
		}, QUIT("Q") {
			@Override
			public void execute() throws DrawingException{
				System.out.println("Program Terminated!");
				System.exit(0);
			}
		}, CANVAS("C"){
			@Override
			public void execute() throws DrawingException{
				String[] cmd = getParams().split(" ");
				if(cmd == null || cmd.length != DrawingAppConstant.LENGTH_OF_CANVAS_CMD){
					throw new IllegalArgumentException("Illegal argument passed to Canvas command! Try again[C width height].");
				}
				try{
					canvasTemplate = new CanvasTemplate(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]));
				}catch(NumberFormatException ex){
					throw new IllegalArgumentException("Illegal argument! Pass numeric value for width and height. Try again[C width height].");
				}
				Shape shape = new DefaultShapeDecorator(new Canvas());
				shape.makeShape(canvasTemplate, cmd);
			}
		};
		Command(String command){
			this.key = command;
		}
		
		private String key;
		private String params;
		
		public String getKey(){
			return this.key;
		}
		
		public void setParams(String params){
			this.params = params;
		}
		
		public String getParams(){
			return this.params;
		}
		public abstract void execute() throws Exception;
		
		public static Command getInstance(String userCommand) {
			for(Command command : Command.values()){
				if(( userCommand != null && userCommand.length() >= 1) && command.getKey().equals(String.valueOf(userCommand.charAt(0)))){
					command.setParams(userCommand);
					return command;
				}
			}
			return null;
		}
		
	}
	
}
