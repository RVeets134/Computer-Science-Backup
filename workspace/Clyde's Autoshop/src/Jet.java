
public class Jet extends Airplane{

	private String name;
	
	public Jet(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		
	}
	
	public void move()
	{
		
		System.out.println(name + " is an airplane that is flying using jets.");
		
	}

}