public class Rectangle extends Shape {

    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length*width;
    }

    @Override
    double calculatePerimeter() {
        return 2*(length+width);
    }

    public void setDimensions(double length,double width)
    {
       this.length=length;
       this.width=width;
    }

    public void setDimensions(double side)
    {
       this.length=side;
       this.width=side;
    }
}
