package de.uzl.hsr.oaltl;

/**
 * This class implements the {@link ObjectAlgebraFactory} (data variants) of LTL for {@link EvalObject EvalObjects} (operation eval).
 * Therefore this class represents the eval operation for all data variants mentioned in ObjectAlgebraFactory
 *
 * @author Hannes Kallwies
 */
public class EvalObjectFactory implements ObjectAlgebraFactory<EvalObject> {

    /**
     * Implementation of evaluate operation for data variant <em>next</em>
     *
     * @param child is the object of data variant <em>next</em>
     * @return a new {@link EvalObject} for data variant <em>next</em>
     */
    public EvalObject next(final EvalObject child) {
        return new EvalObject() {
            public boolean eval(String word) {
                return word.length() != 0 && child.eval(word.substring(1));
            }
        };
    }

    /**
     * Implementation of evaluate operation for data variant <em>finally</em>
     *
     * @param child is the object of data variant <em>finally</em>
     * @return a new {@link EvalObject} for data variant <em>finally</em>
     */
    public EvalObject fin(final EvalObject child) {
        return new EvalObject() {
            public boolean eval(String word) {
                return or(child, next(fin(child))).eval(word);
            }
        };
    }

    /**
     * Implementation of evaluate operation for data variant <em>until</em>
     *
     * @param child1 is the left hand side of <em>until</em>
     * @param child2 is the right hand side of <em>until</em>
     * @return a new {@link EvalObject} for data variant <em>until</em>
     */
    public EvalObject until(final EvalObject child1, final EvalObject child2) {
        return new EvalObject() {
            public boolean eval(String word) {
                return or(child2, and(child1, next(until(child1, child2)))).eval(word);
            }
        };
    }

    /**
     * Implementation of evaluate operation for data variant <em>negation</em>
     *
     * @param child is the object of data variant <em>negation</em>
     * @return a new {@link EvalObject} for data variant <em>negation</em>
     */
    public EvalObject neg(final EvalObject child) {
        return new EvalObject() {
            public boolean eval(String word) {
                return !child.eval(word);
            }
        };
    }

    /**
     * Implementation of evaluate operation for data variant <em>and</em>
     *
     * @param child1 is the left hand side of <em>and</em>
     * @param child2 is the right hand side of <em>and</em>
     * @return a new {@link EvalObject} for data variant <em>and</em>
     */
    public EvalObject and(final EvalObject child1, final EvalObject child2) {
        return new EvalObject() {
            public boolean eval(String word) {
                return child1.eval(word) && child2.eval(word);
            }
        };
    }

    /**
     * Implementation of evaluate operation for data variant <em>or</em>
     *
     * @param child1 is the left hand side of <em>or</em>
     * @param child2 is the right hand side of <em>or</em>
     * @return a new {@link EvalObject} for data variant <em>or</em>
     */
    public EvalObject or(final EvalObject child1, final EvalObject child2) {
        return new EvalObject() {
            public boolean eval(String word) {
                return child1.eval(word) || child2.eval(word);
            }
        };
    }

    /**
     * Implementation of evaluate operation for data variant <em>value</em>
     *
     * @param val is a boolean value
     * @return a new {@link EvalObject} for data variant <em>value</em>
     */
    public EvalObject val(final boolean val) {
        return new EvalObject() {
            public boolean eval(String word) {
                return val;
            }
        };
    }

    /**
     * Implementation of evaluate operation for data variant <em>variable</em>
     *
     * @param varName is the name of the variable
     * @return a new {@link EvalObject} for data variant <em>variable</em>
     */
    public EvalObject var(final String varName) {
        return new EvalObject() {
            public boolean eval(String word) {
                return word.startsWith(varName);
            }
        };
    }
}
