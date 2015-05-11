package finalexam;

@SuppressWarnings("serial")
public class Shape3DNegativePropertyException extends Exception {

    private double value = 0;

    public Shape3DNegativePropertyException() {
	super("Shape3DNegativePropertyException");
    }

    public Shape3DNegativePropertyException(String message) {
	super(message);
    }

    public Shape3DNegativePropertyException(double value) {
	super("Shape3DNegativePropertyException");
	this.setValue(value);
    }

    public void setValue(double value) {
	this.value = value;
    }

    public double getValue() {
	return value;
    }
}
