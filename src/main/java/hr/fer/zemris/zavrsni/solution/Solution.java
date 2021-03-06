package hr.fer.zemris.zavrsni.solution;

import java.util.Arrays;

public class Solution {

    private double[] variables;
    private double[] objectives;

    /**
     * Constructs a new Solution with the given variables and the given number of objectives.
     * @param variables
     * @param numberOfObjectives
     */
    public Solution(double[] variables, int numberOfObjectives){
        this.variables = variables;
        this.objectives = new double[numberOfObjectives];
    }

    protected Solution(Solution s){
        this.variables = Arrays.copyOf(s.variables, s.variables.length);
        this.objectives = Arrays.copyOf(s.objectives, s.objectives.length);
    }
    /**
     * Returns the variables from the Solution.
     * @return
     */
    public double[] getVariables(){
        return variables;
    }

    /**
     * Returns the value of the objectives.
     * @return
     */
    public double[] getObjectives() {
        return objectives;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < variables.length - 1; i++){
            sb.append(variables[i]).append(" ");
        }
        sb.append(variables[variables.length - 1]);
        return sb.toString();
    }
//
//    @Override public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Solution solution = (Solution) o;
//        return Arrays.equals(variables, solution.variables);
//    }
//
//    @Override public int hashCode() {
//        return Arrays.hashCode(variables);
//    }
}
