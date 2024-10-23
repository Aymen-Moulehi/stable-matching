package operators;

import representation.implementations.Female;
import representation.interfaces.Chromosome;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mutation {
    public static void  apply(List<Chromosome<Female>> population) {
        if (population.size() < 2) {
            throw new IllegalArgumentException("population must contain at least two elements to mutate.");
        }

        Random random = new Random();
        int index1 = random.nextInt(population.size());
        int index2 = random.nextInt(population.size());

        while (index1 == index2) {
            index2 = random.nextInt(population.size());
        }

        Chromosome<Female> mutatedElement1 = population.get(index1);
        Collections.shuffle(mutatedElement1.getValue());

        Chromosome<Female> mutatedElement2 = population.get(index2);
        Collections.shuffle(mutatedElement2.getValue());
    }
}
