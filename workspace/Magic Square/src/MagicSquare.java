
public class MagicSquare {

	int[][] square;
	int sum;
	
	final int DEFAULT_SQUARE = 3;
	
	public MagicSquare() 
	{
		
		square = new int[DEFAULT_SQUARE][DEFAULT_SQUARE];
		
	}
	
	public MagicSquare(int side) 
	{
		
		if(side < 3)
		{
			square = new int[DEFAULT_SQUARE][DEFAULT_SQUARE];
		}
		else if(side % 2 == 1)
		{
			square = new int[side + 1][side + 1];
		}
		else 
		{
			square = new int[side][side];
		}
		
	}
	
	public int getSize()
	{
		
		return square.length;
		
	}
	
	private void calculateSum()
	{
		
		for(int n:square[0])
		{
			
			sum += square[0][n];
			
		}
		
	}
	
	public int getSum()
	{

		calculateSum();
		return sum;
		
	}
	
	private boolean checkRow()
	{
		
		int rowSum = 0;
		
		for(int c = 0;c < square[0].length;c++)
		{
			
			rowSum += square[0][c];
			
		}
		
		if(rowSum == sum)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkColumn()
	{
		
		int columnSum = 0;
		
		for(int r = 0;r < square.length;r++)
		{
			
			columnSum += square[r][0];
					
		}
		
		if(columnSum == sum)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkDiagonal()
	{
		
		int diagonalSum = 0;
		
		for(int r = 0;r < square.length;r++)
		{
			
			for(int c = 0;c < square[r].length;c++)
			{
				
				if(r == c)
				{
					
					diagonalSum += square[r][c];
					
				}
				
			}
			
		}
		
		if(diagonalSum == sum)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean validSquare()
	{
		
		calculateSum();
		
		if(checkRow() && checkColumn() && checkDiagonal())
		{
			
			return true;
			
		}	
		else
		{
			
			return false;
			
		}
		
	}
	
	private void fillSquare()
	{
		
		
		
	}
	
	public void printSquare()
	{
		
		
		
	}

}
