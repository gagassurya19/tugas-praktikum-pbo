public class Tube extends Circle implements HasVolume {
    private double height;

    Tube(double radius, double height){
        super(radius);
        this.height = height;
    }

    public double getArea(){
        return 2 * Math.PI * radius * (radius + this.height);
    }

    public double getVolume(){
        return Math.PI * Math.pow(radius, 2) * this.height;
    }
}