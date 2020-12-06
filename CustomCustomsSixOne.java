import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomCustomsSixOne {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("customcustoms.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int totalCount = 0;
        try {
            String input = reader.readLine();
            Set<Character> questions = new HashSet<>();
            while (input != null) {
                if (input.equals("")) {
                    totalCount += questions.size();
                    questions.clear();
                } else {
                    for (int idx = 0; idx < input.length(); idx++) {
                        questions.add(input.charAt(idx));
                    }
                }
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(totalCount);
    }
}
