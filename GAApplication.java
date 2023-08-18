package com.bham.pij.assignments.a2a;
//Brijee Rana 1938026
import java.util.Random;
public class GAApplication {
	//base class for all types of GA
	public int chromosomeLength ;
	public int populationSize = 400;
	public Individual[] population;
	public double mutationChance = 0.001;
	public int parentSize= 80;
	public double crossoverChance = 0.75;
		
	//method to make population, 
	public Individual[] createPopulation() {
	return null;
	}
	
	//method processes one generation of the GA. 
	//must perform the mutation operations, crossover operations, etc for  iteration of the algorithm
	public void run() {
		mutation();
		assessFitness();
		sortFitness();
		crossover();
	}
	
	//method returns the current best individual.
	public Individual getBest() {
		sortFitness();
		return population[0];
	}
	
	public void mutation() {
		char gene;
		Random rand = new Random();
		double randomNumber;
		
		for (int i = 0; i < populationSize; i++) {
			for (int j = 0; j < chromosomeLength; j++) {
			randomNumber= rand.nextDouble();
			if (randomNumber <= mutationChance) {
				gene = population[i].chromosome.charAt(j);
				gene = doMutation(gene);
				population[i].chromosome = population[i].chromosome.substring(0, j) + gene +population[i].chromosome.substring(j+1); 
				
				}
			}
		}
		
	}
		
	public char doMutation(char gene) {
			
		return 'b';
	}
		
	public void assessFitness() {
			
	}
		
	public void sortFitness() {
		//using the bubble-sort algorithm
		int n = population.length;  
	    Individual temp;  
	    	for(int i=0; i < n; i++){  
	    		for(int j=1; j < (n-i); j++){  
                     if (population[j-1].fitness < population[j].fitness){  
                          //swap elements  
                    	  temp = population[j-1];  
                    	  population[j-1] = population[j];  
                    	  population[j] = temp;  
	                 }  
	             }  
	    	}  

	}
	
	public void crossover() {
		//crossing over stuff
		Random rand = new Random();
		double randomNumber;
		int crossoverPoint;
		String[] child = new String[parentSize];
		String[] parent = new String[parentSize];
		parent = matchParents();
		for (int i = 0; i < parentSize ; i+=2) {
			randomNumber= rand.nextDouble();
			if (randomNumber <= crossoverChance) {
					crossoverPoint = rand.nextInt(chromosomeLength-1) + 1;
					child[i] = parent[i].substring(0,crossoverPoint) + parent[i+1].substring(crossoverPoint);
					child[i+1] = parent[i+1].substring(0,crossoverPoint) + parent[i].substring(crossoverPoint);
					} else {
						child[i] = parent[i];
						child[i+1] = parent[i+1];
						}
			//replacing the worst 20 with the new individuals called child
			population[populationSize-i-1].chromosome = child[i];
			population[populationSize-i-2].chromosome = child[i+1];
		}
			
	}
	
	public String[] matchParents() {
		//matching top 20 parents randomly by pre muddling up the top 20 then matching the sideways
		String[] parent = new String[parentSize];
		for (int i = 0; i < parentSize; i++) {
			parent[i] = population[i].chromosome;	
		}
		Random rand = new Random();
		int randomNumber;
		String temp;
				
		for (int i = 0; i < parentSize; i++) {
			randomNumber = rand.nextInt(parentSize);
			temp = parent[i];
			parent[i] = parent[randomNumber];
			parent[randomNumber] = temp;
		}
		return parent;
	}
			
}