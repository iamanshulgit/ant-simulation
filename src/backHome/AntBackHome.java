package backHome;
import main.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class AntBackHome {
		public int[][] backHomeBoard(int[][]board, ArrayList<Position> pos) {
			for(int i  = 1; i < pos.size(); i++) {						//Initiating i =1 because target food value should always be 2
				board[pos.get(i).x][pos.get(i).y] = 1;
				try {
					TimeUnit.MICROSECONDS.sleep(500000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintArray.printArray(board);
			}		
			return board;
		}
		public ArrayList<Position> backHomePosition(ArrayList<Position>pos){
			ArrayList<Position> tempPos = new ArrayList<Position>();
			for(int i = pos.size()-1; i  >= 0; i--) {
				tempPos.add(pos.get(i));
			}
			return tempPos;
		}
}
