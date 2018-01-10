package de.uzl.hsr.oaltl;

import de.uzl.hsr.oaltl.grammar.LTLLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PrintTest {

    @Test
    public void testNextOperator() {
        PrintingObjectFactory testFactory = new PrintingObjectFactory();
        CharStream expression = CharStreams.fromString("XXp");
        LTLLexer testLexer = new LTLLexer(expression);
        assertEquals("X(X(p))", Run.buildObject(testFactory, testLexer, -1).print());
    }

    @Test
    public void testNegOperator() {
        PrintingObjectFactory testFactory = new PrintingObjectFactory();
        CharStream expression = CharStreams.fromString("!p");
        LTLLexer testLexer = new LTLLexer(expression);
        assertEquals("!(p)", Run.buildObject(testFactory, testLexer, -1).print());
    }

    @Test
    public void testFinOperator() {
        PrintingObjectFactory testFactory = new PrintingObjectFactory();
        CharStream expression = CharStreams.fromString("Fp");
        LTLLexer testLexer = new LTLLexer(expression);
        assertEquals("F(p)", Run.buildObject(testFactory, testLexer, -1).print());
    }

    @Test
    public void testUntilOperator() {
        PrintingObjectFactory testFactory = new PrintingObjectFactory();
        CharStream expression = CharStreams.fromString("pUq");
        LTLLexer testLexer = new LTLLexer(expression);
        assertEquals("(p)U(q)", Run.buildObject(testFactory, testLexer, -1).print());
    }

    @Test
    public void testAndOperator() {
        PrintingObjectFactory testFactory = new PrintingObjectFactory();
        CharStream expression = CharStreams.fromString("p&&q");
        LTLLexer testLexer = new LTLLexer(expression);
        assertEquals("(p)&&(q)", Run.buildObject(testFactory, testLexer, -1).print());
    }

    @Test
    public void testOrOperator() {
        PrintingObjectFactory testFactory = new PrintingObjectFactory();
        CharStream expression = CharStreams.fromString("p||q");
        LTLLexer testLexer = new LTLLexer(expression);
        assertEquals("(p)||(q)", Run.buildObject(testFactory, testLexer, -1).print());
    }

    @Test
    public void testAllOperators() {
        PrintingObjectFactory testFactory = new PrintingObjectFactory();
        CharStream expression = CharStreams.fromString("(!p&&Xq)UF(a||!b)");
        LTLLexer testLexer = new LTLLexer(expression);
        assertEquals("((!(p))&&(X(q)))U(F((a)||(!(b))))", Run.buildObject(testFactory, testLexer, -1).print());
    }

}
