import java.util.function.Consumer;

public abstract class animal implements Consumer {

	private String name;
	
	public animal(String name) {
		
		this.name = name;
		
	}
	
	public abstract void action();

}
