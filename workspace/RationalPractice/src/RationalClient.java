
public class RationalClient {

	public static void main(String[] args) {

		Rational r1 = new Rational(1,2);
		Rational r2 = new Rational(1,4);
		
		Rational r3 = null;
		
		//Object Methods
		
		r3 = r1.add(r2);
		System.out.println(r3);
		
		r3 = r1.subtract(r2);
		System.out.println(r3);
		
		r3 = r1.multiply(r2);
		System.out.println(r3);
		
		r3 = r1.divide(r2);
		System.out.println(r3);
		
		//Class static methods
		
		r3 = Rational.add(r1,r2);
		System.out.println(r3);
		
		r3 = Rational.subtract(r1,r2);
		System.out.println(r3);
		
		r3 = Rational.multiply(r1,r2);
		System.out.println(r3);
		
		r3 = Rational.divide(r1,r2);
		System.out.println(r3);
		
	}

}
