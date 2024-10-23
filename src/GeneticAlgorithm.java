import fitness.FitnessCalculator;
import operators.CrossoverOperator;
import operators.Mutation;
import operators.Selection;
import population.PopulationGenerator;
import representation.implementations.Female;
import representation.implementations.Village;
import representation.interfaces.Chromosome;
import utils.VillageGenerator;

import java.util.List;

public class GeneticAlgorithm {

    public static void main(String[] args) {
        Village village = VillageGenerator.genrateVillage();
        List<Chromosome<Female>> population = PopulationGenerator.generateFemaleBasePopulation(20, village);
        for (int i = 0; i < 99; i++) {
            population = Selection.select(population, village.males());
            System.out.println("Iteration " + (i + 1) + ": Best chromosome (" + FitnessCalculator.calculateFitness(population.get(population.size() - 1), village.males()) + ")"+ " = " + population.get(population.size() - 1).displayChromosome());
            CrossoverOperator.apply(population);
            Mutation.apply(population);
        }


    }
}