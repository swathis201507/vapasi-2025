public class Circle extends Shape{

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {

        double pi = 3.142, area;
        area = pi * radius * radius;

        return area;
    }

    @Override
    double calculatePerimeter() {
        return 2*Math.PI*radius;
    }
}
