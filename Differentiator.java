package differentiator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import differentiator.grammar.ExpressionBaseListener;
import differentiator.grammar.ExpressionLexer;
import differentiator.grammar.ExpressionParser;

public class Differentiator implements DifferentiatorInterface {

    private Listener listener;

    public Expression parse(String expression) {

        runListener(expression);
        return listener.getExpression();        

    }
    /**
     * Differentiate function is implemented based on the visitor pattern
     * Basic idea is taken from 6.005 Fall 2012 Lecture 10 notes
     * 
     * @param expr Input expression that has already been parsed; requires expr != null
     * @param var The variable to differentiate with respect to; requires var != null
     * @return Expression result of the next node that will be expanded 
     */
    public Expression differentiate(Expression expr, String var) {
        return expr.accept(new Expression.Visitor<Expression>() {

            /**
             * Using the product Rule for differentiation
             * 
             * @param mult Multiply expression object
             * @param var String that contains variable to differentiate to
             * @return Expression result of differentiating Multiplication expression mult against var
             */
            public Expression on(Multiplication mult, String var) {
                Expression exprLeft = mult.getLeft();
                Expression exprRight = mult.getRight();

                return new Addition(new Multiplication(differentiate(exprLeft, var), exprRight), 
                        new Multiplication(exprLeft, differentiate(exprRight, var)));
            }

            /**
             * Using the Addition Rule for differentiation
             * 
             * @param sum Addition expression object
             * @param var String that contains variable to differentiate to
             * @return Expression result of differentiating Addition expression sum against var
             */
            public Expression on(Addition sum, String var) {
                Expression exprLeft = sum.getLeft();
                Expression exprRight = sum.getRight();

                return new Addition(differentiate(exprLeft, var), differentiate(exprRight, var));
            }

            /**
             * Differentiates v against the var
             * 
             * @param v Variable expression object
             * @param var String that contains variable to differentiate to
             * @return Expression result of differentiating Variable expression v against var
             */
            public Expression on(Variable v, String var) {  
                //If the input var is the same as what we are differentiating with respect to, then we need  
                // to process further. So return a value of 1. Otherwise zero
                if (var.equals(v.getValue())) {
                    return new Number("1");
                }
                //Variable v is not differentiated with respect to var
                return new Number("0");
            }
            /**
             * Differentiates constant num against the var
             *  Will always return zero as we are differentiating a constant number
             *  
             * @param num Number expression object
             * @param var String that contains variable to differentiate to
             * @return Expression result of differentiating Variable expression v against var
             */
            public Expression on(Number num, String var) {
                return new Number("0");
            }
        }, var);
    }

    /**
     * Differentiates constant num against the var
     *  Will always return zero as we are differentiating a constant number
     *  
     * @param expression A String object containing the expression to be differentiated 
     * @param variable A String object that contains variable to differentiate to
     * @return A String object containing the result of differentiating expression against variable
     */
    public String apply(String expression, String variable) {
        return differentiate(parse(expression), variable).toResult();
    }

    /**
     * Runs the listener on the given input string.
     * 
     * @param input The input string.
     */
    private void runListener(String input) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(input);
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);

        // Feed the tokens into the parser.
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.reportErrorsAsExceptions();

        // Generate the parse tree using the starter rule.
        ParseTree tree;
        tree = parser.line(); // "line" is the starter rule.
        ((RuleContext)tree).inspect(parser);

        // Walk the tree with the listener.
        ParseTreeWalker walker = new ParseTreeWalker();
        listener = new Listener();
        walker.walk(listener, tree);

    }
}
