package de.uzl.hsr.oaltl;

/**
 * This class implements the {@link ObjectAlgebraFactory} (data variants) of LTL for {@link PrintingObject PrintingObjects} (operation pretty printing).
 * Therefore this class represents the print operation for all data variants mentioned in ObjectAlgebraFactory
 *
 * @author Hannes Kallwies
 */
public class PrintingObjectFactory implements ObjectAlgebraFactory<PrintingObject> {
    /**
     * Implementation of pretty printing operation for data variant <em>next</em>
     *
     * @param child is the object of data variant <em>next</em>
     * @return a new {@link PrintingObject} for data variant <em>next</em>
     */
	public PrintingObject next(final PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "X(" + child.print() + ")";
                }
            };
	}
    /**
     * Implementation of pretty printing operation for data variant <em>finally</em>
     *
     * @param child is the object of data variant <em>finally</em>
     * @return a new {@link PrintingObject} for data variant <em>finally</em>
     */
	public PrintingObject fin(final PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "F(" + child.print() + ")";
                }
            };
	}
    /**
     * Implementation of pretty printing operation for data variant <em>until</em>
     *
     * @param child1 is the left hand side of <em>until</em>
     * @param child2 is the right hand side of <em>until</em>
     * @return a new {@link PrintingObject} for data variant <em>until</em>
     */
	public PrintingObject until(final PrintingObject child1, final PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")U(" + child2.print() + ")";
                }
            };
	}
    /**
     * Implementation of pretty printing operation for data variant <em>negation</em>
     *
     * @param child is the object of data variant <em>negation</em>
     * @return a new {@link PrintingObject} for data variant <em>negation</em>
     */
	public PrintingObject neg(final PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "!(" + child.print() + ")";
                }
            };
	}
    /**
     * Implementation of pretty printing operation for data variant <em>and</em>
     *
     * @param child1 is the left hand side of <em>and</em>
     * @param child2 is the right hand side of <em>and</em>
     * @return a new {@link PrintingObject} for data variant <em>and</em>
     */
	public PrintingObject and(final PrintingObject child1, final PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")&&(" + child2.print() + ")";
                }
            };
	}
    /**
     * Implementation of pretty printing operation for data variant <em>or</em>
     *
     * @param child1 is the left hand side of <em>or</em>
     * @param child2 is the right hand side of <em>or</em>
     * @return a new {@link PrintingObject} for data variant <em>or</em>
     */
	public PrintingObject or(final PrintingObject child1, final PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")||(" + child2.print() + ")";
                }
            };
	}
    /**
     * Implementation of pretty printing operation for data variant <em>value</em>
     *
     * @param val is a boolean value
     * @return a new {@link PrintingObject} for data variant <em>value</em>
     */
	public PrintingObject val(final boolean val) {
            return new PrintingObject() {
                public String print() {
                    return val ? "true" : "false";
                }
            };
	}
    /**
     * Implementation of pretty printing operation for data variant <em>variable</em>
     *
     * @param varName is the name of the variable
     * @return a new {@link PrintingObject} for data variant <em>variable</em>
     */
	public PrintingObject var(final String varName) {
            return new PrintingObject() {
                public String print() {
                    return varName;
                }
            };
	}
}
