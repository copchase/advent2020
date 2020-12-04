import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PasswordPhilosophyTwoOne {
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
                int lowerLimit = Integer.parseInt(limits[0]);
                int upperLimit = Integer.parseInt(limits[1]);
                char letter = parts[1].charAt(0);
                int letterCount = 0;
                String password = parts[2];

                if (password.length() >= lowerLimit) {
                    for (int idx = 0; idx < password.length(); idx++) {
                        if (letter == password.charAt(idx)) {
                            letterCount++;
                        }
                    }
                    
                    if (letterCount >= lowerLimit && letterCount <= upperLimit) {
                        count++;
                    }
                }

                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
