
public class cow extends animal{

	private String name;
	
	public cow(String name) {
		
		super(name);
		this.name = name;
		
	}

	@Override
	public void action() {

		System.out.println("The cow is mooing");
		
	}

}
