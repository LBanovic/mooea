package hr.fer.zemris.zavrsni.algorithms.moead;

import hr.fer.zemris.zavrsni.algorithms.operators.Crossover;
import hr.fer.zemris.zavrsni.algorithms.operators.Mutation;
import hr.fer.zemris.zavrsni.evaluator.MOOPProblem;
import hr.fer.zemris.zavrsni.solution.Solution;

public class MOEAD extends AbstractMOEAD {

    public MOEAD(Solution[] population, MOOPProblem problem, int closestVectors,
                 int parameterH, Mutation mutation, Crossover crossover, int maxGen) {
        super(population, problem, closestVectors, parameterH, mutation, crossover, maxGen);
    }

    protected double scalarizationFunction(Solution y, double[] weights, double[] idealPoint){
        double max = Double.MIN_VALUE;
        double[] obj = y.getObjectives();
        for(int i = 0; i < obj.length; i++){
            double value = weights[i] * Math.abs(obj[i] - idealPoint[i]);
            if(value > max) max = value;
        }
        return max;
    }

//    public static void main(String[] args) {
//        MOOPProblem m = new DTLZ1(3);
//        double[][] weights = new double[351][3];
//        MOEAD.initializeWeights(m, 25, weights);
//    }
}
