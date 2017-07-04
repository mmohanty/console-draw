package com.csg.cs.drawing.utils;

import static com.csg.cs.drawing.constants.DrawingAppConstant.H_BORDER;
import static com.csg.cs.drawing.constants.DrawingAppConstant.V_BORDER;

import com.csg.cs.models.CanvasTemplate;

public class CanvasTestUtil {

	
	public static void createBorder(CanvasTemplate template){
		int width = template.getWidth();
		int height = template.getHeight();
		drawLine(template, 0, 0, width-1, 0, H_BORDER);
		drawLine(template, 0, height-1, width-1, height-1, H_BORDER);
		drawLine(template, 0, 1, 0, height-2, V_BORDER);
		drawLine(template, width-1, 1, width-1, height-2, V_BORDER);
	}
	public static void drawLine(CanvasTemplate canvasTemplate, int x1, int y1, int x2, int y2, char charFeed) {
		for(int i=y1; i<=y2; i++) {
			for(int j=x1; j<=x2; j++) {
				canvasTemplate.addBitToCanvasPaper(i, j, charFeed);				
			}
		}		 
  	} 
}
