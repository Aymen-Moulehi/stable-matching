package fitness;

import representation.implementations.Female;
import representation.implementations.Male;
import representation.interfaces.Chromosome;
import representation.interfaces.Genome;
import java.util.List;

public class FitnessCalculator {

    public static int calculateFitness(Chromosome<Female> chromosome, List<Male> potentialMatches) {
        if (chromosome == null || potentialMatches == null) {
            throw new IllegalArgumentException("Chromosome and potential matches cannot be null.");
        }

        if (chromosome.getValue().size() != potentialMatches.size()) {
            throw new IllegalStateException("The number of genomes in the chromosome must match the number of potential matches.");
        }

        int totalFitness = 0;

        for (int i = 0; i < potentialMatches.size(); i++) {
            Genome genomeInChromosome = chromosome.getValue().get(i);
            Male potentialMatch = potentialMatches.get(i);

            totalFitness += genomeInChromosome.calculateHappiness(potentialMatch);
            totalFitness += potentialMatch.calculateHappiness(genomeInChromosome);
        }

        return totalFitness;
    }
}