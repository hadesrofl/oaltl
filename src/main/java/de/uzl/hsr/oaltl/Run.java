package de.uzl.hsr.oaltl;

import de.uzl.hsr.oaltl.util.TokenIdentifier;
import org.antlr.v4.runtime.*;
import de.uzl.hsr.oaltl.grammar.*;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        Scanner scanny = new Scanner(System.in);
        String input;
        String mode;

        do {
            System.out.println("Do you want Evaluation(e) or PrettyPrinting(p) of LTL-Formula?");
            mode = scanny.nextLine();
            mode = mode.toLowerCase();
        } while (!mode.equals("p") && !mode.equals("e"));
        
        do {
            System.out.println("Please enter your LTL Formular");
            input = scanny.nextLine();
            CharStream is = CharStreams.fromString(input);

            LTLLexer lexer = new LTLLexer(is);
            
            if (mode.equals("p")) {
                PrintingObjectFactory factory = new PrintingObjectFactory();
                System.out.println(buildObject(factory, lexer, -1).print());
            } else {
                EvalObjectFactory factory = new EvalObjectFactory();
                System.out.println("Please enter your finite word:");
                String word = scanny.nextLine();
                System.out.println(buildObject(factory, lexer, -1).eval(word) ? "Formula satisfied" : "Formula not satisfied");
            }

            
            System.out.println("Quit program? (y/n)");
            input = scanny.nextLine();
        } while (input.toLowerCase().compareTo("y") != 0);
        scanny.close();
    }

    public static <T> T buildObject(ObjectAlgebraFactory<T> fac, LTLLexer lexer, int level) {

        T parsedObject = null;
        Token t = lexer.nextToken();

        while (t.getType() != LTLLexer.EOF) {

            if (t.getType() > level && level != -1 && t.getType() != LTLLexer.VARIABLE && t.getType() != LTLLexer.PROP) {
                return parsedObject;
            }

            switch (t.getType()) {
                case LTLLexer.LPAR:
                    parsedObject = buildObject(fac, lexer, -1);
                    t = lexer.nextToken();
                    break;

                case LTLLexer.RPAR:
                    return parsedObject;

                case LTLLexer.NEG:
                    parsedObject = fac.neg(buildObject(fac, lexer, t.getType() + 2));
                    t = lexer.getToken();
                    break;

                case LTLLexer.NEXT:
                    parsedObject = fac.next(buildObject(fac, lexer, t.getType() + 1));
                    t = lexer.getToken();
                    break;

                case LTLLexer.FINALLY:
                    parsedObject = fac.fin(buildObject(fac, lexer, t.getType()));
                    t = lexer.getToken();
                    break;

                case LTLLexer.UNTIL:
                    parsedObject = fac.until(parsedObject, buildObject(fac, lexer, t.getType()));
                    t = lexer.getToken();
                    break;

                case LTLLexer.CONJ:
                    parsedObject = fac.and(parsedObject, buildObject(fac, lexer, t.getType()));
                    t = lexer.getToken();
                    break;

                case LTLLexer.DISJ:
                    parsedObject = fac.or(parsedObject, buildObject(fac, lexer, t.getType()));
                    t = lexer.getToken();
                    break;

                case LTLLexer.VARIABLE:
                    parsedObject = fac.var(t.getText());
                    t = lexer.nextToken();
                    break;

                case LTLLexer.PROP:
                    parsedObject = fac.val(t.getText().equals("TRUE") ? true : false);
                    t = lexer.nextToken();
                    break;
            }

        }

        return parsedObject;
    }
}
