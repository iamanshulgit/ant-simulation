package main;

import java.util.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
		pos.add(p);
		if(xpos>=0 && ypos>=0 && xpos<a.length && ypos<a[0].length) {		//make sure the x and y position in under the range
		if(a[xpos][ypos]==2) {												// to check if rat reached Destination
			/*p.x = xpos;
			p.y = ypos;
			pos.add(p);
			*/
			flag = true;
			return true;
		}
		if(isValid(a, xpos, ypos)) {										//to check the next move and validate it
						a[xpos][ypos] = 3;
						try {
							TimeUnit.MICROSECONDS.sleep(50000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							TimeUnit.MICROSECONDS.sleep(50000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						PrintArray.printArray(a);
						Random random = new Random();
						int direction  = random.nextInt(4);
						
			if( movPos(a,xpos+1,ypos) && direction == 0 ) {
				//System.out.println("Moved Down   " + xpos + " " + ypos);
				/*p.x=xpos+1;
				p.y=ypos;
				pos.add(p);
				*/
				return true;
			}
			if(  movPos(a,xpos-1,ypos) && direction == 1) {
				//System.out.println("Moved Top    " + xpos + " " + ypos);
				/*p.x=xpos-1;
				p.y=ypos;
				pos.add(p);
				*/
				return true;
				
			}
			if( movPos(a,xpos,ypos+1) && direction == 2 ) {
				//System.out.println("Moved Right   " + xpos + " " + ypos);
				/*p.x=xpos;
				p.y=ypos+1;
				pos.add(p);
				*/
				return true;
				
			}
			if( movPos(a,xpos,ypos-1)&& direction == 3) {
				//System.out.println("Moved Left    " + xpos + " " + ypos);
				/*p.x=xpos;
				p.y=ypos-1;
				pos.add(p);
				*/
				return true;
				
			}			
		}
			a[xpos][ypos] = 0;													//if next move is not valid then change the value so it avoid back and forth movement
			/*p.x = xpos;
			p.y = ypos;
			*/
			try{
				pos.remove(pos.size()-1);
				}catch(Exception e) {
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
		System.out.println(pos.size());
		for(int i = 0; i < pos.size(); i++)
			{
				System.out.println(pos.get(i).x + "  "+pos.get(i).y);
			}
	}

}

