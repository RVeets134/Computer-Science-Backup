
public class Node<String> 
{
	
	private String data;
	private Node<String> next;		
	
	public Node(String data, Node<String> next) 
	{
		this.data = data;
		this.next = next;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public Node<String> getNext()
	{
		return next;
	}

	public void setNext(Node<String> next)
	{
		this.next = next;
	}

	public String toString()
	{
		return data;
	}

}