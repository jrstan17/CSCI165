package lab9;

import java.text.DecimalFormat;

public class Cylinder extends Circle {

    protected double height = 0;

    public Cylinder() {
	drawChar = Properties.CYLINDER_CHAR;
    }
    
    public Cylinder(double radius, double height){
	super.setRadius(radius);
	this.height = height;
    }

    public Cylinder(Cylinder originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Cylinder object.");
	    System.exit(0);
	}
	// else
	height = originalObject.height;
	drawChar = Properties.CYLINDER_CHAR;
    }

    public String toString() {
	DecimalFormat df = new DecimalFormat("#.##");
	StringBuilder sb = new StringBuilder();
	
	sb.append(super.toString());
	sb.append("Height: ");
	sb.append(df.format(height));
	sb.append("\n");
	sb.append("Area: ");
	sb.append(df.format(getArea()));
	sb.append(" / Volume: ");
	sb.append(df.format(getVolume()));
	sb.append("\n");

	return sb.toString();
    }

    public boolean equals(Object other)
    {
      if ( other == null ) {
 	     return false;
       } // end of if ()
       else if ( this.getClass() != other.getClass() ) {
 	     return false;
       } // end of if ()
       else {
 	     Cylinder cylinder = (Cylinder)other;
 	    return ((super.equals(cylinder)) && (this.height == cylinder.height));
       } // end of else
    }

    public Cylinder clone() {
	return new Cylinder(this);
    }

    @Override
    public double getArea() {
	return (2 * Math.PI * radius * height)
		+ (2 * Math.PI * radius * radius);
    }
    
    public double getVolume() {
	return Math.PI * radius * radius * height;
    }

    @Override
    public void draw() {
	System.out.print(drawChar);
    }

    public double getHeight() {
	return height;
    }

    public void setHeight(double height) {
	this.height = height;
    }
}
