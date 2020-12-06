import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomCustomsSixTwo {
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
            Map<Character, Integer> questions = new HashMap<>();
            int personCount = 0;
            while (input != null) {
                if (input.equals("")) {
                    for (Character c : questions.keySet()) {
                        if (questions.get(c) == personCount) {
                            totalCount++;
                        }
                    }
                    questions.clear();
                    personCount = 0;
                } else {
                    for (int idx = 0; idx < input.length(); idx++) {
                        questions.put(input.charAt(idx), questions.getOrDefault(input.charAt(idx), 0) + 1);

                    }
                    personCount++;
                }
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(totalCount);
    }
}
