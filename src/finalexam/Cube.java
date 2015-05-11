package finalexam;

public class Cube extends RectangularPrism {

    public Cube(double side) throws Shape3DNegativePropertyException {
	super.setHeight(side);
	super.setLength(side);
	super.setWidth(side);
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append(super.toString());

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
	    Cube cube = (Cube) other;
	    return (this.getLength() == cube.getLength()
		    && this.getWidth() == cube.getWidth() && this.getHeight() == cube
		    .getHeight());
	} // end of else
    }

    public void setHeight(double height)
	    throws Shape3DNegativePropertyException {
	try {
	    if (height >= 0) {
		if (height != getLength()) {
		    setLength(height);
		}

		if (height != getWidth()) {
		    setWidth(height);
		}
	    } else {
		throw new Shape3DNegativePropertyException(height);
	    }
	} catch (Shape3DNegativePropertyException e) {
	    e.printStackTrace();
	}
    }

    public void setWidth(double width) throws Shape3DNegativePropertyException {
	try {
	    if (width >= 0) {
		if (width != getLength()) {
		    setLength(width);
		}

		if (width != getHeight()) {
		    setWidth(width);
		}
	    } else {
		throw new Shape3DNegativePropertyException(width);
	    }
	} catch (Shape3DNegativePropertyException e) {
	    e.printStackTrace();
	}
    }

    public void setLength(double length)
	    throws Shape3DNegativePropertyException {
	try {
	    if (length >= 0) {
		if (length != getWidth()) {
		    setLength(length);
		}

		if (length != getHeight()) {
		    setWidth(length);
		}
	    } else {
		throw new Shape3DNegativePropertyException(length);
	    }
	} catch (Shape3DNegativePropertyException e) {
	    e.printStackTrace();
	}
    }
}
