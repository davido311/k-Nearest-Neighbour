import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Podaj wartość parametru K:");
        Scanner scanner = new Scanner(System.in);
        String kInput = scanner.nextLine();
        DataReader testData = new DataReader("data/iristest.csv");
        DataReader trainData = new DataReader("data/iristrain.csv");

        Classifier classifier = new Classifier(testData.getDataList(), trainData.getDataList(), Integer.parseInt(kInput));

        System.out.println(classifier.showResult());

        //user input
        System.out.println("Podaj wektor atrybutów - x1,x2,x3,x4...");
        String inputVector;
        while (!(inputVector = scanner.nextLine()).equals("exit")) {

            try {
                double[] doubleVector = Arrays.stream(inputVector.split(",")).mapToDouble(Double::parseDouble).toArray();


                String result = classifier.classify(new Data("null", doubleVector));
                System.out.println(Arrays.toString(doubleVector) + " - " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Za dużo podanych argumentów");
            } catch (NumberFormatException e) {
                System.out.println("Podaj poprawne liczby po przecinku");
            }


        }


    }
}
