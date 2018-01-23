import java.io.*;

public class Test278 {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final String INPUT = "INPUT.TXT";
    private static final String OUTPUT = "OUTPUT.TXT";

    private static String sFirstLine;
    private static String sSecondLine;

    public static void main(String[] args) {
        initInput();

        String result = checkEvolution();

        writeOutput(result);
    }

    private static String checkEvolution() {
        int index = 0;

        if (sFirstLine.length() > sSecondLine.length()) {
            return NO;
        }

        for (int i = 0; i < sSecondLine.length(); i++) {
            char c = sSecondLine.charAt(i);

            if (c == sFirstLine.charAt(index)) {
                index++;
            }

            if (index == sFirstLine.length()) {
                return YES;
            }
        }

        return NO;
    }


    private static void initInput() {
        try (FileInputStream fis = new FileInputStream(INPUT);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis))) {

            sFirstLine = bufferedReader.readLine();
            sSecondLine = bufferedReader.readLine();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeOutput(String result) {
        try (PrintWriter printWriter = new PrintWriter(OUTPUT)) {

            printWriter.write(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
