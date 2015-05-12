package finalexam;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Driver {

  public static void main(String[] args) {
    ArrayList<Shape3D> shapes = new ArrayList<Shape3D>();
    DecimalFormat df = new DecimalFormat("0.00");

    try {
      shapes.add(new Cylinder(3, 4));
      shapes.add(new Cylinder(2, 8));
      shapes.add(new Cylinder(-4, 0));
      shapes.add(new Cube(3));
      shapes.add(new Cube(2));
      shapes.add(new Cube(-4));
      shapes.add(new RectangularPrism(3, 3, 2));
      shapes.add(new RectangularPrism(-1, 3, 2));
      shapes.add(new RectangularPrism(6, 5, 2));

    } catch (Shape3DNegativePropertyException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < shapes.size(); i++) {
      System.out.println(shapes.get(i));
      System.out.print("Area: ");
      System.out.print(df.format(shapes.get(i).area()));
      System.out.print(" / Volume: ");
      System.out.print(df.format(shapes.get(i).volume()));
      System.out.println();
      System.out.println();
    }

  }

}
