package de.uzl.hsr.oaltl;
import de.uzl.hsr.oaltl.grammar.CalculatorLexer;
import de.uzl.hsr.oaltl.grammar.CalculatorParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import de.uzl.hsr.oaltl.grammar.*;

public class Run {
    public static void main(String[] args) throws Exception {
        String input = "pi*3";
        CharStream is = CharStreams.fromString(input);
        CalculatorLexer lexer = new CalculatorLexer(is);

        Token token = lexer.nextToken();
        while(token.getType() != token.EOF){
            System.out.print(token.getText() + " ");
            token = lexer.nextToken();
        }
        System.out.println("");

        lexer.reset();
        lexer.setInputStream(is);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.input();
        CalculatorBaseVisitorImpl calcVisitor = new CalculatorBaseVisitorImpl();
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
    }
}
