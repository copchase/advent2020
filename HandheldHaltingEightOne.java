import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HandheldHaltingEightOne {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("handheldhalting.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> instructions = new ArrayList<>();

        try {
            String input = reader.readLine();
            while (input != null) {
                instructions.add(input);
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int acc = 0;
        int currentLine = 0;
        Set<Integer> executed = new HashSet<>();
        boolean infiniteLoop = false;
        do {
            String instruction = instructions.get(currentLine);
            infiniteLoop = executed.contains(currentLine);
            executed.add(currentLine);
            if (instruction.startsWith("acc")) {
                acc += Integer.parseInt(instruction.substring(4));
                currentLine++;
            } else if (instruction.startsWith("jmp")) {
                currentLine += Integer.parseInt(instruction.substring(4));
            } else {
                currentLine++;
            }
        } while (!infiniteLoop);

        System.out.println(acc);
    }
}
