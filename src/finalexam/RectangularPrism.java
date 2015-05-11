package finalexam;

import java.text.DecimalFormat;

public class RectangularPrism implements Shape3D {

    private double length = 0;
    private double width = 0;
    private double height = 0;

    public RectangularPrism() {

    }

    public RectangularPrism(double length, double width, double height)
	    throws Shape3DNegativePropertyException {
	setLength(length);
	setWidth(width);
	setHeight(height);
    }

    public boolean equals(final Object other) {
	if (other == null) {
	    return false;
	} // end of if ()
	else if (this.getClass() != other.getClass()) {
	    return false;
	} // end of if ()
	else {
	    RectangularPrism rectangularPrism = (RectangularPrism) other;
	    return (this.length == rectangularPrism.length
		    && this.width == rectangularPrism.width && this.height == rectangularPrism.height);
	} // end of else
    }

    public String toString() {
	DecimalFormat df = new DecimalFormat("0.00");
	StringBuilder sb = new StringBuilder();

	sb.append(getClass().getName());
	sb.append(":");
	sb.append("\n");
	sb.append("Length: ");
	sb.append(df.format(length));
	sb.append(" / Width: ");
	sb.append(df.format(width));
	sb.append(" / Height: ");
	sb.append(df.format(height));

	return sb.toString();
    }

    @Override
    public double area() {
	return 2 * (length * width + height * length + height * width);
    }

    @Override
    public double volume() {
	return length * width * height;
    }

    public double getLength() {
	return length;
    }

    public void setLength(double length)
	    throws Shape3DNegativePropertyException {

	if (length < 0) {
	    throw new Shape3DNegativePropertyException(length);
	} else {
	    this.length = length;
	}
    }

    public double getWidth() {
	return width;
    }

    public void setWidth(double width) throws Shape3DNegativePropertyException {

	if (width < 0) {
	    throw new Shape3DNegativePropertyException(width);
	} else {
	    this.width = width;
	}

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
