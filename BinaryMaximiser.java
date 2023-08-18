package com.bham.pij.assignments.a2a;
//Brijee Rana 1938026
import java.util.Random;
public class BinaryMaximiser extends GAApplication{

	public BinaryMaximiser(int binaryLength) {
		chromosomeLength = binaryLength;
		population = new Individual[populationSize];
		population = createPopulation();
	}
	@Override
	public Individual[] createPopulation() {
		//method to make the population
		Random rand = new Random();
		int randomNumber;
		String tempStr;
		String chromosome;
		
		for (int i = 0; i < populationSize; i++) {
			chromosome = "";
			for (int j = 0; j < chromosomeLength; j++) {
				randomNumber= rand.nextInt(2);
				tempStr = Integer.toString(randomNumber);
				chromosome += tempStr;
			}
			Individual person = new Individual(chromosome);
			population[i] = person;
		}
	return population;
	}
	
	@Override 
	public char doMutation(char gene) {
		//mutating the gene
		if (gene == '0') {
		 gene = '1'; 
		} else {
		 gene = '0';
		}
		return gene;
		}
	
	@Override
	public void assessFitness() {
		for (int i =0; i<populationSize; i++) {
			population[i].fitness= population[i].chromosome.replaceAll("0", "").length();
		}
	}
}