/******************************************************************
 * A Project of Sorts
 * 
 * Implements Search Algorithms on integer arrays
 * Includes Linear and Binary searches
 * Binary Search requires a sorted list
 * All Search methods are static
 * All Search helper methods are private
 * 
 * @author 
 *
 *******************************************************************/
public class Search 
{
	/**
	 * Implements a Linear Search
	 *    <Include Algorithm Steps here>
	 * @param list - integer list to search in
	 * @param num - integer to search for
	 * @return index of found item, -1 if not found
	 */
	public static int linearSearch(int[] list, int num)
	{
		
		boolean found = false;
		int n = 0;
		
		while(!found)
		{
			
			if(list[n] == num)
			{
				return n;
			}
			
			n++;
			
		}
		
		return -1;
		
	}
	
	/**
	 * Implements a Binary Search
	 *    <Include Algorithm Steps here>
	 * Pre: list must be sorted
	 * 
	 * @param list - integer list to search in
	 * @param num - integer to search for
	 * @return index of found item, -1 if not found
	 */
	public static int binarySearch(int[] list, int num)
	{

		boolean found = false;
		int low = 0;
		int high = list.length - 1;
		
		while(!found)
		{
			
			if(num < (list[high] + list[low])/2)
			{
				if((high + low) % 2 == 0)
				{
					high = (high + low)/2;
				}
				else
				{
					high = (high + low)/2 + 1;
				}
			}
			else if(num > (list[high] + list[low])/2)
			{
				if((high + low) % 2 == 0)
				{
					low = (high + low)/2;
				}
				else
				{
					low = (high + low)/2 + 1;
				}
			}
			else
			{
				if((list[high] + list[low])/2 == num)
				{
					if((high + low) % 2 == 0)
					{
						return (high + low)/2;
					}
					else
					{
						return (high + low)/2 + 1;
					}
				}
				else
				{
					return -1;
				}
			}
			
		}
		return -1;
		
	}
}
