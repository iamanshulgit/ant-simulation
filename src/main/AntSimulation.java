package main;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//import clearScreen.*;


public class AntSimulation {
	//to check that rat reached destination or not.
	static boolean flag = false;
	static LinkedList<Position> pos = new <Position>LinkedList();
	
	//to check the condition that next move is valid or not
	private static boolean isValid(int[][]a,int x, int y) {
		if(x>=0 && y>=0 && x<a.length && y<a[0].length && a[x][y]==1) {
			return true;
		}
		return false;
	}
	public static void printArray(int[][]a) {
		for(int[] b : a) {
			for(int c : b)
				System.out.print(c + " ");
			System.out.println();
		}
		System.out.println();
	}
	public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
	
	private static boolean movPos(int[][]a, int xpos, int ypos) {
		
		
		Position p = new Position();
		p.x=xpos;
		p.y=ypos;
		pos.push(p);
		if(xpos>=0 && ypos>=0 && xpos<a.length && ypos<a[0].length) {		//make sure the x and y position in under the range
		if(a[xpos][ypos]==2) {												// to check if rat reached Destination
			flag = true;
			return true;
		}
		if(isValid(a, xpos, ypos)) {										//to check the next move and validate it
						a[xpos][ypos] = 3;
						/*try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ClearConsole();
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						printArray(a);
						Random random = new Random();
						int direction  = random.nextInt(4);
						
			if( movPos(a,xpos+1,ypos) && direction == 0 ) {
				//System.out.println("Moved Down   " + xpos + " " + ypos);
				p.x=xpos+1;
				p.y=ypos;
				pos.push(p);
				return true;
			}
			if(  movPos(a,xpos-1,ypos) && direction == 1) {
				//System.out.println("Moved Top    " + xpos + " " + ypos);
				p.x=xpos-1;
				p.y=ypos;
				pos.push(p);
				return true;
				
			}
			if( movPos(a,xpos,ypos+1) && direction == 2 ) {
				//System.out.println("Moved Right   " + xpos + " " + ypos);
				p.x=xpos;
				p.y=ypos+1;
				pos.push(p);
				return true;
				
			}
			if( movPos(a,xpos,ypos-1)&& direction == 3) {
				//System.out.println("Moved Left    " + xpos + " " + ypos);
				p.x=xpos;
				p.y=ypos-1;
				pos.push(p);
				return true;
				
			}			
		}
			a[xpos][ypos] = 8;													//if next move is not valid then change the value so it avoid back and forth movement
			try{pos.pop();}catch(Exception e) {
				System.out.print(e);
			}
			return false;

		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] puzzle = {
				{1,1,0,0,0,0},
				{0,1,0,1,0,1},
				{0,1,0,1,1,1},
				{0,1,1,1,0,1},
				{0,1,0,0,0,1},
				{0,1,0,0,0,1},
				{1,1,0,0,0,2}
		};
		int xPos = 0, yPos=0;
		movPos(puzzle, xPos, yPos);
		if(!flag)
			System.out.println("Rat stuck!!!-> No solution.");
		else
			System.out.println("Rat Won!!!");
		for(int i = 0; i < pos.size(); i++)
			System.out.println(pos.get(i).x + "  "+pos.get(i).y);
	}

}

