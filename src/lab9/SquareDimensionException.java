package lab9;

@SuppressWarnings("serial")
public class SquareDimensionException extends Exception {

    private double length;
    private double width;

    public SquareDimensionException(double length, double width) {
	super("SquareDimensionException");
	this.length = length;
	this.width = width;
    }

    public SquareDimensionException() {
	super("SquareDimensionException");
    }

    public SquareDimensionException(String message) {
	super(message);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

}
