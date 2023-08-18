package com.bham.pij.assignments.a2a;
//Brijee Rana 1938026
public class Maths extends GAApplication {

	String target;
	int expLength;
	
	public Maths(String objective, int expressionLength) {
	target = objective;
	expLength = expressionLength; 
	chromosomeLength = target.length();
	population = new Individual[populationSize];
	population = createPopulation();
	}
}
