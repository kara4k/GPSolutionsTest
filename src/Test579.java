import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test579 {

    private static final String INPUT = "INPUT.TXT";
    private static final String OUTPUT = "OUTPUT.TXT";

    private static int sInputSize;
    private static String[] sInputNumbers;

    public static void main(String[] args) {
        initInput();

        List<Integer> result = calculate();

        writeOutput(result);
    }

    private static void initInput() {
        try (FileInputStream fis = new FileInputStream(INPUT);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis))) {

            sInputSize = Integer.parseInt(bufferedReader.readLine());
            sInputNumbers = bufferedReader.readLine().split(" ");
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> calculate() {
        ArrayList<Integer> posIndexes = new ArrayList<>();
        ArrayList<Integer> negIndexes = new ArrayList<>();
        int zeroCount = 0;
        int posSum = 0;
        int negSum = 0;

        for (int i = 0; i < sInputNumbers.length; i++) {
            int value = Integer.parseInt(sInputNumbers[i]);

            if (value < 0) {
                negSum += value;
                negIndexes.add(i);
            } else if (value > 0) {
                posSum += value;
                posIndexes.add(i);
            } else {
                zeroCount++;
            }
        }

        negSum = -negSum;

        if (posSum > negSum) {
            return posIndexes;
        } else if (posSum < negSum) {
            return negIndexes;
        } else if (zeroCount == sInputSize) {
            return new ArrayList<>();
        } else {
            return posIndexes;
        }
    }

    private static void writeOutput(List<Integer> indexes) {
        try (FileOutputStream fis = new FileOutputStream(OUTPUT);
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fis))) {

            bufferedWriter.write(String.valueOf(indexes.size()));
            bufferedWriter.newLine();

            for (int i = 0; i < indexes.size(); i++) {
                bufferedWriter.write(String.valueOf(indexes.get(i) + 1));

                if (i != indexes.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
