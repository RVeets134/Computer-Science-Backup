
public class Store {

	public static void main(String[] args) {
		
		Vehicle dhruv = new SUV("Dhruv",17,"SUV");
		Vehicle thomas = new Jet("Thomas",420,"Jet");
		Vehicle[] myVehicles = {dhruv,thomas};
		for(int n = 0;n < myVehicles.length;n++)
		{

			System.out.println(myVehicles[n]);
			
		}
		
	}

}
