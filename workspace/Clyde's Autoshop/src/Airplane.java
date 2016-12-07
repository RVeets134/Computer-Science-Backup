
public class Airplane extends Air{

	private String name;
	
	public Airplane(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		
	}
	
	public void move()
	{
		
		System.out.println(name + " is an airplane that is flying.");
		
	}

}