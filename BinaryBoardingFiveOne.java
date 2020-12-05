import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinaryBoardingFiveOne {

    public static void main(String[] args) {

        int maxId = Integer.MIN_VALUE;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("binaryboarding.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String input = reader.readLine();
            while (input != null) {
                maxId = Math.max(maxId, getSeatId(input));
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(maxId);
    }

    private static int getSeatId(String input) {
        int row = 127;
        int rowDiff = 128 / 2;

        int col = 7;
        int colDiff = 8 / 2;

        for (int inputIdx = 0; inputIdx < 8; inputIdx++) {
            char inputChar = input.charAt(inputIdx);

            if (inputChar == 'F') {
                row -= rowDiff;
            }

            rowDiff >>= 1;

        }

        for (int inputIdx = 7; inputIdx < input.length(); inputIdx++) {
            char inputChar = input.charAt(inputIdx);

            if (inputChar == 'L') {
                col -= colDiff;
            }

            colDiff >>= 1;

        }

        return row * 8 + col;
    }
}
