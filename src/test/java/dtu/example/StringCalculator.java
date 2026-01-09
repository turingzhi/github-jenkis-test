package dtu.example;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringCalculator {

    public int add(String numbers) {
        List<Integer> negatives = new ArrayList<>();

        if (numbers.isEmpty()) {
            return 0;
        }

        // Handle custom delimiter
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, 3);
            int newlineIndex = numbers.indexOf("\n");
            numbers = numbers.substring(newlineIndex + 1);
            numbers = numbers.replace(delimiter, ",");
        }

        // Handle newlines
        numbers = numbers.replaceAll("\\r?\\n", ",");

        String[] parts = numbers.split(",");
        int sum = 0;

        for (String part : parts) {
            int value = Integer.parseInt(part);
            if (value < 0) {
                negatives.add(value);
            }
            sum += Integer.parseInt(part);
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negatives not allowed: " + negatives.toString()
            );
        }


        return sum;
    }


}

