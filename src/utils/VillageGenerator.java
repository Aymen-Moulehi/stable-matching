package utils;

import representation.implementations.Female;
import representation.implementations.Male;
import representation.implementations.Village;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VillageGenerator {
    public static final int COUPLES_NUMBER = 8;
    private static Village village;

    public static Village genrateVillage() {
        if (village != null) {
            return village;
        }

        List<Male> males = new ArrayList<>();
        List<Female> females = new ArrayList<>();
        List<String> maleNames = new ArrayList<>();
        List<String> femaleNames = new ArrayList<>();

        for (int i=0; i < COUPLES_NUMBER; i++) {
            maleNames.add(NameGenerator.generateUniqueName(Gender.MALE));
            femaleNames.add(NameGenerator.generateUniqueName(Gender.FEMALE));
        }

        maleNames.forEach(name -> {
            List<String> potentialMatches = new ArrayList<>(femaleNames);
            Collections.shuffle(potentialMatches);
            males.add(new Male(name, potentialMatches));
        });

        femaleNames.forEach(name -> {
            List<String> potentialMatches = new ArrayList<>(maleNames);
            Collections.shuffle(potentialMatches);
            females.add(new Female(name, potentialMatches));
        });

        village = new Village(females, males);
        return village;
    }


}
