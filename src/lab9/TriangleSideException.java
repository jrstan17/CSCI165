package lab9;

@SuppressWarnings("serial")
public class TriangleSideException extends Exception {

    private double a;
    private double b;
    private double c;

    public TriangleSideException(double a, double b, double c) {
	super("TriangleSideException");
	this.a = a;
	this.b = b;
	this.c = c;
    }

    public TriangleSideException() {
	super("TriangleSideException");
    }

    public TriangleSideException(String message) {
	super(message);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

}
