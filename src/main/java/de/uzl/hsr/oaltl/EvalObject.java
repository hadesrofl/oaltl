package de.uzl.hsr.oaltl;

/**
 * Interface for the eval operation on data variants
 * @author Hannes Kallwies
 *
 */
public interface EvalObject {
    /**
     * Evaluates the given word as true or false. A word is an ltl formula or part of it
     * @param word is an ltl formula or part of it
     * @return true or false
     */
    boolean eval(String word);
}
