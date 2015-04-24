package lab9;

import java.text.DecimalFormat;

public class Triangle extends Shape {

    protected double sideA = 0;
    protected double sideB = 0;
    protected double sideC = 0;

    public Triangle() {
	drawChar = Properties.TRIANGLE_CHAR;
    }

    public Triangle(double a, double b, double c) {
	try {
	    sideA = a;
	    sideB = b;
	    sideC = c;
	    if (!isTriangle(a, b, c)){
		throw new TriangleSideException();
	    }
	} catch (TriangleSideException e) {
	    System.out.println(e.getMessage());
	    System.out.println("Triangle changed to a 3-4-5 triangle.");
	    sideA = 3;
	    sideB = 4;
	    sideC = 5;
	}
	drawChar = Properties.TRIANGLE_CHAR;
    }

    public Triangle(Triangle originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Triangle object.");
	    System.exit(0);
	}
	// else
	sideA = originalObject.sideA;
	sideB = originalObject.sideB;
	sideC = originalObject.sideC;
	drawChar = Properties.TRIANGLE_CHAR;
    }

    public String toString() {
	DecimalFormat df = new DecimalFormat("#.##");
	StringBuilder sb = new StringBuilder();

	sb.append(super.toString());
	sb.append("A: ");
	sb.append(df.format(sideA));
	sb.append(" / B: ");
	sb.append(df.format(sideB));
	sb.append(" / C: ");
	sb.append(df.format(sideC));
	sb.append("\n");
	sb.append("Area: ");
	sb.append(df.format(getArea()));
	sb.append(" / Permimeter: ");
	sb.append(df.format(getPerimeter()));
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
	    Triangle triangle = (Triangle) other;
	    return ((super.equals(triangle)) && (this.sideA == triangle.sideA) && (this.sideB == triangle.sideB) && (this.sideC == triangle.sideC));
	} // end of else
    }

    public Triangle clone() {
	return new Triangle(this);
    }

    @Override
    public void draw() {
	System.out.print(drawChar);
    }

    private boolean isTriangle(double a, double b, double c) {
	return ((a < b + c) && (b < a + c) && (c < a + b));
    }

    @Override
    public double getArea() {
	double p = findP();
	return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    private double findP() {
	return (sideA + sideB + sideC) / 2;
    }

    @Override
    public double getPerimeter() {
	return sideA + sideB + sideC;
    }

}
