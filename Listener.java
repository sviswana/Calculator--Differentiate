package differentiator;

import java.util.Stack;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.w3c.dom.Document;

import differentiator.grammar.ExpressionBaseListener;
import differentiator.grammar.ExpressionParser;

/**
 * This Listener class implements methods that are called by the parser
 * as the lexer tokens are parsed.
 */
public class Listener extends ExpressionBaseListener {

    // Stack is used to manage the expression as we get callbacks from the parser
    public Stack<Expression> stack = new Stack<Expression>();

    /**
     * exitExpr is called to handle the following grammar
     * 		expr : term (plus term)*
     * 
     * @param ctx Expression context
     */
    @Override 
    public void exitExpr(ExpressionParser.ExprContext ctx) { 

        if (!ctx.plus().isEmpty()) { // check to make sure there is a '+'
            // there could be multiple (plus term). childCount gives the number of blocks
            // Each (plus term) block would count as 2. 
            // So divide by 2 to get number of (plus term) blocks
            int childCount = ctx.getChildCount() / 2;
            while (childCount > 0) {
                // pop the two elements and push a new one as an add operation
                Expression exp1 = stack.pop();
                Expression exp2 = stack.pop();
                stack.push(new Addition(exp2, exp1));    
                childCount--;
            }
        }
    }

    /**
     * exitTerm is called to handle the following grammar
     * 		term : factor ( multiply factor)*
     * 
     * @param ctx Expression context
     * 
     */
    @Override 
    public void exitTerm(ExpressionParser.TermContext ctx) {

        if (!ctx.multiply().isEmpty()) { // check to make sure there is a '*'
            // there could be multiple (multiply factor). childCount gives the number of blocks
            // Each (multiply factor) block would count as 2. 
            // So divide by 2 to get number of (multiply factor) blocks
            int childCount = ctx.getChildCount() / 2;
            while (childCount > 0) {
                Expression exp1 = stack.pop();
                Expression exp2 = stack.pop();
                stack.push(new Multiplication(exp2, exp1));
                childCount--;
            }
        }
    }

    /**
     * exitFactor is called to handle the following grammar
     * 		factor : number | variable | leftp expr rightp;
     * 
     * @param ctx Expression context
     * 
     */
    @Override 
    public void exitFactor(ExpressionParser.FactorContext ctx) {
        String text;
        // Need to handle both number and variable
        if (ctx.number() != null) {
            text = ctx.number().CONSTANT().getText();;
            stack.push(new Number(text));
        } 
        else if (ctx.variable() != null) {
            text = ctx.variable().VARNAME().getText();
            stack.push(new Variable(text));
        }
    }       

    @Override
    public void exitLine(ExpressionParser.LineContext ctx) {
        // Nothing needs to be done as the complete input has been consumed at this point
    }
    public Expression getExpression() {
        // At this point, the stack should have only one element which is the completely parsed expression
        return stack.get(0);
    }
}