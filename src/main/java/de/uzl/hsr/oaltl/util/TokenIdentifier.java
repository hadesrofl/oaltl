package de.uzl.hsr.oaltl.util;

import de.uzl.hsr.oaltl.grammar.LTLLexer;
import org.antlr.v4.runtime.*;

public class TokenIdentifier {
    public static String getTokenType(Token t) {
        String type = "";
        switch (t.getType()) {
            case LTLLexer.LPAR:
                type = "LPAR";
                break;
            case LTLLexer.RPAR:
                type = "RPAR";
                break;
            case LTLLexer.NEG:
                type = "NEG";
                break;
            case LTLLexer.NEXT:
                type = "NEXT";
                break;
            case LTLLexer.FINALLY:
                type = "FINALLY";
                break;
            case LTLLexer.UNTIL:
                type = "UNTIL";
                break;
            case LTLLexer.CONJ:
                type = "CONJ";
                break;
            case LTLLexer.DISJ:
                type = "DISJ";
                break;
            case LTLLexer.PROP:
                type = "PROP";
                break;
            case LTLLexer.VARIABLE:
                type = "VARIABLE";
                break;
        }
        return type;
    }
}