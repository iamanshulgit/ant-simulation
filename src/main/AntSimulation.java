package main;

import java.util.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import backHome.AntBackHome;

public class AntSimulation {
	//to check that rat reached destination or not.
	static boolean flag = false;
	static ArrayList<Position> pos = new <Position>ArrayList();
	
	//to check the condition that next move is valid or not
	private static boolean isValid(int[][]a,int x, int y) {
		if(x>=0 && y>=0 && x<a.length && y<a[0].length && a[x][y]==1) {
			return true;
		}
		return false;
	}
	
	private static boolean movPos(int[][]a, int xpos, int ypos) {
		
		
		Position p = new Position();
		p.x=xpos;
		p.y=ypos;
		//pos.add(p);
		if(xpos>=0 && ypos>=0 && xpos<a.length && ypos<a[0].length) {		//make sure the x and y position in under the range
		if(a[xpos][ypos]==2) {												// to check if rat reached Destination
			pos.add(p);
			
			flag = true;
			return true;
		}
		if(isValid(a, xpos, ypos)) {										//to check the next move and validate it
						a[xpos][ypos] = 3;
						try {
							TimeUnit.MICROSECONDS.sleep(500000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						PrintArray.printArray(a);
						
			if( movPos(a,xpos+1,ypos)  ) {
				//System.out.println("Moved Down   " + xpos + " " + ypos);
				pos.add(p);
				
				return true;
			}
			if(  movPos(a,xpos-1,ypos) ) {
				//System.out.println("Moved Top    " + xpos + " " + ypos);
				pos.add(p);
				
				return true;
				
			}
			if( movPos(a,xpos,ypos+1) ) {
				//System.out.println("Moved Right   " + xpos + " " + ypos);
				pos.add(p);
				
				return true;
				
			}
			if( movPos(a,xpos,ypos-1)) {
				//System.out.println("Moved Left    " + xpos + " " + ypos);
				pos.add(p);
				
				return true;
				
			}			
		}
			
		if(a[xpos][ypos] ==  3) {
			a[xpos][ypos] = 3;
			try{
				pos.remove(p);
				}catch(Exception e) {
				System.out.print(e);
			}
		}
		else {
		a[xpos][ypos] = 0;													//if next move is not valid then change the value so it avoid back and forth movement
		}
			return false;
		
		}
		return false;
		
	}
	
	public static void start(int[][] board, int xPos, int yPos) {
		movPos(board, xPos, yPos);
		if(!flag) {
			System.out.println("Ant stuck!!!-> No solution.");	
		}
		else {
			System.out.println("Ant reached to FOOD!!!");
			System.out.println("Getting food back to Home");
			AntBackHome backHome = new AntBackHome();
			board = backHome.backHomeBoard(board, pos);	
			pos = backHome.backHomePosition(pos);
			System.out.println("Ant back Home!!!");
		}
		PrintArray.printArray(board);
		/*
		 * for(int i = 0; i < pos.size(); i++) { System.out.println(pos.get(i).x +
		 * "  "+pos.get(i).y); }
		 */
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] puzzle = {
				{1,1,0,0,0,0},
				{0,1,0,1,0,1},
				{0,1,0,1,1,1},
				{0,1,1,1,0,1},
				{0,1,0,0,0,1},
				{0,1,0,0,0,2}
		};
		int xPos = 0, yPos=0; 						//Ant starting position
		start(puzzle,xPos,yPos);
				
	}

}

