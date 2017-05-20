/******************************************************************
 * A Project of Sorts
 * 
 * Implements Sort Algorithms on integer arrays
 * Includes Bubble, Insertion, Selection, Merge, and Quick Sorts
 * Merge and Quick Sorts are recursive
 * All Sort methods are static
 * All Sort helper methods are private
 * 
 * @author 
 *
 *******************************************************************/
public class Sort
{
  
  /************************
   * Implements Bubble Sort
   *  1.Scan list and compare adjacent elements
   *  2.Swap if out of order and set a flag
   *  3.Repeat 1-2 until no swaps are made (flag is false)
   *    scanning one less at the end each pass
   * Pre: unsorted array parameter
   * Post: sorted array parameter
   * 
   * @param aSort integer array
   **/
  public static void bubbleSort(int[] aSort)
  {
    
	  boolean done = false;
	  int largerValue = 0;
	  while(!done) 
	  {
		
		  done = true;
		  
		  for(int n = 0;n < aSort.length - 1;n++) 
		  {
			  if(aSort[n] > aSort[n+1]) 
			  {
				  
				  done = false;
				  
				  //Store element to move it forward of the element in front that is smaller
				  largerValue = aSort[n];
				  
				  //Switch the two elements
				  aSort[n] = aSort[n+1];
				  aSort[n+1] = largerValue;
			  
			  }
		  }
	  }
	  
  }
  
  /************************
   * Implements Insertion Sort
   *  1.Start with a sorted list of one value
   *  2.Add another value and sort the values, placing in correct location
   *  3.Repeat 2-3 shifting sorted values to the right until it is placed
   *    in the correct position
   * Pre: unsorted array parameter
   * Post: sorted array parameter
   * 
   * @param aSort integer array
   **/
  public static void insertionSort(int[] aSort) 
  {
	  
	  int sortingIndex = 0;
	  
	  for(int n = 1;n < aSort.length;n++) 
	  {
		  
		  sortingIndex = aSort[n];
		  int i = 0;
		  
		  for(i = n - 1; i >= 0 && sortingIndex < aSort[i];i--)
		  {
			  
			  aSort[i+1] = aSort[i];
			  
		  }
		  
		  aSort[i+1] = sortingIndex;
		  
	  }
	  
  }
  
  /************************
   * Implements Selection Sort
   *  1.Scan the list to find the smallest value
   *  2.Swap with first position
   *  3.Repeat 1-2 Scanning and swapping with the next position in the list
   *    Until you are at the end of the list
   * Pre: unsorted array parameter
   * Post: sorted array parameter
   * 
   * @param aSort integer array
   **/
  public static void selectionSort(int[] aSort) 
  {
	  
	  int sortingIndex = 0;
	  int sortingValue = 0;
	  for(int n = 0; n < aSort.length; n++)
	  {
		  
		  sortingIndex = n;
		  
		  for(int i = n; i < aSort.length; i++)
		  {
			  
			  if(aSort[sortingIndex] > aSort[i])
			  {
				  sortingIndex = i;
			  }
			  
		  }
		  
		  sortingValue = aSort[sortingIndex];
		  aSort[sortingIndex] = aSort[n];
		  aSort[n] = sortingValue;
	
	  }
	  
  }
  
  /************************
   * Implements Merge Sort recursively
   *  1.Divide the list in half
   *  2.Sort each half (recursively)
   *  3.Merge the two sorted lists
   *  Note: Use indexes into the array to mark two sublists
   *        and a temporary array when merging
   * Pre: unsorted array parameter
   * Post: sorted array parameter
   * 
   * @param aSort integer array
   **/
  public static void mergeSort(int[] aSort)
  {
    
	//Sort the entire list using a recursive merge sort method
    doMergeSort(aSort, 0, aSort.length-1);
    
  }
  
  private static void doMergeSort(int[] numbers, int start, int end) 
  {
	  
	  if(start < end)
	  {
		  
		  int mid = (start + end)/2;
		  doMergeSort(numbers,start,mid);
		  doMergeSort(numbers,mid + 1,end);
		  merge(numbers,start,mid,end);
		  
	  }
	  
  }

  private static void merge(int[] numbers, int start, int mid, int end)
  {
	
	  int[] tmp = new int[end - start + 1];
	  int index1 = start;
	  int index2 = mid + 1;
	  int indexTmp = 0;
	  
	  while(index1 <= mid && index2 <= end)
	  {
		  
		  if(numbers[index1] < numbers[index2])
		  {
			  
			  tmp[indexTmp] = numbers[index1];
			  index1++;
			  
		  }
		  else
		  {
			  
			  tmp[indexTmp] = numbers[index2];
			  index2++;
			  
		  }
		  
		  indexTmp++;
		  
	  }
	  
	  while(index1 <= mid)
	  {
		  tmp[indexTmp] = numbers[index1];
		  index1++;
		  indexTmp++;
	  }
	  while(index2 <= end)
	  {
			  
		  tmp[indexTmp] = numbers[index2];
		  index2++;
		  indexTmp++;
			  
	  }
	  
	  for(indexTmp = 0;indexTmp < tmp.length;indexTmp++)
	  {
		  
		  numbers[start + indexTmp] = tmp[indexTmp];
		  
	  }
	  
  }

/************************
   * Implements Quick Sort recursively
   *  1.Divide into two sublists, < and > a pivot value
   *  2.Recursively sort each sublist
   *  Use the first element in the list as the pivot
   *  Note: Use indexes into the array to mark two sublists
   * Pre: unsorted array parameter
   * Post: sorted array parameter
   * 
   * @param aSort integer array
   **/
  public static void quickSort(int[] aSort)
  {
	  
    //Sort the entire list using the recursive merge sort method
    doQuickSort(aSort, 0, aSort.length-1);
    
  }
 
  private static void doQuickSort(int[] numbers, int start, int end) 
  {
	  
	  if(start < end)
	  {
		  
		  int mid = partition(numbers,start,end);
		  doQuickSort(numbers,start,mid);
		  doQuickSort(numbers,mid + 1,end);
		  
	  }
	  
  }

  private static int partition(int[] numbers, int start, int end) 
  {
	  
	  int pivotIndex = (start+end)/2;
	  int pivot = numbers[pivotIndex];
	  int i = start - 1;
	  int j = end + 1;
	  
	  while(true)
	  {
		  
		  i = i + 1;
		  while(numbers[i] < pivot)
		  {
			  i = i + 1;
		  }
		  
		  j = j - 1;
		  while(numbers[j] > pivot)
		  {
			  j = j - 1;
		  }
		  
		  if(i < j)
		  {
			  
			  int tmp = numbers[i];
			  numbers[i] = numbers[j];
			  numbers[j] = tmp;
			  
		  }
		  
		  else
		  {
			  return j;
		  }
		  
	  }
	  
  }
  
}
