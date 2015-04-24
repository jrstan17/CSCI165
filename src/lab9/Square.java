package lab9;

public class Square extends Rectangle {
    public Square() {
	drawChar = Properties.SQUARE_CHAR;
    }

    public Square(Square originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Square object.");
	    System.exit(0);
	}

	length = originalObject.getLength();
	width = originalObject.getWidth();
	drawChar = Properties.SQUARE_CHAR;
    }

    public Square(double length, double width) {

	try {
	    this.length = length;
	    this.width = width;

	    if (length != width) {
		throw new SquareDimensionException(length, width);
	    }
	} catch (SquareDimensionException e) {
	    System.out.println(e.getMessage());
	    System.out.println("Making width equal length (" + length + ").");
	    this.width = length;
	}
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append(super.toString());

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
	    Square square = (Square) other;
	    return (super.equals(square));
	} // end of else
    }

    public Square clone() {
	return new Square(this);
    }

    @Override
    public double getArea() {
	return length * length;
    }

    @Override
    public void draw() {
	System.out.print(drawChar);
    }

    @Override
    public double getPerimeter() {
	return length * 4;
    }
}
