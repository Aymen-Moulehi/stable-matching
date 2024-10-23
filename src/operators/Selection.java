package operators;

import fitness.FitnessCalculator;
import representation.implementations.Female;
import representation.implementations.Male;
import representation.interfaces.Chromosome;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Selection {
    public static List<Chromosome<Female>> select(List<Chromosome<Female>> population, List<Male> potentialMatches) {
        if (population == null || population.isEmpty()) {
            throw new IllegalArgumentException("");
        }

        population.sort(Comparator.comparingInt(chromosome -> FitnessCalculator.calculateFitness(chromosome, potentialMatches)));

        List<Chromosome<Female>> selectedPopulation = new ArrayList<>();
        int halfSize = population.size() / 2;
        for (int i = halfSize; i < population.size(); i++) {
            selectedPopulation.add(population.get(i));
        }

        return selectedPopulation;
    }
}
