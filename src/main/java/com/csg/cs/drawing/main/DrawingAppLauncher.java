package com.csg.cs.drawing.main;

import java.util.Scanner;

import com.csg.cs.drawing.command.CommandDriver;
import com.csg.cs.drawing.exceptions.DrawingException;

public class DrawingAppLauncher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String key = new String();
		while(true) {
			System.out.print("Enter Command[C,L,R,B,Q]:");
			key = scan.nextLine();
			CommandDriver.Command command = CommandDriver.Command.getInstance(key);
			try{
				if(command == null){
					System.out.println("Bad command. Try again!!\n");
					continue;
				}
				command.execute();
			} catch(DrawingException ex){
				System.out.println(ex.getMessage()+"\n");
			}catch (Exception e) {
				System.out.println("Error Occured\n");
				e.printStackTrace();
				System.exit(1);
				scan.close();
			}
		}
	}
}
