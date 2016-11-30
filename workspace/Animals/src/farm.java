
public class farm {

	public static void main(String[] args) {

		animal wonjae = new wonjae("Steve");
		animal cow = new cow("Wonjae");
		
		animal[] animals = {wonjae,cow};
		
		for(animal scrub:animals)
		{
			
			scrub.action();
			
		}
		
	}

}
