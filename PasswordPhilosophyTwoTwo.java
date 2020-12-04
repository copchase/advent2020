import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PasswordPhilosophyTwoTwo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("passwordphilosophy.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int count = 0;

        try {
            String s = reader.readLine();
            while (s != null) {
                String[] parts = s.split(" ");
                String[] limits = parts[0].split("-");
                int idxA = Integer.parseInt(limits[0]) - 1;
                int idxB = Integer.parseInt(limits[1]) - 1;
                char letter = parts[1].charAt(0);
                String password = parts[2];


                if ((password.charAt(idxA) == letter) ^ (password.charAt(idxB) == letter)) {
                    count++;
                }

                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
