package test.algorithm.MOEAD.TCH;

import hr.fer.zemris.zavrsni.algorithms.AbstractMOOPAlgorithm;
import hr.fer.zemris.zavrsni.algorithms.MOOPUtils;
import hr.fer.zemris.zavrsni.algorithms.moead.MOEAD_TCH;
import hr.fer.zemris.zavrsni.algorithms.moead.MOEADUtil;
import hr.fer.zemris.zavrsni.algorithms.operators.Crossover;
import hr.fer.zemris.zavrsni.algorithms.operators.Mutation;
import hr.fer.zemris.zavrsni.algorithms.operators.crossover.BLXAlpha;
import hr.fer.zemris.zavrsni.algorithms.operators.mutation.NormalDistributionMutation;
import hr.fer.zemris.zavrsni.evaluator.MOOPProblem;
import hr.fer.zemris.zavrsni.evaluator.examples.DTLZ1;
import hr.fer.zemris.zavrsni.solution.RegularSolutionFactory;
import hr.fer.zemris.zavrsni.solution.Solution;
import hr.fer.zemris.zavrsni.solution.SolutionFactory;

import java.util.List;

public class MOEAD_TCH_DTLZ1Test {
    public static void main(String[] args) {

        MOOPProblem problem = new DTLZ1(3);

        int parameterH = 10;
        int closestVectors = 10;
        final int populationSize = MOEADUtil.getSizeOfPopulation(parameterH, problem.getNumberOfObjectives());
        final double blxAlpha = 0.1;
        final double sigma = 0.1;
        final double mutationChance = 0.03;

        final int maxGen = 1000;


        SolutionFactory<Solution> s = new RegularSolutionFactory();

        List<Solution> population = MOOPUtils.generateRandomPopulation(populationSize, problem, s);
        Crossover<Solution> crossover = new BLXAlpha<>(s, blxAlpha, problem.getLowerBounds(), problem.getUpperBounds());
        Mutation mutation = new NormalDistributionMutation(problem.getLowerBounds(), problem.getUpperBounds(), sigma, mutationChance);

        AbstractMOOPAlgorithm<Solution> moead = new MOEAD_TCH(population, problem, closestVectors, parameterH, mutation, crossover, maxGen);

        moead.run();
        MOOPUtils.printSolutions(moead);
    }
}