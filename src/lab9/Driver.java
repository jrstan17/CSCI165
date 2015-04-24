package lab9;

import java.awt.Point;

public class Driver {

    static Grid grid = new Grid();

    public static void main(String[] args) {
	Triangle t1 = new Triangle(3, 4, 8);
	t1.move(grid, new Point(2, 2));

	Square s1 = new Square(3, 4);
	s1.move(grid, new Point(1, 1));

	Circle c1 = new Circle(4);
	c1.move(grid, new Point(2, 3));

	Rectangle r1 = new Rectangle(2, 3);
	r1.move(grid, new Point(4, 4));
	
	Cylinder y1 = new Cylinder(2.5,4);
	y1.move(grid, new Point(2, 5));
	
	Circle c2 = new Circle(4);
	c2.move(grid, new Point(5, 4));
	
	Sphere p2 = new Sphere(5);
	p2.move(grid, new Point(5, 2));

	grid.draw();
	grid.printStatus();
	
	System.out.println("Circles at [2, 3] and [5, 4] are equal.");
	System.out.println("");
	
	t1.move(grid, new Point(3, 3));
	s1.move(grid, new Point(0, 1));
	c1.move(grid, new Point(4, 3));
	r1.move(grid, new Point(4, 2));
	y1.move(grid, new Point(1, 5));
	c2.move(grid, new Point(5, 3));
	p2.move(grid, new Point(2, 2));
	
	grid.draw();
	grid.printStatus();

    }
}
