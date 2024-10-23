package representation.interfaces;

import java.util.List;

public interface Chromosome<T extends Genome> {
    List<T> getValue();
    String displayChromosome();
}
