/*
 * Rakesh Veetekat
 * Linked List Project
 * 5/25/17
 * This program creates and utilizes the linked list and node classes to store data within dynamic lists.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Client 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		
		//Setup the file
		File file = new File("lldata.txt");
		Scanner in = new Scanner(file);
		
		LinkedList list = new LinkedList();
		
		//Fill list with all the words from the file
		while(in.hasNext())
		{
			list.add(in.next());
		}
		
		//Tests toString method
		System.out.println("Print list to test toString:");
		System.out.println(list);

		//Add words to the list
		list.add("Aardvark");
	    list.add("Zapotec");
	    list.add("Miami");
	    
	    System.out.println("List with added words:");
	    System.out.println(list);
	    
	    //Print out the size of the list at the end
	    System.out.println("Size of list after adding words:");
	    System.out.println(list.size());
	    
	    /* Deletion part of code does not seem to work
	    //Delete words from the list
	    
	    list.delete("Jackson");
		list.delete("Arthur");
		list.delete("Roosevelt");
		list.delete("Aardvark");
		list.delete("Eisenhower");
		list.delete("Zapotec");
	    
	    //Print the list after words are deleted
	    System.out.println("List with deleted words:");
	    System.out.println(list);
	    */
		
	}

}