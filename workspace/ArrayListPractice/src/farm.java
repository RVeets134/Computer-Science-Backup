import java.util.ArrayList;

public class farm {

	public static void main(String[] args) {

		ArrayList animals = new ArrayList();
		
		animal wonjae = new wonjae("Steve");
		animal cow = new cow("Wonjae");
		
		animals.add(wonjae);
		animals.add(cow);
		
		animals.forEach((animal)animals.action());
		
	}

}
