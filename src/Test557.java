import java.io.*;

public class Test557 {

    private static final String SPACE = " ";
    private static final String INPUT = "INPUT.TXT";
    private static final String OUTPUT = "OUTPUT.TXT";

    private static int sNum;
    private static int sMatrixCount;
    private static int sMatrixSize;
    private static int sRowIndex;
    private static int sColumnIndex;

    private static int[][][] sMatrixes;

    public static void main(String[] args) {
        initInput();

        int result = calculate();

        writeOutput(result);
    }

    private static void initInput() {
        try (FileInputStream fis = new FileInputStream(INPUT);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis))) {

            String[] firstLine = bufferedReader.readLine().split(SPACE);
            sMatrixCount = Integer.parseInt(firstLine[0]);
            sMatrixSize = Integer.parseInt(firstLine[1]);

            String[] secondLine = bufferedReader.readLine().split(SPACE);
            sRowIndex = Integer.parseInt(secondLine[0]);
            sColumnIndex = Integer.parseInt(secondLine[1]);

            sNum = Integer.parseInt(bufferedReader.readLine());

            bufferedReader.readLine();

            sMatrixes = new int[sMatrixCount][sMatrixSize][sMatrixSize];

            for (int i = 0; i < sMatrixCount; i++) {
                for (int j = 0; j < sMatrixSize; j++) {
                    String[] matrixRow = bufferedReader.readLine().split(SPACE);

                    for (int k = 0; k < sMatrixSize; k++) {
                        int value = Integer.parseInt(matrixRow[k]);

                        sMatrixes[i][j][k] = value;
                    }
                }

                if (i != sMatrixCount - 1) {
                    bufferedReader.readLine();
                }
            }

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculate() {
        int rIndex = sRowIndex - 1;
        int cIndex = sColumnIndex - 1;
        int[] row = sMatrixes[0][rIndex];

        for (int i = 1; i < sMatrixCount; i++) {
            int[] resultRow = new int[sMatrixSize];

            for (int j = 0; j < sMatrixSize; j++) {
                int value = 0;

                for (int k = 0; k < sMatrixSize; k++) {
                    int n = (row[k] * sMatrixes[i][k][j]) % sNum;
                    value = (value + n) % sNum;
                }

                resultRow[j] = value;
            }

            row = resultRow;
        }

        return row[cIndex];
    }

    private static void writeOutput(int result) {
        try (PrintWriter printWriter = new PrintWriter(OUTPUT)) {

            printWriter.write(String.valueOf(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
