package de.uzl.hsr.oaltl;

public class PrintingObjectFactory implements ObjectAlgebraFactory<PrintingObject> {

	public PrintingObject next(final PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "X(" + child.print() + ")";
                }
            };
	}

	public PrintingObject fin(final PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "F(" + child.print() + ")";
                }
            };
	}

	public PrintingObject until(final PrintingObject child1, final PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")U(" + child2.print() + ")";
                }
            };
	}

	public PrintingObject neg(final PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "!(" + child.print() + ")";
                }
            };
	}

	public PrintingObject and(final PrintingObject child1, final PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")&&(" + child2.print() + ")";
                }
            };
	}

	public PrintingObject or(final PrintingObject child1, final PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")||(" + child2.print() + ")";
                }
            };
	}

	public PrintingObject val(final boolean val) {
            return new PrintingObject() {
                public String print() {
                    return val ? "true" : "false";
                }
            };
	}

	public PrintingObject var(final String varName) {
            return new PrintingObject() {
                public String print() {
                    return varName;
                }
            };
	}
}
