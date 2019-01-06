package core;
import java.util.LinkedList;

import javax.management.RuntimeErrorException;

import core.Field;

public class Board {

	//Board Members and Methods
	private static final int MAX_SIZE = 8;
	private static final String ERR_INVALID_SIZE = "Error: Not a Proper Board Size";
	private static final String ERR_INVALID_INPUT = "Error: Not a proper Input value";
	private static final char WHITE = 'w';
	private static final char BLACK = 'b';
	private static final char CLEAR = 'c';
	public char currMove =' ';
	public char otherMove =' ';
	private char[][] grid;
	private LinkedList<Move> myMoves = new LinkedList<Move>();
	
	public Board(){
		grid = new char[MAX_SIZE][MAX_SIZE];
	}
	public Board(char[][] state){
		grid = new char[MAX_SIZE][MAX_SIZE];
		if(state.length != grid.length && state[1].length != grid[1].length)
			throw new RuntimeErrorException(null);
		grid = state; 
	}
	
	@SuppressWarnings("unused")
	private void takeTurn(char move, int row, int col) {
		if(validMove(move,row,col)){
			grid[row][col]=move;
			singleMove(row,col,move,0,-1);
			singleMove(row,col,move,0,1);
			singleMove(row,col,move,1,0);
			singleMove(row,col,move,-1,0);
			singleMove(row,col,move,1,1);
			singleMove(row,col,move,1,-1);
			singleMove(row,col,move,-1,1);
			singleMove(row,col,move,-1,-1);
		}
		else
			System.out.println("Not a valid move");
	}

	private boolean validMove(char move, int xStart, int yStart)
	{
		
		if (grid[xStart][yStart] != 'c' | !(isOnBoard(xStart,yStart)))
		{
			return false;
		}
		grid[xStart][yStart] = move;
		if(move == 'b')
			otherMove = 'w';
		if(move == 'w')
			otherMove = 'b';
		return true;
		
	}
	
	private boolean isOnBoard(int xStart, int yStart) {
		if(xStart > 7 || xStart < 0)
			return false;
		if(yStart > 7 || yStart < 0)
			return false; 
		else
			return true;
	}

	private void singleMove(int row, int column, char colour, int colDir, int rowDir) {
		int currRow=row+rowDir;
		int currCol = column + colDir;
		if (currRow==8 || currRow<0 || currCol==8 || currCol<0)
			return;
		
		while (grid[currRow][currCol]==BLACK || grid[currRow][currCol]==WHITE)
		{
			if(grid[currRow][currCol]==colour)
			{
				while(row!=currRow && column!=currCol)
				{
					 grid[currRow][currCol]=colour;
			          currRow=currRow-rowDir;
			          currCol=currCol-colDir;
			    }
			    break;
			}else
			{
		      currRow=currRow + rowDir;
		      currCol=currCol + colDir;
			}
			if (currRow<0 || currCol<0 || currRow==8 || currCol==8)
			  break;
			
		}
	}

	
	class Move{
		int x=0;
		int y=0;
		char m = ' ';
		
		public Move(int x, int y, char m)
		{
			this.x=x;
			this.y=y;
			this.m =m;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}
		
		public void setX(int x)
		{
			this.x = x;
		}
		
		public void setY(int y){
			this.y = y;
		}
		
		public String toString(){
			String s = new String("X:" + x + " Y:" + y + " M:"+ m +"\n");
			return s;
			
		}
	}
	
}
