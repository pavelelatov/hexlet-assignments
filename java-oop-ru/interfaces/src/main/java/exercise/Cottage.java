package exercise;

// BEGIN
public class Cottage implements Home {

    private final double area;
    private final int floorCount;

    public Cottage(
            double area,
            int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home other) {
        double comp = area - other.getArea();
        if (comp > 0) {
            return 1;
        } else if (comp < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
