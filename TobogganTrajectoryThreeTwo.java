import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TobogganTrajectoryThreeTwo {

    private static int[] xDeltaValues = { 1, 3, 5, 7, 1 };
    private static int[] yDeltaValues = { 1, 1, 1, 1, 2 };

    public static void main(String[] args) {
        long count = 1;
        for (int idx = 0; idx < xDeltaValues.length; idx++) {
            count *= calculateTrees(idx);
        }

        System.out.println(count);
    }

    private static int calculateTrees(int idx) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("toboggantrajectory.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int row = 0;
        int xDelta = xDeltaValues[idx];
        int yDelta = yDeltaValues[idx];
        int count = 0;

        try {
            reader.readLine();

            do {
                int skip = yDelta - 1;
                while (skip != 0) {
                    reader.readLine();
                    skip--;
                }

                String road = reader.readLine();

                if (road == null) {
                    break;
                }

                int width = road.length();
                int position = ((row + 1) * xDelta) % width;
                if (road.charAt(position) == '#') {
                    count++;
                }

                row++;
            } while (true);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

}
