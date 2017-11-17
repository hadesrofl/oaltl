package de.uzl.hsr.oaltl;

public class PrintingObjectFactory implements ObjectAlgebraFactory<PrintingObject> {

	public PrintingObject next(PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "X(" + child.print() + ")";
                }
            };
	}

	public PrintingObject fin(PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "F(" + child.print() + ")";
                }
            };
	}

	public PrintingObject until(PrintingObject child1, PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")U(" + child2.print() + ")";
                }
            };
	}

	public PrintingObject neg(PrintingObject child) {
            return new PrintingObject() {
                public String print() {
                    return "!(" + child.print() + ")";
                }
            };
	}

	public PrintingObject and(PrintingObject child1, PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")&&(" + child2.print() + ")";
                }
            };
	}

	public PrintingObject or(PrintingObject child1, PrintingObject child2) {
            return new PrintingObject() {
                public String print() {
                    return "(" + child1.print() + ")||(" + child2.print() + ")";
                }
            };
	}

	public PrintingObject val(boolean val) {
            return new PrintingObject() {
                public String print() {
                    return val ? "true" : "false";
                }
            };
	}

	public PrintingObject var(String varName) {
            return new PrintingObject() {
                public String print() {
                    return varName;
                }
            };
	}
}
