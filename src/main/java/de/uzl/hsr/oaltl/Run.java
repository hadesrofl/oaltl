package de.uzl.hsr.oaltl;

import de.uzl.hsr.oaltl.util.TokenIdentifier;
import org.antlr.v4.runtime.*;
import de.uzl.hsr.oaltl.grammar.*;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        Scanner scanny = new Scanner(System.in);
        String input;
        do {
            System.out.println("Please enter your LTL Formular");
            // String input = "F p U X p";
            input = scanny.nextLine();
            CharStream is = CharStreams.fromString(input);
            LTLLexer lexer = new LTLLexer(is);

            Token token = lexer.nextToken();
            while (token.getType() != Token.EOF) {
                System.out.print("Type:" + TokenIdentifier.getTokenType(token) + ", Text: " + token.getText() + " \n");
                token = lexer.nextToken();
            }
            System.out.println("Quit program? (y/n)");
            input = scanny.nextLine();
        } while (input.toLowerCase().compareTo("y") != 0);
        scanny.close();
    }
}
