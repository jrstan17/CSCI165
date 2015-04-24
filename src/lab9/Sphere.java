package lab9;

import java.text.DecimalFormat;

public class Sphere extends Circle {

    public Sphere() {
	drawChar = Properties.SPHERE_CHAR;
    }

    public Sphere(Sphere originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Sphere object.");
	    System.exit(0);
	}
	// else
	radius = originalObject.radius;
	drawChar = Properties.SPHERE_CHAR;
    }

    public Sphere(double radius) {
	super.setRadius(radius);
    }

    public String toString() {
	DecimalFormat df = new DecimalFormat("#.##");
	StringBuilder sb = new StringBuilder();
	
	sb.append(super.toString());
	sb.append("Area: ");
	sb.append(df.format(getArea()));
	sb.append(" / Volume: ");
	sb.append(df.format(getVolume()));
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
	    Sphere sphere = (Sphere) other;
	    return (super.equals(sphere));
	} // end of else
    }

    public Sphere clone() {
	return new Sphere(this);
    }

    @Override
    public double getArea() {
	return 4 * Math.PI * radius * radius;
    }

    public double getVolume() {
	return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public void draw() {
	System.out.print(drawChar);
    }
}
