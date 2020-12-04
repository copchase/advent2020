import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TobogganTrajectoryThreeOne {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("toboggantrajectory.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int row = 0;
        int delta = 3;
        int count = 0;

        try {
            String road = reader.readLine();
            int width = road.length() - 1;

            while (road != null) {
                int position = (((row + 1) * delta)) % width;
                
                if (road.charAt(position) == '#') {
                    count++;
                }

                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
