grammar LTL;

@header {
    package de.uzl.hsr.oaltl.grammar;
}

// parser rules
ltl: conj (DISJ conj)*;
conj: binary (CONJ binary)*;
binary: unary (UNTIL unary)*;
unary: (NEXT | FINALLY)* negation;
negation: NEG* prop;
prop: PROP | LPAR ltl RPAR;

// lexer rules
LPAR  : '(';
RPAR  : ')';
NEG: '!';
NEXT: 'X';
FINALLY: 'F';
UNTIL: 'U';
CONJ: '&&';
DISJ:  '||';
PROP: 'TRUE'|'FALSE'|VARIABLE;
VARIABLE: [a-z]+;

WS: [ \n\t\r]+ -> skip;



