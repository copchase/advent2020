import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HandheldHaltingEightTwo {

    private static List<String> instructions = new ArrayList<>();
    private static int acc = 0;

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("handheldhalting.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> changableLines = new ArrayList<>();

        try {
            int line = 0;
            String input = reader.readLine();
            while (input != null) {
                instructions.add(input);
                if (input.startsWith("jmp") || input.startsWith("nop")) {
                    changableLines.add(line);
                }
                input = reader.readLine();
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer line : changableLines) {
            String changedInstruction = instructions.get(line);
            if (changedInstruction.startsWith("jmp")) {
                instructions.set(line, "nop" + changedInstruction.substring(3));
            } else {
                instructions.set(line, "jmp" + changedInstruction.substring(3));
            }

            if (!run()) {
                System.out.println(acc);
            }

            instructions.set(line, changedInstruction);
        }
    }

    private static boolean run() {
        acc = 0;
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

        } while (!infiniteLoop && currentLine < instructions.size());

        return infiniteLoop;
    }

}
