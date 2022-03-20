
import java.util.Arrays;

public class Data {

    private String[] attributes;
    private String type;

    public Data(String type, String[] attributes) {
        this.type = type;
        this.attributes = attributes;
    }


    public String[] getAttributes() {
        return attributes;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return getType() + Arrays.toString(getAttributes());
    }


}
