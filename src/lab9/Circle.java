package lab9;

import java.text.DecimalFormat;

public class Circle extends Shape {

    protected double radius = 0;

    public Circle() {
	drawChar = Properties.CIRCLE_CHAR;
    }

    public Circle(Circle originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Circle object.");
	    System.exit(0);
	}
	// else
	radius = originalObject.radius;
	drawChar = Properties.CIRCLE_CHAR;
    }

    public Circle(double radius) {
	this.radius = radius;
    }

    public String toString() {
	DecimalFormat df = new DecimalFormat("#.##");
	StringBuilder sb = new StringBuilder();

	sb.append(super.toString());
	sb.append("Radius: ");
	sb.append(df.format(radius));
	sb.append("\n");

	return sb.toString();
    }

    public boolean equals(Object other) {
	if (other == null) {
	    return false;
	} // end of if ()
	else if (this.getClass() != other.getClass()) {
	    return false;
	} // end of if ()
	else {
	    Circle circle = (Circle) other;
	    return ((super.equals(circle)) && (this.radius == circle.radius));
	} // end of else
    }

    public Circle clone() {
	return new Circle(this);
    }

    @Override
    public double getArea() {
	return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
	System.out.print(drawChar);
    }

    @Override
    public double getPerimeter() {
	return 2 * Math.PI * radius;
    }

    public double getRadius() {
	return radius;
    }

    public void setRadius(double radius) {
	this.radius = radius;
    }
}
