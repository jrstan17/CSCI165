package lab9;

import java.awt.Point;

public abstract class Shape {

    protected String color = "None";
    protected double opacity = 0;
    protected Point origin;
    protected char drawChar = ' ';

    public Shape() {
    }

    public Shape(Shape originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Shape object.");
	    System.exit(0);
	}
	// else
	color = originalObject.color;
	opacity = originalObject.opacity;
	origin = (Point) origin.clone();
	drawChar = originalObject.drawChar;
    }

    public abstract double getArea();

    public abstract void draw();

    public abstract double getPerimeter();

    public void move(Grid grid, Point p) {

	try {
	    grid.getGrid()[(int) p.getX()][(int) p.getY()] = this.clone();
	    grid.getGrid()[(int) p.getX()][(int) p.getY()].setOrigin(new Point(
		    p));
	} catch (CloneNotSupportedException e) {
	    e.printStackTrace();
	}

	if (grid.getGrid()[(int) p.getX()][(int) p.getY()] != null) {
	    this.erase(grid);
	}
	origin = new Point(p);
    }

    public void erase(Grid grid) {
	if (origin != null) {
	    grid.getGrid()[(int) origin.getX()][(int) origin.getY()] = null;
	}
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("Shape: ");
	sb.append(this.getClass().getSimpleName());
	sb.append(" / Color: ");
	sb.append(color);
	sb.append(" / Opacity: ");
	sb.append(opacity);
	sb.append(" / Origin: (");
	sb.append(origin.getX());
	sb.append(", ");
	sb.append(origin.getY());
	sb.append(")");
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
	    Shape shape = (Shape) other;
	    return ((this.color == shape.color) && (this.opacity == shape.opacity) && (this.drawChar == shape.drawChar));
	} // end of else
    }

    public Shape clone() throws CloneNotSupportedException {
	return (Shape) super.clone();
    }

    public char getDrawChar() {
	return drawChar;
    }

    public void setDrawChar(char drawChar) {
	this.drawChar = drawChar;
    }

    public Point getOrigin() {
	return origin;
    }

    public void setOrigin(Point origin) {
	this.origin = origin;
    }

}
