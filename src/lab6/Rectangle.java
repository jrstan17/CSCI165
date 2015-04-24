package lab6;
public class Rectangle {
    private static final char DRAW_CHAR = '*';
    private static final char DRAW_SPACE = ' ';

    private static int instanceCount;
    private Point location;
    private int height;
    private int width;

    public Rectangle() {
	location = new Point(0, 2);
	setHeight(2);
	setWidth(4);
	instanceCount++;
    }

    public Rectangle(int x, int y, int h, int w) {
	location = new Point(x, y);
	setHeight(h);
	setWidth(w);
	instanceCount++;
    }

    public Rectangle(Point p, int h, int w) {
	location = new Point(p);
	setHeight(h);
	setWidth(w);
	instanceCount++;
    }

    // copy constructor
    public Rectangle(Rectangle r) {
	if (r != null) {
	    location = r.location;
	    height = r.height;
	    width = r.width;
	    instanceCount++;
	}
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getClass().getName());
	builder.append(" \n    point: ");
	builder.append(location);
	builder.append("\n    height: ");
	builder.append(height);
	builder.append("\n    width: ");
	builder.append(width);
	builder.append(" \n");
	return builder.toString();
    }

    public boolean equals(Rectangle r) {
	if (r == null)
	    return false;
	else
	    return (height == r.height && width == r.width);
    }

    public boolean contains(Point p) {
	return (p == location);
    }

    public void relocate(Point p) {
	setLocation(p);
    }

    public void resize(int h, int w) {
	setHeight(h);
	setWidth(w);
    }

    public int area() {
	return height * width;
    }

    public void draw() {
	String middleRow = drawMiddleRow();

	for (int i = 1; i <= height; i++) {
	    if (i == 1 || i == height) {
		drawLine();
	    } else {
		System.out.println(middleRow);
	    }
	}
    }

    private void drawLine() {
	for (int j = 1; j <= width; j++) {
	    System.out.print(DRAW_CHAR);
	}
	System.out.println("");
    }

    private String drawMiddleRow() {
	String build = Character.toString(DRAW_CHAR);

	for (int i = 1; i <= width - 2; i++) {
	    build += Character.toString(DRAW_SPACE);
	}

	build += Character.toString(DRAW_CHAR);

	return build;
    }

    public static int getInstanceCount() {
	return instanceCount;
    }

    public Point getLocation() {
	return new Point(location);
    }

    public void setLocation(Point point) {
	this.location = new Point(point);
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	if (height < 0) {
	    throw new IllegalArgumentException(
		    "Height cannot be less than zero.");
	} else
	    this.height = height;
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	if (width < 0) {
	    throw new IllegalArgumentException(
		    "Width cannot be less than zero.");
	} else
	    this.width = width;
    }

}
