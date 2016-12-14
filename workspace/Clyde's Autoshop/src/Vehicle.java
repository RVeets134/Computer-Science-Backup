
public abstract class Vehicle{

	//Required Instance data for each vehicle
	private String name;
	private int passengerLimit;
	private String vehicleType;
	private String vehicleInfo;
	
	//Store values in instance variables and create String for toString()
	public Vehicle(String name,int passengerLimit,String vehicleType) {

		this.name = name;
		this.passengerLimit = passengerLimit;
		this.vehicleType = vehicleType;
		createString();
		
	}
	
	public abstract void move();
	
	/**
	 * Allows user to access name of vehicle
	 * @return - Returns name of the vehicle
	 */
	public String getName()
	{
		
		return name;
		
	}

	/**
	 * Allows user to access the holding capacity of the vehicle
	 * @return - Returns the passenger limit allowed on the vehicle
	 */
	public int getPassengerLimit()
	{
		
		return passengerLimit;
		
	}
	
	/**
	 * Allows user to change the name of the vehicle
	 * @param name - Name that user wants to give the vehicle
	 */
	public void setName(String name)
	{
		
		this.name = name;
		
	}
	
	/**
	 * Allows user to change the holding capacity of the vehicle
	 * @param name - Number of people that user wants the vehicle to be able to hold
	 */
	public void setPassengerLimit(int passengerLimit)
	{
		
		this.passengerLimit = passengerLimit;
		
	}
	
	/**
	 * Gives the user the type of vehicle that the vehicle is named as
	 * @return - Type of vehicle the vehicle was labeled as
	 */
	public String getVehicleType()
	{
		
		return vehicleType;
		
	}
	
	/*
	 * Compiles information for vehicle that can be used for toString()
	 */
	private void createString()
	{
		
		vehicleInfo = "Name of Vehicle: " + name + "\n" + "Type of Vehicle: " + vehicleType + "\n" + "Maximum holding capacity: " + passengerLimit;
		
	}
	
	/**
	 * Vehicle information outputted by system when vehicle object is printed
	 */
	public String toString()
	{
		
		String info;
		info = vehicleInfo;
		return info;
		
	}
	
	/**
	 * This method compares the holding capacity of two vehicles and returns an
	 * int depending on the result.
	 * @param v - Vehicle being compared to by the vehicle making use of this method
	 * @return - Will return -1 if object of object method has less carrying capacity than the other vehicle
	 * Returns 1 if object of object method has more carrying capacity than the other vehicle
	 * Returns 0 if object of object method has the same carrying capacity as the other vehicle
	 */
	public int compareTo(Vehicle v)
	{
		
		if(passengerLimit < v.passengerLimit)
		{
			return -1;
		}
		else if(passengerLimit > v.passengerLimit)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}

}
