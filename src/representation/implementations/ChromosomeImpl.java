package representation.implementations;

import representation.interfaces.Chromosome;
import representation.interfaces.Genome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChromosomeImpl<T extends Genome> implements Chromosome<T> {

    private final List<T> value;

    private ChromosomeImpl(List<T> value) {
        this.value = value;
    }

    @Override
    public List<T> getValue() {
        return value;
    }

    @Override
    public String displayChromosome() {
        return value.stream()
                .map(Genome::displayGenome)
                .reduce((s1, s2) -> s1 + "|" + s2)
                .orElse("");
    }

    public static <T extends Genome> Chromosome<T> generateChromosome(List<T> genomes) {
        if (genomes == null) {
            throw new IllegalStateException("Genome list cannot be null. Please provide a valid list of genomes.");
        }
        List<T> shuffledGenomes = new ArrayList<>(genomes);
        Collections.shuffle(shuffledGenomes);
        return new ChromosomeImpl<>(shuffledGenomes);
    }

    public static Chromosome<Female> generateFemaleChromosome(List<Female> genomes) {
        return generateChromosome(genomes);
    }

    public static Chromosome<Male> generateMaleChromosome(List<Male> genomes) {
        return generateChromosome(genomes);
    }
}
