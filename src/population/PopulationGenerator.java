package population;

import representation.implementations.ChromosomeImpl;
import representation.implementations.Female;
import representation.implementations.Male;
import representation.implementations.Village;
import representation.interfaces.Chromosome;
import representation.interfaces.Genome;

import java.util.ArrayList;
import java.util.List;

public class PopulationGenerator {

    private static <T extends Genome> List<Chromosome<T>> generatePopulation(int numberOfPairs, List<T> individuals, PopulationGeneratorFunction<T> function) {
        if (numberOfPairs < 1) {
            throw new IllegalArgumentException("Number of pairs must be at least 1.");
        }
        int populationSize = numberOfPairs * 2;
        List<Chromosome<T>> population = new ArrayList<>();

        for (int i = 0; i < populationSize; i++) {
            population.add(function.generate(individuals));
        }
        return population;
    }

    public static List<Chromosome<Female>> generateFemaleBasePopulation(int numberOfPairs, Village village) {
        return generatePopulation(numberOfPairs, village.females(), ChromosomeImpl::generateFemaleChromosome);
    }

    public static List<Chromosome<Male>> generateMaleBasePopulation(int numberOfPairs, Village village) {
        return generatePopulation(numberOfPairs, village.males(), ChromosomeImpl::generateMaleChromosome);
    }

    @FunctionalInterface
    interface PopulationGeneratorFunction<T extends Genome> {
        Chromosome<T> generate(List<T> individuals);
    }
}
