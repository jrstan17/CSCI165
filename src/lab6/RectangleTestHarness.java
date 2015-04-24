package lab6;
public class RectangleTestHarness{

	public static void main(String args[]){
		
		//create some Points
		@SuppressWarnings("unused")
		Point p1 = new Point();
		Point p2 = new Point(1, 2);
		Point p3 = new Point(p2);
		
		//Test Point stuff
		System.out.println("Why am I testing my own code here . . . ? <scratches head>");
		if(p3.equals(p2)) System.out.println("using equals(): Points are equal: TEST PASSES");
		else System.out.println("using equals(): Points are NOT equal: TEST FAILS");
		if(p2 == p3) System.out.println("using == : Points are equal : TEST FAILS");
		else System.out.println("using == : Points are NOT equal : TEST PASSES");

		System.out.println("\n");
		
		//Create some Rectangles
		Rectangle r1 = new Rectangle();
		System.out.println("Rectangle no-arg constructor yields: " + r1);
		r1.draw();
		Rectangle r2 = new Rectangle(p2, 10, 20);
		System.out.println("Rectangle overloaded constructor with Point yields: " + r2);
		r2.draw();
		Rectangle r3 = new Rectangle(1, 2, 3, 4);
		System.out.println("Rectangle overloaded constructor with ints yields: " + r3);
		r3.draw();

		System.out.println("\n");
		
		System.out.println("Attempting to clone R3 to R4");
		Rectangle r4 = new Rectangle(r3);

		System.out.println("\n");
		
		System.out.println("Testing R3 and R4 Equality using equals and ==");
		if(r3.equals(r4)) System.out.println("using equals(): Rectangles are equal: TEST PASSES");
		else System.out.println("using equals(): Rectangles are NOT equal: TEST FAILS");
		if(r3 == r4) System.out.println("using == : Rectangles are equal : TEST FAILS");
		else System.out.println("using == : Rectangles are NOT equal : TEST PASSES");

		System.out.println("\n");

		System.out.println("How many Rectangles do we have? " + Rectangle.getInstanceCount());
		Rectangle r5 = new Rectangle();
		System.out.println("How about now? " + Rectangle.getInstanceCount());
		
		System.out.println("\n");

		System.out.println("Let's relocate a Rectangle with a new Point and see if we break stuff");
		Point newLocation = new Point(20, 30);
		r5.relocate(newLocation);
		System.out.println("Let's test to see if the Point was cloned");
		Point temp = r5.getLocation();
		if(temp == newLocation)System.out.println("Point was NOT cloned. Test FAILS");
		else System.out.println("Point was cloned. Test PASSES");
		System.out.println("Draw the Rectangle");
		r5.draw();

		
	
	}
}