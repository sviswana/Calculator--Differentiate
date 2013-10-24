/**
 * This file is the grammar file used by ANTLR.
 *
 * In order to compile this file, navigate to this directory
 * (<src/differentiator/grammar>) and run the following command:
 * 
 * java -jar ../../../antlr.jar Expression.g4
 */

grammar Expression;

/*
 * This puts "package differentiator.grammar;" at the top of the output Java
 * files. Do not change these lines.
 */
@header {
package differentiator.grammar;
}

/*
 * This adds code to the generated lexer and parser. Do not change these lines. 
 */
@members {
    // This method makes the lexer or parser stop running if it encounters
    // invalid input and throw a RuntimeException.
    public void reportErrorsAsExceptions() {
        removeErrorListeners();
        addErrorListener(new ExceptionThrowingErrorListener());
    }
    
    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol, int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException(msg);
        }
    }
}

/*
 * These are the lexical rules. They define the tokens used by the lexer.
 */
PLUS     : '+'; 
MULTIPLY : '*';
DOT : '.';
VARNAME : ('a'..'z' | 'A'..'Z')+; 
CONSTANT: ('0'..'9')* (DOT)? ('0'..'9')+;
LEFTP: '(';
RIGHTP: ')';
WS :  (' '|'\t'|'\f'|'\n'|'\r')+{ skip(); }; // ignore white spaces



/*
 * These are the parser rules. They define the structures used by the parser.
 *
 * You should make sure you have one rule that describes the entire input.
 * This is the "start rule". The start rule should end with the special
 * predefined token EOF so that it describes the entire input. Below, we've made
 * "line" the start rule.
 *
 * For more information, see
 * http://www.antlr.org/wiki/display/ANTLR4/Parser+Rules#ParserRules-StartRulesandEOF
 */
 
line : expr EOF;
expr : term (plus term)*;
term : factor ( multiply factor)*;
factor : number | variable | leftp expr rightp;

rightp : RIGHTP;
leftp : LEFTP;
plus : PLUS;
multiply : MULTIPLY;
variable : VARNAME;
number : CONSTANT ;


