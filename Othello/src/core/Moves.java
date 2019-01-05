package core;

import java.util.LinkedList;
import java.util.ListIterator;

public class Moves {
	private char otherMove = 'c';
	private static final char WHITE = 'w';
	private static final char BLACK = 'b';
	private static final char CLEAR = 'c';
	private char[][] grid;
	private LinkedList<Move> myMoves = new LinkedList<Move>();
	
	public Moves(char[][] tmp){
		this.grid = tmp;
		convertGridToAList(tmp);
	}
	
	public void convertGridToAList(char[][] mygrid)
	{
		for(int i=0;i<mygrid.length;i++)
			for(int j=0;j<mygrid[i].length;j++)
			{
				myMoves.add(new Move(i,j,mygrid[i][j]));
			}
	}
	public static void main(String[] args){
		char[][] mygrid = new char[8][8];
		for(int i=0;i<mygrid.length;i++)
			for(int j=0;j<mygrid[0].length;j++)
				if(i%2==0)
					mygrid[i][j]='c';
				else
					mygrid[i][j]='w';
		mygrid[3][4]='w';
		mygrid[4][3]='b';
		mygrid[3][3]='w';
		mygrid[4][4]='b';
		
		for(int i=0;i<mygrid.length;i++)
		{
			System.out.println("");
			for(int j=0;j<mygrid[0].length;j++)
				System.out.print(mygrid[i][j]+" ");
		}
		System.out.println("");
		
		//DO moves
		Moves m = new Moves(mygrid);
		m.takeTurn('b', 1, 1);
		m.takeTurn('b', 2, 1);
		for(int i=0;i<mygrid.length;i++){
			System.out.println("");
			for(int j=0;j<mygrid[0].length;j++)
				System.out.print(mygrid[i][j]+" ");
		}
	
		ListIterator<Move> myit = m.myMoves.listIterator();
		while(myit.hasNext())
		{
			System.out.println(myit.next());
		}
	}
	@SuppressWarnings("unused")
	private void takeTurn(char move, int row, int col) {
		grid[row][col]=move;
		direction(row,col,move,0,-1);
		direction(row,col,move,0,1);
		direction(row,col,move,1,0);
		direction(row,col,move,-1,0);
		direction(row,col,move,1,1);
		direction(row,col,move,1,-1);
		direction(row,col,move,-1,1);
		direction(row,col,move,-1,-1);
		
	}

	private boolean isValidMove(char move, int xStart, int yStart)
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
		
	}
	
	private void direction(int row, int column, char colour, int colDir, int rowDir) {
		int currentRow=row+rowDir;
		int currentCol = column + colDir;
		if (currentRow==8 || currentRow<0 || currentCol==8 || currentCol<0)
		{
			return;
		}
		while (grid[currentRow][currentCol]==BLACK || grid[currentRow][currentCol]==WHITE)
		{
			if(grid[currentRow][currentCol]==colour)
			{
				while(row!=currentRow && column!=currentCol)
				{
					 grid[currentRow][currentCol]=colour;
			          currentRow=currentRow-rowDir;
			          currentCol=currentCol-colDir;
			    }
			    break;
			}else
			{
		      currentRow=currentRow + rowDir;
		      currentCol=currentCol + colDir;
			}
			if (currentRow<0 || currentCol<0 || currentRow==8 || currentCol==8)
			{ 
			  break;
			}
		}
	}

	
}
