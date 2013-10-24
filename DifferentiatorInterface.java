package differentiator;

/**
 * An interface requiring the apply(String,String) and parse(String) methods.
 * Your Differentiator <b>must</b> implement this interface.
 *
 * <b>DO NOT MODIFY THIS INTERFACE!</b>
 */
public interface DifferentiatorInterface {
    /**
     * Differentiates an expression with respect to a variable
     * and returns its derivative as a string. 
     * @param expression The input expression in string format; requires expression != null.
     * @param variable The variable to differentiate by.  Must be a nonempty sequence of alphabets [a-zA-Z]+.
     * @return The expression's derivative with respect to variable.  
     *    Does not need to be simplified, and may contain extra whitespace and extra parentheses, 
     *    so "1+x", "(x+1+0)", and "((x  +  1))" would all be equivalent return values.
     * @throw an exception if the expression is invalid; see parse() for valid expressions.
     */
    public String apply(String expression, String variable);

    /**
     * Parse an expression string into an Expression tree.
     * 
     * A valid expression may contain nonnegative integers (like 5), 
     * nonnegative floating point numbers (like 32.8), 
     * variables (a sequence of letters), 
     * parentheses, whitespace (spaces and tabs), 
     * and + and * operators.
     *
     * A valid expression should be well-formed: parentheses should be balanced, 
     * the binary operators + and * should have well-formed operands, and there
     * should be at least one variable or number.
     *
     * @param expression The input expression in string format; requires expression != null
     * @return The expression as a tree.
     * @throw an exception if the expression is not valid
     */
    public Expression parse(String expression);
}
