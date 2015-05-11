package finalexam;

import java.text.DecimalFormat;

public class Cylinder extends Circle implements Shape3D {

    private double height = 0;

    public Cylinder() {

    }

    public Cylinder(double radius, double height)
	    throws Shape3DNegativePropertyException {
	setRadius(radius);
	setHeight(height);
    }

    public final String toString() {
	DecimalFormat df = new DecimalFormat("0.00");
	StringBuilder sb = new StringBuilder();

	sb.append(getClass().getName());
	sb.append(":");
	sb.append("\n");
	sb.append("Radius: ");
	sb.append(df.format(getRadius()));
	sb.append(" / Height: ");
	sb.append(df.format(height));

	return sb.toString();
    }

    public boolean equals(final Object other) {
	if (other == null) {
	    return false;
	} // end of if ()
	else if (this.getClass() != other.getClass()) {
	    return false;
	} // end of if ()
	else {
	    Cylinder cylinder = (Cylinder) other;
	    return (this.getRadius() == cylinder.getRadius() && this
		    .getHeight() == cylinder.getHeight());
	} // end of else
    }

    @Override
    public double area() {
	double radius = getRadius();
	return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
	double radius = getRadius();
	return Math.PI * radius * radius * height;
    }

    public double getHeight() {
	return height;
    }

    public void setHeight(double height)
	    throws Shape3DNegativePropertyException {
	if (height < 0) {
	    throw new Shape3DNegativePropertyException(height);
	} else {
	    this.height = height;
	}
    }

}
