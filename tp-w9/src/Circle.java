public class Circle extends Shape {
    protected double radius;

    Circle(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
}