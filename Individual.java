package com.bham.pij.assignments.a2a;
//Brijee Rana 1938026
public class Individual {
	//represents an individual in the GA
	public double fitness;
	public String chromosome;
	
	public Individual(String a) {
		chromosome = a;
		fitness = 0;
	}
	
	//method returns the current fitness of this individual 
	public double getFitness() {
	return fitness;
	}
	
	//method returns a string representation of the individual.
	public String toString() {
		return chromosome;
	}	
/*
 * For any individual that uses characters, this must be a string containing the chromosome
 *  but as a single string of characters.
 */
	}
