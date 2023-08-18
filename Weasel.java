package com.bham.pij.assignments.a2a;
//Brijee Rana 1938026
import java.util.Random;
public class Weasel extends GAApplication {
//The Weasel class represents a GA that can find an arbitrary search string.
	
	public String target;
	
	public Weasel(String objective) {
	target = objective;
	chromosomeLength = target.length();
	population = new Individual[populationSize];
	population = createPopulation();
	}
	
	@Override
	public Individual[] createPopulation() {
		//method to make the population
		Random rand = new Random();
		int randomNumber;
		String chromosome;
		
		for (int i = 0; i < populationSize; i++) {
			chromosome = "";
			for (int j = 0; j < chromosomeLength; j++) {
				randomNumber= rand.nextInt(91) + 32;
				char letter = (char)randomNumber; 
				chromosome += letter;
			}
			Individual person = new Individual(chromosome);
			population[i] = person;
		}
	return population;
	}
	
	@Override 
	public char doMutation(char gene) {
		//mutating the gene
		int ascii = (int) gene;
		if (ascii != 32) {
			ascii -= 1;
			gene = (char)ascii;
		} else {
			ascii = 122;
			gene = (char)ascii;
		}
		return gene;
	}
	
	@Override
	public void assessFitness() {
		int distance = 0;
		for (int i =0; i<populationSize; i++) {
			for (int j = 0; j < chromosomeLength; j++) {
				char gene = population[i].chromosome.charAt(j);
				int ascii = (int) gene;
				if(ascii > (int)target.charAt(j)) {
					distance += ascii-(int)target.charAt(j);
				} else {
					distance += (int)target.charAt(j) - ascii;
				}
			}
			population[i].fitness = (1/distance);
		}
	}
}