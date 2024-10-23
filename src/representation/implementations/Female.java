package representation.implementations;

import representation.interfaces.Genome;

import java.util.List;

public record Female(String name, List<String> potentialMatches) implements Genome {

    @Override
    public String displayGenome() {
        return name;
    }

    @Override
    public int calculateHappiness(Genome genome) {
        return potentialMatches.size() - potentialMatches.indexOf(genome.displayGenome());
    }
}
