package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
    private static final List<String> maleNames = loadNamesFromFile("/resources/male_full_names.txt");
    private static final List<String> femaleNames = loadNamesFromFile("/resources/female_full_names.txt");
    private static int currentMaleIndex = 0;
    private static int currentFemaleIndex = 0;

    public static String generateUniqueName(Gender gender) {
        if (gender == Gender.MALE) {
            return getNextName(maleNames, currentMaleIndex++);
        } else if (gender == Gender.FEMALE) {
            return getNextName(femaleNames, currentFemaleIndex++);
        } else {
            throw new IllegalArgumentException("Invalid gender specified. Use Gender.MALE or Gender.FEMALE.");
        }
    }

    private static String getNextName(List<String> names, int index) {
        if (index >= names.size()) {
            throw new IllegalStateException("No more unique names available in the list. Please reset or refill the names.");
        }
        return names.get(index);
    }

    private static List<String> loadNamesFromFile(String filename) {
        List<String> namesList = new ArrayList<>();
        try (InputStream inputStream = NameGenerator.class.getResourceAsStream(filename)) {
            if (inputStream == null) {
                System.err.println("File not found: " + filename);
                return namesList; // Return empty list if file not found
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String name = line.trim();
                    if (!name.isEmpty()) {
                        namesList.add(name);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file " + filename + ": " + e.getMessage());
        }
        return namesList;
    }

    public static int getMaleNamesCount() {
        return maleNames.size();
    }


    public static int getFemaleNamesCount() {
        return femaleNames.size();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(NameGenerator.generateUniqueName(Gender.MALE));
        }
    }

}
