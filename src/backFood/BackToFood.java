package backFood;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import main.Position;
import main.PrintArray;

public class BackToFood {
	public int[][] backFoodBoard(int[][]board, ArrayList<Position> pos) {
		for(int i  = 0; i < pos.size()-1; i++) {						//Initiating i =1 because target food value should always be 2
			board[pos.get(i).x][pos.get(i).y] = 1;
			try {
				TimeUnit.MICROSECONDS.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintArray.printArray(board);
		}		
		return board;
	}
	public ArrayList<Position> backFoodPosition(ArrayList<Position>pos){
		ArrayList<Position> tempPos = new ArrayList<Position>();
		for(int i = pos.size()-1; i  >= 0; i--) {
			tempPos.add(pos.get(i));
		}
		return tempPos;
	}
}
