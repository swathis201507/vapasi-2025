import java.util.ArrayList;

public class ShapeCalculator {

    public static void main(String[] args) {

        Rectangle rectangle=new Rectangle(0,0);
        rectangle.setDimensions(5,6);

        Rectangle square=new Rectangle(0,0);
        rectangle.setDimensions(5);


        ArrayList<Shape> shapes=new ArrayList<>();
        shapes.add(new Circle(3));
        shapes.add(rectangle);
        shapes.add(square);
        shapes.add(new Triangle(3.0,4.0,5.0));

        for(Shape shape:shapes)
        {
            System.out.println("Shape "+shape.getClass().getName());
            System.out.println("Area "+shape.calculateArea());
            System.out.println("Perimeter "+shape.calculatePerimeter());
        }
    }
}
