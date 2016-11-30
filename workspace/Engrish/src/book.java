public abstract class book 
{
	public int pages;
	
	public book (int numberOfPages)
	{
		pages = numberOfPages;
	}
	public String toString()
	{
		String message ="Number of pages: " + pages;
		return message;
	}
	public int getNumberOfPages()
	{
		return pages;
	}
	public int read(int pagesRead) {
		return 0;
	}
}