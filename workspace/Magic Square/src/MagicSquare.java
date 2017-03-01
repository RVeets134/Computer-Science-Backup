/*
 * Rakesh Veetekat
 * Period 6
 * Magic Square
 * This program creates a magic square using a particular algorithm for squares created with
 * an odd side length.
 */
public class MagicSquare {

	int[][] square;
	int side;
	int sum;
	
	final int DEFAULT_SQUARE = 3;
	
	//Default constructor that creates 3 by 3 square
	public MagicSquare() 
	{
		
		square = new int[DEFAULT_SQUARE][DEFAULT_SQUARE];
		side = DEFAULT_SQUARE;
		fillSquare();
		calculateSum();
		
	}
	
	/**
	 * This constructor creates a magic square with a side passed to it
	 * @param side - side for the magic square
	 */
	public MagicSquare(int side) 
	{
		
		//Determines if side length given needs to be modified for algorithm
		if(side < 3)
		{
			square = new int[DEFAULT_SQUARE][DEFAULT_SQUARE];
			this.side = DEFAULT_SQUARE;
		}
		else if(side % 2 == 0)
		{
			square = new int[side + 1][side + 1];
			this.side = side + 1;
		}
		else 
		{
			square = new int[side][side];		
			this.side = side;
		}
		
		//Calls methods to fill square and calculate magic number
		fillSquare();
		calculateSum();
		
	}
	
	/**
	 * This method can be used to get the side of the magic square
	 * @return - The side of the square is returned
	 */
	public int getSide()
	{
		
		return side;
		
	}
	
	/**
	 * Method used to calculate magic number for square
	 */
	private void calculateSum()
	{
		
		for(int n = 0;n < side;n++)
		{
			
			sum += square[0][n];
			
		}
		
	}
	
	/**
	 * Method used to allow user to access magic number of square
	 * @return - The sum, or magic number, of the magic square is returned
	 */
	public int getSum()
	{

		return sum;
		
	}
	
	/**
	 * This method checks if all the rows of the square sum up to the magic number
	 * @return - Returns true or false based on if the rows sum to magic number
	 */
	private boolean availableRows()
	{
		
		int rowSum = 0;
		
		for(int r = 0;r < side;r++)
		{
			
			for(int c = 0;c < side;c++)
			{
			
				//Sums row, then checks if equal to magic number
				rowSum += square[r][c];
			
			}
		
			if(rowSum != sum)
			{
				return false;
			}
			
			//Reset sum of row to check next row
			rowSum = 0;
		
		}
		
		//Every row checked and proven valid
		return true;
		
	}
	
	/**
	 * This method checks if all columns sum to the magic number
	 * @return - This returns whether or not every column sums to the magic number
	 */
	private boolean availableColumns()
	{
		
		int columnSum = 0;
		
		for(int c = 0;c < side;c++)
		{

			for(int r = 0;r < side;r++)
			{
			
			//Adds up column values, checks with magic number	
			columnSum += square[r][c];
			
			}
			
			if(columnSum != sum)
			{
				return false;
			}	
			
			//Resets column sum to available next column
			columnSum = 0;
			
		}
		
		//Columns passed through checked and all valid
		return true;
		
	}
	
	/**
	 * This method checks to see if the 2 major diagonals add up to the magic number
	 * @return - This value will indicate whether both diagonals add up to the magic number
	 * or not
	 */
	private boolean availableDiagonals()
	{
		
		int diagonalSum = 0;
		int r = 0;
		int c = 0;
		
		//First checking the diagonal where the row and column index are same
		while(r < side)
		{
			
			diagonalSum += square[r][c];
			
			//Increment to add next value on diagonal
			r++;
			c++;
			
		}
		
		if(diagonalSum != sum)
		{
			return false;
		}
		
		//Reset values to available 2nd diagonal
		diagonalSum = 0;
		r = 0;
		c = side - 1;
		
		//Checking whether second diagonal is valid where column is 
		//decremented every time the row is incremented
		while(c >= 0)
		{
			
			diagonalSum += square[r][c];
			
			//Increment row and decrement column to get next value on diagonal
			r++;
			c -= 1;
			
		}
		
		if(diagonalSum != sum)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	/**
	 * This method checks to see whether the magic square is valid or not 
	 * by checking the sums of its row, columns, and diagonals
	 * @return - Returns true if square passes through the checks of each
	 * row, column, and diagonal, and false if it doesn't
	 */
	public boolean validSquare()
	{
		
		if(availableRows() && availableColumns() && availableDiagonals())
		{
			
			return true;
			
		}	
		else
		{
			
			return false;
			
		}
		
	}
	
	/**
	 * This method fills the square using the algorithm to fill odd sided
	 * squares to create magic squares
	 */
	private void fillSquare()
	{
		
		int r = 0;
		int c = side/2;
		
		square[r][c] = 1;
	
		boolean[][] available = new boolean[side][side];
		available[r][c] = true;
	
		
		for (int n = 2;n <= side*side;n++)
		{
			
			//checks if top right in bounds
			if (r-1 >= 0 && c+1 < side)
			{
				
				//block top right available, puts in value
				if (available[r-1][c+1])
				{
					
					r+=1;
					square[r][c] = n;
					available[r][c] = true;	
					
				}
				//block top right not available, places value to the right
				else
				{

					r -= 1;
					c += 1;
					square[r][c] = n;
					available[r][c] = true;
					
				}
				
			}
			
			//block not in bounds
			else 
			{
				
				//block top right out of bounds and above square
				if (r-1 == -1 && c+1 < side)
				{
					
					//assigns value to right and bottom
					r = side-1;
					c++;
					square[r][c] = n;
					available[r][c] = true;
					
					
				}
				
				//block top right out of bounds and to side of square, but not above square
				else if (c+1 == side && r-1 >= 0)
				{
					
					//assigns value to block to very left and above current row
					c = 0;
					r--;
					square[r][c] = n;
					available[r][c] = true;
					
					
				}
				
				//block above and to right of square
				else
				{
					
					//assigns value below current block
					r++;
					square[r][c] = n;
					available[r][c] = true;
					
				
				}
				
			}
			
		}
			
	}
	
	/**
	 * This method returns the magic square as a string with appropriate spacing
	 */
	public String toString()
	{
		
		String string="";
		for (int r = 0;r < side;r++)
		{
			for (int c = 0;c < side;c++)
			{
				string += square[r][c]+"\t";
			}
			string +="\n";
			
		}
				
		return string;
		
	}

}
