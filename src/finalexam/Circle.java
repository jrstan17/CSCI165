package finalexam;

public abstract class Circle {
    private double radius = 0;

    public double getRadius() {
	return radius;
    }

    public void setRadius(double radius)
	    throws Shape3DNegativePropertyException {
	if (radius < 0) {
	    throw new Shape3DNegativePropertyException(radius);
	} else {
	    this.radius = radius;
	}
    }
}
