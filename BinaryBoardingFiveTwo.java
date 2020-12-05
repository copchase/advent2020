import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryBoardingFiveTwo {

    public static void main(String[] args) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("binaryboarding.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Set<Integer> seatIds = new HashSet<>();

        try {
            String input = reader.readLine();
            while (input != null) {
                seatIds.add(getSeatId(input));
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer i : seatIds) {
            if (seatIds.contains(i + 2) && !seatIds.contains(i + 1)) {
                System.out.println(i + 1);
            } else if (seatIds.contains(i - 2) && !seatIds.contains(i - 1)) {
                System.out.println(i - 1);
            }
        }

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