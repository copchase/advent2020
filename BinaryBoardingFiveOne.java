import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int seatRow = 0; seatRow < 128; seatRow++) {
            rows.add(seatRow);
        }

        for (int seatCol = 0; seatCol < 8; seatCol++) {
            cols.add(seatCol);
        }

        for (int inputIdx = 0; inputIdx < 8; inputIdx++) {
            char inputChar = input.charAt(inputIdx);

            switch (inputChar) {
                case 'F':
                    rows = rows.subList(0, rows.size() / 2);
                    break;
                case 'B':
                    rows = rows.subList(rows.size() / 2, rows.size());
                    break;
            }
        }

        for (int inputIdx = 7; inputIdx < input.length(); inputIdx++) {
            char inputChar = input.charAt(inputIdx);

            switch (inputChar) {
                case 'L':
                    cols = cols.subList(0, cols.size() / 2);
                    break;
                case 'R':
                    cols = cols.subList(cols.size() / 2, cols.size());
                    break;
            }
        }

        return rows.get(0) * 8 + cols.get(0);
    }
}