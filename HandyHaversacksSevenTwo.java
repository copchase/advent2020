import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandyHaversacksSevenTwo {

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
                        String bagColor = words[idx - 1] + " " + words[idx] + words[idx + 1];
                        containColors.add(bagColor);
                    }
                }

                map.put(mainColor, containColors);
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        count += traverse(map, map.get(desiredColor));
        System.out.println(count);
    }

    private static int traverse(Map<String, List<String>> map, List<String> values) {

        if (values.isEmpty()) {
            return 0;
        }

        int bagTotal = 0;
        for (String value : values) {
            int quantity = Integer.parseInt(value.substring(0, 1));
            int sum = 1 + traverse(map, map.get(value.substring(2)));
            bagTotal += quantity * sum;
        }
        
        return bagTotal;
    }

}
