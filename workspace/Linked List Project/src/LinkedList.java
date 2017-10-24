public class LinkedList
{
	
	private Node list;
	private int size = 0;

	public LinkedList()
	{
		list = null;
	}

	/**
	 * Allows user to add a node to the linked list
	 * @param add - String to add as a node to the linked list
	 */
	public void add(String add)
	{

		//If list is empty, then create a new node for the first node
		if(list == null)
		{
			list = new Node(add,null);
		}
	
		Node temp = new Node(add,null);
		Node current = list;

		if(current != null)
		{
			
			//Keeps going through the list until it gets to the last node
			while(current.getNext() != null)
			{
				current = current.getNext();
			}
			
			//Adds the node at the end of the list
			current.setNext(temp);
			
		}		
		
		size ++;
		
	}

	/**
	 * Allows user to delete a certain node from the linked list
	 * @param delete - String to delete from the linked list
	 */
	public void delete(String delete)
	{

		//Checks to see whether the string has been deleted or not
		Boolean deleted = false;

		if(list != null) 
		{

			//Check the first node in the list
			if(list.toString().equals(delete)) 
			{
				//Assign the next node to the first one, deleting the first one in the process
				list = list.getNext();
				size--;
				deleted = true;
			}

			//Set up two adjacent nodes for comparison, starting from the beginning
			Node left = list;
			Node right = list.getNext();

			//Start traversing through the list
			while(right != null)
			{
				
					//Target string is in the next node
					if(right.toString().equals(delete))
					{
						left.setNext(right.getNext());
						size--;
						deleted = true;
					} 
					else 
					{
						left = right;
						right = left.getNext();
					}
			}

			//Lets user know that the word could not be found
			if (!deleted)
			{
				System.out.println("Could not find: " + delete);
			}
		}
	}

	//Returns the number of nodes in the linked list
	public int size()
	{
		return size;
	}

	//Prints the contents of the linked list, each on a separate line
	public String toString()
	{
		
		String str = "";
		Node temp = list;
		
		if(temp == null)
		{
			return str;
		}
		else
		{
			
			//Keep printing each node on a different line until there are no more
			while(temp != null)
			{
				str = str + temp.toString() + "\n";
				temp = temp.getNext();
			}
		}
		return str;
	}

}