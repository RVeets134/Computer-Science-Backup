
public class Client {

	public static void main(String[] args) 
	{
		
		StopWatch1 timer = new StopWatch1();
		
		int NUMBER_OF_TESTS = 6;
		
		//--------------------------------------------Part 1--------------------------------------------
		
		System.out.println("Part 1 Results:");
		System.out.println();
		int[] searchList = createList(20,-20,20);
		int[] sortedList = testSorts(searchList);
		testSearch(NUMBER_OF_TESTS,sortedList);
		
		//------------------------------------------Part 2--------------------------------------------
		
		System.out.println("Part 2 Results:");
		System.out.println();
		int[] oneK = createList(1000,1,1000);
		double[] oneKStats = new double[5];
		oneKStats[0] = bubbleSortTime(oneK,timer);
		oneKStats[1] = insertionSortTime(oneK,timer);
		oneKStats[2] = selectionSortTime(oneK,timer);
		oneKStats[3] = mergeSortTime(oneK,timer);
		oneKStats[4] = quickSortTime(oneK,timer);
		
		int[] fiveK = createList(5000,1,5000);
		double[] fiveKStats = new double[5];
		fiveKStats[0] = bubbleSortTime(fiveK,timer);
		fiveKStats[1] = insertionSortTime(fiveK,timer);
		fiveKStats[2] = selectionSortTime(fiveK,timer);
		fiveKStats[3] = mergeSortTime(fiveK,timer);
		fiveKStats[4] = quickSortTime(fiveK,timer);
		
		int[] tenK = createList(10000,1,10000);
		double[] tenKStats = new double[5];
		tenKStats[0] = bubbleSortTime(tenK,timer);
		tenKStats[1] = insertionSortTime(tenK,timer);
		tenKStats[2] = selectionSortTime(tenK,timer);
		tenKStats[3] = mergeSortTime(tenK,timer);
		tenKStats[4] = quickSortTime(tenK,timer);
		
		int[] fiftyK = createList(50000,1,50000);
		double[] fiftyKStats = new double[5];
		fiftyKStats[0] = bubbleSortTime(fiftyK,timer);
		fiftyKStats[1] = insertionSortTime(fiftyK,timer);
		fiftyKStats[2] = selectionSortTime(fiftyK,timer);
		fiftyKStats[3] = mergeSortTime(fiftyK,timer);
		fiftyKStats[4] = quickSortTime(fiftyK,timer);
		
		int[] oneHundredK = createList(100000,1,100000);
		double[] oneHundredKStats = new double[4];
		oneHundredKStats[0] = insertionSortTime(oneHundredK,timer);
		oneHundredKStats[1] = selectionSortTime(oneHundredK,timer);
		oneHundredKStats[2] = mergeSortTime(oneHundredK,timer);
		oneHundredKStats[3] = quickSortTime(oneHundredK,timer);
		
		int[] fiveHundredK = createList(500000,1,500000);
		double[] fiveHundredKStats = new double[4];
		fiveHundredKStats[0] = insertionSortTime(fiveHundredK,timer);
		fiveHundredKStats[1] = selectionSortTime(fiveHundredK,timer);
		fiveHundredKStats[2] = mergeSortTime(fiveHundredK,timer);
		fiveHundredKStats[3] = quickSortTime(fiveHundredK,timer);
		
		int[] oneM = createList(1000000,1,1000000);
		double[] oneMStats = new double[2];
		oneMStats[0] = mergeSortTime(oneM,timer);
		oneMStats[1] = quickSortTime(oneM,timer);
		
		int[] fiveM = createList(5000000,1,5000000);
		double[] fiveMStats = new double[2];
		fiveMStats[0] = mergeSortTime(fiveM,timer);
		fiveMStats[1] = quickSortTime(fiveM,timer);
		
		printPart2(oneKStats,fiveKStats,tenKStats,fiftyKStats,oneHundredKStats,fiveHundredKStats,oneMStats,fiveMStats);
				
		//----------------------------------------Part 3---------------------------------------------------
		
		System.out.println("Part 3 Results:");
		int[] rand200K = createList(200000,1,200000);
		double[] rand200KStats = new double[4];
		rand200KStats[0] = insertionSortTime(rand200K,timer);
		rand200KStats[1] = selectionSortTime(rand200K,timer);
		rand200KStats[2] = mergeSortTime(rand200K,timer);
		rand200KStats[3] = quickSortTime(rand200K,timer);
		
		int[] sorted200K = createList(200000,1,200000);
		Sort.mergeSort(sorted200K);
		double[] sorted200KStats = new double[4];
		sorted200KStats[0] = insertionSortTime(sorted200K,timer);
		sorted200KStats[1] = selectionSortTime(sorted200K,timer);
		sorted200KStats[2] = mergeSortTime(sorted200K,timer);
		sorted200KStats[3] = quickSortTime(sorted200K,timer);
		
		int[] reverse200K = createList(200000,1,200000);
		Sort.mergeSort(reverse200K);
		reverse200K = reverseList(reverse200K);
		double[] reverse200KStats = new double[4];
		reverse200KStats[0] = insertionSortTime(reverse200K,timer);
		reverse200KStats[1] = selectionSortTime(reverse200K,timer);
		reverse200KStats[2] = mergeSortTime(reverse200K,timer);
		reverse200KStats[3] = quickSortTime(reverse200K,timer);
		
		int[] oneToTwenty200K = createList(200000,1,20);
		double[] oneToTwenty200KStats = new double[4];	
		oneToTwenty200KStats[0] = insertionSortTime(oneToTwenty200K,timer);
		oneToTwenty200KStats[1] = selectionSortTime(oneToTwenty200K,timer);
		oneToTwenty200KStats[2] = mergeSortTime(oneToTwenty200K,timer);
		oneToTwenty200KStats[3] = quickSortTime(oneToTwenty200K,timer);
		
		printPart3(rand200KStats,sorted200KStats,reverse200KStats,oneToTwenty200KStats);
		
		//-------------------------------------Part 4---------------------------------------
		
		System.out.println("Part 4 Results:");
		int[] sortedFiveM = copyList(fiveM);
		Sort.mergeSort(sortedFiveM);
		printPart4(fiveM,sortedFiveM,timer);
		
	}
	
	private static int[] createList(int size,int min,int max)
	{
		
		int[] list = new int[size];
		
		for(int n = 0;n < size;n++)
		{
			
			list[n] = (int) ((Math.random() * max - min + 1) + min);
			
		}
		
		return list;
		
	}
	
	private static int[] copyList(int[] original)
	{
		
		int[] copy = new int[original.length];
		
		for(int n = 0;n < copy.length;n++)
		{
			
			copy[n] = original[n];
			
		}
		
		return copy;
				
	}
	
	private static void printList(int[] list)
	{
		
		for(int n = 0;n < list.length;n++)
		{
			System.out.print(list[n] + "   ");
		}
		
	}
	
	private static double bubbleSortTime(int[] array,StopWatch1 timer)
	{
		
		int[] copy = copyList(array);
		timer.start();
		Sort.bubbleSort(copy);
		timer.stop();
		return timer.getElapsedTime();
		
	}
	
	private static double insertionSortTime(int[] array,StopWatch1 timer)
	{
		
		int[] copy = copyList(array);
		timer.start();
		Sort.insertionSort(copy);
		timer.stop();
		return timer.getElapsedTime();
		
	}
	
	private static double selectionSortTime(int[] array,StopWatch1 timer)
	{
		
		int[] copy = copyList(array);
		timer.start();
		Sort.selectionSort(copy);
		timer.stop();
		return timer.getElapsedTime();
		
	}
	
	private static double mergeSortTime(int[] array,StopWatch1 timer)
	{
		
		int[] copy = copyList(array);
		timer.start();
		Sort.mergeSort(copy);
		timer.stop();
		return timer.getElapsedTime();
		
	}
	
	private static double quickSortTime(int[] array,StopWatch1 timer)
	{
		
		int[] copy = copyList(array);
		timer.start();
		Sort.quickSort(copy);
		timer.stop();
		return timer.getElapsedTime();
		
	}
	
	private static int[] testSorts(int[] array)
	{
		
		int[] copy1 = copyList(array);
		int[] copy2 = copyList(array);
		int[] copy3 = copyList(array);
		int[] copy4 = copyList(array);
		int[] copy5 = copyList(array);
		
		Sort.bubbleSort(copy1);
		Sort.insertionSort(copy2);
		Sort.selectionSort(copy3);
		Sort.mergeSort(copy4);
		Sort.quickSort(copy5);

		//Printing list after sorting with each sort
		System.out.println("Random List of 20 numbers");
		System.out.print("Bubble Sort:      ");
		printList(copy1);
		System.out.println();
		System.out.print("Insertion Sort:   ");
		printList(copy2);
		System.out.println();
		System.out.print("Selection Sort:   ");
		printList(copy3);
		System.out.println();
		System.out.print("Merge Sort:       ");
		printList(copy4);
		System.out.println();	
		System.out.print("Quick Sort:       ");
		printList(copy5);
		System.out.println();
		System.out.println();
		
		return copy1;
		
	}
	
	private static void testSearch(int numberOfTrials,int[] list)
	{
		
		//Searching for random numbers in the list
		System.out.println("Searching the List for random numbers within the range. Gives index of number.");
		System.out.println();
		
		for(int n = 0;n < numberOfTrials;n++)
		{
			
			int random = (int) ((Math.random() * 20 - (-20) + 1) + (-20));
			int linear = Search.linearSearch(list, random);
			int binary = Search.binarySearch(list, random);
			
			if(linear == -1 || binary == -1)
			{
				System.out.println("Searching the List for " + random);
				System.out.println("Linear search: Not Found.");
				System.out.println("Binary search: Not Found.");
				System.out.println();
			}
			else
			{
				System.out.println("Searching the List for " + random);
				System.out.println("Linear search: Found at index " + linear);
				System.out.println("Binary search: Found at index " + binary);
				System.out.println();
			}
		
		}
		
	}
	
	private static void printPart2(double[] oneK,double[] fiveK,double[] tenK,double[] fiftyK,
			double[] oneHundredK,double[] fiveHundredK,double[] oneM,double[] fiveM)
	{
		
		//1K List
		System.out.println("Random List 1K:");
		System.out.println("Bubble Sort:     " + oneK[0] + "ms");
		System.out.println("Insertion Sort:  " + oneK[1] + "ms");
		System.out.println("Selection Sort:  " + oneK[2] + "ms");
		System.out.println("Merge Sort:      " + oneK[3] + "ms");
		System.out.println("Quick Sort:      " + oneK[4] + "ms");
		System.out.println();
		
		//5K List
		System.out.println("Random List 5K:");
		System.out.println("Bubble Sort:     " + fiveK[0] + "ms");
		System.out.println("Insertion Sort:  " + fiveK[1] + "ms");
		System.out.println("Selection Sort:  " + fiveK[2] + "ms");
		System.out.println("Merge Sort:      " + fiveK[3] + "ms");
		System.out.println("Quick Sort:      " + fiveK[4] + "ms");
		System.out.println();
		
		//10K List
		System.out.println("Random List 10K:");
		System.out.println("Bubble Sort:     " + tenK[0] + "ms");
		System.out.println("Insertion Sort:  " + tenK[1] + "ms");
		System.out.println("Selection Sort:  " + tenK[2] + "ms");
		System.out.println("Merge Sort:      " + tenK[3] + "ms");
		System.out.println("Quick Sort:      " + tenK[4] + "ms");
		System.out.println();
		
		//50K List
		System.out.println("Random List 50K:");
		System.out.println("Bubble Sort:     " + fiftyK[0] + "ms");
		System.out.println("Insertion Sort:  " + fiftyK[1] + "ms");
		System.out.println("Selection Sort:  " + fiftyK[2] + "ms");
		System.out.println("Merge Sort:      " + fiftyK[3] + "ms");
		System.out.println("Quick Sort:      " + fiftyK[4] + "ms");
		System.out.println();
		
		//100K List
		System.out.println("Random List 100K:");
		System.out.println("Insertion Sort:  " + oneHundredK[0] + "ms");
		System.out.println("Selection Sort:  " + oneHundredK[1] + "ms");
		System.out.println("Merge Sort:      " + oneHundredK[2] + "ms");
		System.out.println("Quick Sort:      " + oneHundredK[3] + "ms");
		System.out.println();
		
		//500K List
		System.out.println("Random List 500K:");
		System.out.println("Insertion Sort:  " + fiveHundredK[0] + "ms");
		System.out.println("Selection Sort:  " + fiveHundredK[1] + "ms");
		System.out.println("Merge Sort:      " + fiveHundredK[2] + "ms");
		System.out.println("Quick Sort:      " + fiveHundredK[3] + "ms");
		System.out.println();
		
		//1M List
		System.out.println("Random List 1M:");
		System.out.println("Merge Sort:      " + oneM[0] + "ms");
		System.out.println("Quick Sort:      " + oneM[1] + "ms");
		System.out.println();
		
		//5M List
		System.out.println("Random List 5M:");
		System.out.println("Merge Sort:      " + fiveM[0] + "ms");
		System.out.println("Quick Sort:      " + fiveM[1] + "ms");
		System.out.println();
		
	}
	
	private static int[] reverseList(int[] array)
	{
		
		int[] copy = copyList(array);
		int counter = 0;
		for(int n = array.length-1;n > 0;n--)
		{
			
			array[n] = copy[counter];
			counter++;
			
		}
		
		return array;
		
	}
	
	private static void printPart3(double[] random,double[] sorted,double[] reverse,double[] oneToTwenty)
	{
		
		//Random 200K List
		System.out.println("Random 200K List:");
		System.out.println("Insertion Sort:  " + random[0] + "ms");
		System.out.println("Selection Sort:  " + random[1] + "ms");
		System.out.println("Merge Sort:      " + random[2] + "ms");
		System.out.println("Quick Sort:      " + random[3] + "ms");
		System.out.println();
				
		//Sorted 200K List
		System.out.println("Sorted 200K List:");
		System.out.println("Insertion Sort:  " + sorted[0] + "ms");
		System.out.println("Selection Sort:  " + sorted[1] + "ms");
		System.out.println("Merge Sort:      " + sorted[2] + "ms");
		System.out.println("Quick Sort:      " + sorted[3] + "ms");
		System.out.println();
				
		//Reverse Sorted 200K List
		System.out.println("Reverse Sorted 200K List:");
		System.out.println("Insertion Sort:  " + reverse[0] + "ms");
		System.out.println("Selection Sort:  " + reverse[1] + "ms");
		System.out.println("Merge Sort:      " + reverse[2] + "ms");
		System.out.println("Quick Sort:      " + reverse[3] + "ms");
		System.out.println();
				
		//Random 200K List with range 1-20
		System.out.println("Random 200K List with range 1-20:");
		System.out.println("Insertion Sort:  " + oneToTwenty[0] + "ms");
		System.out.println("Selection Sort:  " + oneToTwenty[1] + "ms");
		System.out.println("Merge Sort:      " + oneToTwenty[2] + "ms");
		System.out.println("Quick Sort:      " + oneToTwenty[3] + "ms");
		System.out.println();
		
	}
	
	private static void printPart4(int[] unsorted,int[] sorted,StopWatch1 timer)
	{
		
		double[] stats = new double[15];
		int random = 0;
		double time1 = 0;
		double time2 = 0;
		double time3 = 0;
		
		for(int n = 0;n < 15;n++)
		{
			
			random = (int) ((Math.random() * sorted.length - (1) + 1) + (1));
			
			timer.start();
			stats[n] = Search.linearSearch(unsorted,random);
			timer.stop();
			time1 = timer.getElapsedTime();
			n++;
			
			timer.start();
			stats[n] = Search.linearSearch(sorted,random);
			timer.stop();
			time2 = timer.getElapsedTime();
			n++;
			
			timer.start();
			stats[n] = Search.binarySearch(sorted,random);
			timer.stop();
			time3 = timer.getElapsedTime();
			
			System.out.println("Looking for index of " + random);
			System.out.println("Linear Search through unsorted list: " + stats[n-2]);
			System.out.println("Took " + time1 + " ms to find.");
			System.out.println("Linear Search through sorted list:   " + stats[n-1]);
			System.out.println("Took " + time2 + " ms to find.");
			System.out.println("Binary Search through sorted list:   " + stats[n]);
			System.out.println("Took " + time3 + " ms to find.");
			
		}		
		
	}

}
