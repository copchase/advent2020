import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandyHaversacksSevenOne {

    private static String desiredColor = "shinygold";
    private static int count = 0;

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("handyhaversacks.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, List<String>> map = new HashMap<>();

        try {
            String input = reader.readLine();
            while (input != null) {
                String[] words = input.split(" ");
                String mainColor = words[0] + words[1];
                List<String> containColors = new ArrayList<>();

                if (!(words[4].equals("no"))) {
                    for (int idx = 5; idx <= words.length; idx += 4) {
                        String bagColor = words[idx] + words[idx + 1];
                        containColors.add(bagColor);
                    }
                }

                map.put(mainColor, containColors);
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        traverse(map, null, desiredColor);
        System.out.println(count);
    }

    private static boolean traverse(Map<String, List<String>> map, List<String> values, String term) {
        if (values == null) {
            for (String key : map.keySet()) {
                values = map.get(key);
                count = traverse(map, values, term) ? count + 1 : count;
            }
        } else {
            boolean success = false;
            for (String value : values) {
                if (value.equals(term)) {
                    return true;
                }
                
                success = traverse(map, map.get(value), term);
                if (success) {
                    return true;
                } else {
                    continue;
                }
            }
        }

        return false;
    }

}
