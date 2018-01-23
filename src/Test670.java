import java.io.*;

public class Test670 {

    private static final String INPUT = "INPUT.TXT";
    private static final String OUTPUT = "OUTPUT.TXT";


    public static void main(String[] args) {
        int i = readInput();

        int result = calculate(i);

        writeOutput(result);
    }

    private static int calculate(int n) {
        int index = 1;
        int result = 1;

        while (index != n) {
            result++;

            if (result < 10) {
                index++;
            } else if (result > 9 && result < 100) {
                int j = result / 10;        //10
                int k = result % 10;        // 1

                if (j != k) {
                    index++;
                }

            } else if (result > 99 && result < 1000) {
                int j = result / 100;        //100
                int k = result % 100;
                int m = k / 10;      //10
                int b = k % 10;      //1

                if (j != m && j != b && m != b) {
                    index++;
                }

            } else if (result > 999 && result < 10000) {
                int j = result / 1000;      //1000
                int k = result % 1000;
                int m = k / 100;        //100
                int b = k % 100;
                int l = b / 10;         //10
                int c = b % 10;         //1

                if (j != m && j != l && j != c && m != l && m != c && l != c) {
                    index++;
                }

            } else {
                int a = result / 10000;     //10000
                int z = result % 10000;
                int j = z / 1000;      //1000
                int k = z % 1000;
                int m = k / 100;        //100
                int b = k % 100;
                int l = b / 10;         //10
                int c = b % 10;         //1

                if (a!=j && a!= m && a != l && a!=c && j != m && j != l && j != c && m != l && m != c && l != c) {
                    index++;
                }
            }
        }
        return result;
    }

    private static int readInput() {
        try (FileReader fileReader = new FileReader(INPUT);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static void writeOutput(int i) {
        try (PrintWriter printWriter = new PrintWriter(OUTPUT)) {

            printWriter.write(String.valueOf(i));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
