package com.csg.cs.drawing.utils;

import com.csg.cs.models.CanvasTemplate;

public class LineUtils {

	public static void drawLine(CanvasTemplate canvasTemplate, int x1, int y1, int x2, int y2, char bit) {
		for(int i=y1; i<=y2; i++) {
			for(int j=x1; j<=x2; j++) {
				canvasTemplate.addBitToCanvasPaper(i, j, bit);			
			}
		}	
		//canvasTemplate.addBitToCanvasPaper(0, 0, 'X');
  	}
	
}
