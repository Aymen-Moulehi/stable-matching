package operators;

import representation.implementations.ChromosomeImpl;
import representation.implementations.Female;
import representation.interfaces.Chromosome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrossoverOperator {
    public static List<Chromosome<Female>> apply(List<Chromosome<Female>> population) {
        List<Chromosome<Female>> newPopulation = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < population.size(); i += 2) {
            if (i + 1 < population.size()) {
                Chromosome<Female> parent1 = population.get(i);
                Chromosome<Female> parent2 = population.get(i + 1);
                List<Chromosome<Female>> offspring = crossover(parent1, parent2, random);
                newPopulation.addAll(offspring);
            } else {
                newPopulation.add(population.get(i));
            }
        }

        population.addAll(newPopulation);

        return population;
    }

    private static List<Chromosome<Female>> crossover(Chromosome<Female> parent1, Chromosome<Female> parent2, Random random) {
        int crossoverPoint = random.nextInt(parent1.getValue().size());

        List<Female> offspringGenomes1 = new ArrayList<>(parent1.getValue().subList(0, crossoverPoint));
        offspringGenomes1.addAll(parent2.getValue().subList(crossoverPoint, parent2.getValue().size()));
        Chromosome<Female> offspring1 = ChromosomeImpl.generateChromosome(offspringGenomes1);

        List<Female> offspringGenomes2 = new ArrayList<>(parent2.getValue().subList(0, crossoverPoint));
        offspringGenomes2.addAll(parent1.getValue().subList(crossoverPoint, parent1.getValue().size()));
        Chromosome<Female> offspring2 = ChromosomeImpl.generateChromosome(offspringGenomes2);

        List<Chromosome<Female>> offspring = new ArrayList<>();
        offspring.add(offspring1);
        offspring.add(offspring2);
        return offspring;
    }
}
