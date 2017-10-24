
public class Node
{
	
	private String name;
	private Node next;		
	
	public Node(String name, Node next) 
	{
		this.name = name;
		this.next = next;
	}

	//Returns node as string
	public String getData()
	{
		return name;
	}

	//Can change string value of node
	public void setData(String name)
	{
		this.name = name;
	}

	//Returns the next node in the linked list
	public Node getNext()
	{
		return next;
	}

	//Allows user to set the next node in the linked list
	public void setNext(Node next)
	{
		this.next = next;
	}

	//Prints the data of the node
	public String toString()
	{
		return name;
	}

}