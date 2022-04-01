import java.util.*;
import java.util.stream.Collectors;

public class Classifier {
    private List<Data> testList, trainList;
    private int k;
    private HashMap<String, Integer> hashMap;

    public Classifier(List<Data> testList, List<Data> trainList, int k) {
        this.trainList = trainList;
        this.testList = testList;
        this.k = k;
    }

    public String classify(Data data) {
        hashMap = new HashMap<>();
        //lista z dodaną odległością
        for (Data trainData : trainList) {
            double distance = eucDistance(data, trainData);
            trainData.setDistance(distance);
        }

        List<Data> sortedList = trainList.stream().sorted((o1, o2) -> {
            if (o1.getDistance() > o2.getDistance()) return 1;
            else if (o1.getDistance() < o2.getDistance()) return -1;
            else return 0;
        }).limit(getK()).collect(Collectors.toList());

        for (Data sortedData : sortedList) {
            if (!hashMap.containsKey(sortedData.getType())) hashMap.put(sortedData.getType(), 1);
            else hashMap.put(sortedData.getType(), hashMap.get(sortedData.getType()) + 1);

        }
         return Collections.max(hashMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }


    public String showResult() {

        double correctAnswers = 0;

        for (Data testData : testList) {
            if (testData.getType().trim().equals(classify(testData).trim())) correctAnswers++;
            System.out.println(testData.getType() + " " + Arrays.toString(testData.getAttributes()) + "predicted = " + classify(testData));
        }
        return "Dokładność algorytmu: " + correctAnswers * 100 / testList.size() + "%";
    }


    //euclidean distance
    public double eucDistance(Data d1, Data d2) {
        double distance = 0;

        for (int i = 0; i < d1.getAttributes().length; i++) {
            distance += Math.pow((d1.getAttributes()[i] - d2.getAttributes()[i]), 2);
        }
        return distance;
    }


    public int getK() {
        return this.k;
    }

}
