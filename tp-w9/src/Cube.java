public class Cube extends Square implements HasVolume {
    Cube(double side){
        super(side);
    }

    public double getArea() {
        return 6 * super.getArea();
    }

    public double getVolume(){
        return Math.pow(width, 3);
    }
}