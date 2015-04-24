package lab9;

import java.text.DecimalFormat;

public class Rectangle extends Shape {
    
    protected double length = 0;
    protected double width = 0;
    
    public Rectangle(){
	drawChar = Properties.RECTANGLE_CHAR;
    }
    
    public Rectangle(Rectangle originalObject)
    {
        if (originalObject == null)
        {
            System.out.println("Error: null Rectangle object.");
            System.exit(0);
        }
        //else
        length = originalObject.length;
        width = originalObject.width;
        drawChar = Properties.RECTANGLE_CHAR;
    }
    
    public Rectangle(double length, double width){
	this.length = length;
	this.width = width;
    }
    
    public String toString() {
	DecimalFormat df = new DecimalFormat("#.##");
	StringBuilder sb = new StringBuilder();
	
	sb.append(super.toString());
	sb.append("Length: ");
	sb.append(length);
	sb.append(" / Width: ");
	sb.append(width);
	sb.append("\n");
	sb.append("Area: ");
	sb.append(df.format(getArea()));
	sb.append(" / Permimeter: ");
	sb.append(df.format(getPerimeter()));
	sb.append("\n");

	return sb.toString();
    }
    
    public boolean equals(Object other)
    {
      if ( other == null ) {
 	     return false;
       } // end of if ()
       else if ( this.getClass() != other.getClass() ) {
 	     return false;
       } // end of if ()
       else {
 	     Rectangle rectangle = (Rectangle)other;
 	     return ((super.equals(rectangle)) && (this.length == rectangle.length) && (this.width == rectangle.width));
       } // end of else
    }
    
    public Rectangle clone(){
	return new Rectangle(this);	
    }

    @Override
    public double getArea() {
	return length * width;
    }

    @Override
    public void draw() {
	System.out.print(drawChar);
    }

    @Override
    public double getPerimeter() {
	return 2 * (length + width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}
