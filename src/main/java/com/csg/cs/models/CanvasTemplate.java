package com.csg.cs.models;

public final class CanvasTemplate {

	private final char[][] bitmap;
	private final int width;
	private final int height;
	
	public CanvasTemplate(int width, int height) {
		//Adding 2 to both height and width as two characters are reserved for border.
		height+=2;
		width+=2;
		this.width = width;
		this.height = height;
		bitmap = new char[height][width];		
	}

	public void addBitToCanvasPaper(int xCordinate, int yCordinate, char key){
		bitmap[xCordinate][yCordinate] = key;
	}
	
	public char[][] getCanvasPaper() {
		return bitmap;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}



	@Override
	public String toString() {
		return " Canvas Paper [" + "width=" + (width-2) + ", height=" + (height-2) + "] ";
	}
	
	
}
