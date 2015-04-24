package lab6;
public class Circle {
    private Point center;
    private int radius;
    static int instanceCount;

    public Circle() {
	center = new Point(0, 1);
	setRadius(1);
	instanceCount++;
    }

    public Circle(int x, int y, int r) {
	Point p = new Point(x, y);

	setCenter(p);
	setRadius(r);
	instanceCount++;
    }

    public Circle(Point p, int r) {
	setCenter(p);
	setRadius(r);
	instanceCount++;
    }
    
    // copy constructor
    public Circle(Circle c) {
	if (c != null) {
	    center = c.getCenter();
	    radius = c.getRadius();
	    instanceCount++;
	}
    }

    public double area() {
	return Math.PI * radius * radius;
    }

    public void resize(int radius) {
	setRadius(radius);
    }

    public void relocate(Point p) {
	setCenter(p);
    }

    public boolean contains(Point p) {
	return (p == center);
    }

    public boolean equals(Circle c) {
	if (c == null) {
	    return false;
	} else
	    return (center == c.center && radius == c.radius);
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getClass().getName());
	builder.append(" \n    center: ");
	builder.append(center);
	builder.append("\n    radius: ");
	builder.append(radius);
	builder.append(" \n");
	return builder.toString();
    }

    public Point getCenter() {
	return new Point(center);
    }

    public void setCenter(Point center) {
	this.center = new Point(center);
    }

    public int getRadius() {
	return radius;
    }

    public void setRadius(int radius) {
	this.radius = radius;
    }

    public static int getInstanceCount() {
	return instanceCount;
    }
}
