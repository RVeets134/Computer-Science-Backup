
public class wonjae extends animal{

	private String name;
	
	public wonjae(String name) {
		
		super(name);
		this.name = name;
		
	}

	@Override
	public void action() {

		System.out.println("the wonjae is slithering.");
		
	}

}
