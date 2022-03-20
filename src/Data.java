import java.util.Arrays;

public class Data {

    private double[] attributes;
    private String type;
    private double distance;

    public Data(String type, double[] attributes) {
        this.type = type;
        this.attributes = attributes;
    }


    public double[] getAttributes() {
        return attributes;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return getType() + Arrays.toString(getAttributes());
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double newDistance) {
        this.distance = newDistance;
    }


}
