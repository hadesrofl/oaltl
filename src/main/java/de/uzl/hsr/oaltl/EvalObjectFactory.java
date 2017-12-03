package de.uzl.hsr.oaltl;

public class EvalObjectFactory implements ObjectAlgebraFactory<EvalObject> {

	public EvalObject next(final EvalObject child) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return word.length() != 0 && child.eval(word.substring(1));
                }
            };
	}

	public EvalObject fin(final EvalObject child) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return or(child, next(fin(child))).eval(word);
                }
            };
	}

	public EvalObject until(final EvalObject child1, final EvalObject child2) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return or(child2, and(child1, next(until(child1, child2)))).eval(word);
                }
            };
	}

	public EvalObject neg(final EvalObject child) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return !child.eval(word);
                }
            };
	}

	public EvalObject and(final EvalObject child1, final EvalObject child2) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return child1.eval(word) && child2.eval(word);
                }
            };
	}

	public EvalObject or(final EvalObject child1, final EvalObject child2) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return child1.eval(word) || child2.eval(word);
                }
            };
	}

	public EvalObject val(final boolean val) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return val;
                }
            };
	}

	public EvalObject var(final String varName) {
            return new EvalObject() {
                public boolean eval(String word) {
                    return word.startsWith(varName);
                }
            };
	}
}
