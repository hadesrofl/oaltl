package de.uzl.hsr.oaltl;

import de.uzl.hsr.oaltl.grammar.LTLLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EvalTest {

    @Test
    public void testNextNegAndOperators() {
        EvalObjectFactory testFactory = new EvalObjectFactory();
        CharStream expression = CharStreams.fromString("XX(!t&&s)");
        LTLLexer testLexer = new LTLLexer(expression);
        assertTrue(Run.buildObject(testFactory, testLexer, -1).eval("test"));
    }

    @Test
    public void testUntilFinOrOperators() {
        EvalObjectFactory testFactory = new EvalObjectFactory();
        CharStream expression = CharStreams.fromString("(a||b)UFc");
        LTLLexer testLexer = new LTLLexer(expression);
        assertTrue(Run.buildObject(testFactory, testLexer, -1).eval("aababghic"));
    }
}
