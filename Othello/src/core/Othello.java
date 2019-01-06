package core;

public class Othello {

	private static final char NO_CHIP = ' ';
	private static final char BLACK = 'b';
	private static final char WHITE = 'w';
	private static final int BOARD_SIZE = 8;
	
	private char[][] grid = new char[BOARD_SIZE][BOARD_SIZE];
	
	private Board gameBoard = new Board(BOARD_SIZE);
	
	public Othello(){
		
		for (int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				grid[i][j]=NO_CHIP;
			}
		}
		grid[3][3]=WHITE;
		grid[3][4]=BLACK;
		grid[4][3]=BLACK;
		grid[4][4]=WHITE;
		
		this.updateView();
	}

	public void play()
	{
		char move=BLACK;
		while(!this.gameOver())
		{
			this.displayStatus(move);
			int row=0;
			int col=0;
			boolean valid=false;
			
			while(!valid)
			{
				//The following code will take the Javascript 
				//data and make a call which will then run the following code. 
				//row = this.getUserInput().x;
				//col = this.getUserInput().y;
				valid = this.validMove(move,row,col);
			}
			
			this.takeTurn(move,row,col);
			if(move == BLACK)
			{
				move=WHITE;
			}else
			{
				move=BLACK;
			}
		}
		this.endGame();
	}
	private void endGame() {
		// TODO Auto-generated method stub
		
	}

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
		
		this.updateView();
		
	}

	//Method does the checking for all adjacent positions of the move that was just taken
	//if it needs to be flipped then this will flip the chips and we can recount the chips on the board. 
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

	private void displayStatus(char move) {
		// TODO Auto-generated method stub
		
	}

	private boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validMove(char move, int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	private void updateView() {
		for (int i=0; i<grid.length; i++)
	    {
	      for (int j=0; j<grid[i].length; j++)
	      {
	        if (grid[i][j]==WHITE)
	        {
	          gameBoard.putPeg("white",i,j);
	        }else if(grid[i][j]==BLACK)
	        {
	          gameBoard.putPeg("black",i,j);
	        }
	      }
	    }
		
	}
	
}

