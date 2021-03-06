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

		for(int n = 0; n < list.length;n++)
		{
			
			if(list[n] == num)
			{
				return n;
			}
			
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

		int high = list.length - 1;
		int low = 0;
		int mid = (high + low)/2;
		
		while(low <= high) 
		{
		
			mid = (high + low) / 2;
			
			if(list[mid] == num) 
			{
				return mid;
			} 
			else if(list[mid] > num) 
			{
				high = mid - 1;
			} 
			else if(list[mid] < num) 
			{
				low = mid + 1;
			}
			
		}
		
		return -1;
		
	}
}
