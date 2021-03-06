package hr.fer.zemris.zavrsni.evaluator.examples;

import hr.fer.zemris.zavrsni.evaluator.Function;
import hr.fer.zemris.zavrsni.evaluator.MOOPProblem;

import java.util.Arrays;

public class DTLZ5 extends MOOPProblem {
    private int k;

    //TODO
    public DTLZ5(int fVectorLength, int kVectorLength){
        k = kVectorLength;
        Function g = RepeatingObjectives.sumOfSquares(kVectorLength, 0.5);
        objectives = RepeatingObjectives.curvePareto(fVectorLength, g);
        upperBounds = new double[getNumberOfVariables()];
        Arrays.fill(upperBounds, 1);
        lowerBounds = new double[getNumberOfVariables()];
    }

    public DTLZ5(Integer fVectorLength){this(fVectorLength, 10);}

    @Override
    public int getNumberOfVariables() {
        return objectives.length + k - 1;
    }
}
