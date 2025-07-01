public class Triangle extends Shape{
    private final double side1,side2,side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double calculateArea() {
        double perimeter = side1 + side2 + side3;

        // Calculate Area using Heron's formula
        double s = perimeter / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double calculatePerimeter() {

        return side1 + side2 + side3;
    }
}
