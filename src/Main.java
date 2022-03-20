import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        DataReader dataReader = new DataReader("iristest.csv");

        dataReader.print();

    }
}
