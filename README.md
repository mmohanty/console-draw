# console-draw
It's maven project built on JDK 8. Import this as an existing maven project into eclipse workspace.
Run com.csg.cs.drawing.main.DrawingAppLauncher.java

-------------------
Command 		Description
C w h           Should create a new canvas of width w and height h.

L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
                
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
                
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the same as that of the "bucket fill" 				tool in paint programs.

Q               Should quit the program.
-------------------------

Assumption : 
1. Overlapping scenario is not handled.
2. Lines can be drawn vertically or horizontally. Diagonal lines are not covered in this application.

3. Console coordinate : (x,y) origin coordinate is the left top corner. X coordinate grows horizontally towards right. whereas y coordinate wi moves vertically towards bottom of console.

(0,0)
  ------------X 
  |
  |
  |
  y
  
