package differentiator;

/**
 * Expression is an immutable datatype representing 
 * a differentiable expression.
 */

/*
 * ADT definition for AST of Expression
 * 
 * Expression = Addition(left, right: Expression) + 
 *              Multiplication(left, right: Expression) + 
 *              Number(num: float) + 
 *              Variable(var: String)
 *
 */

public interface Expression {

    //Differentiate function is implemented based on the visitor pattern
    //Basic idea is taken from 6.005 Fall 2012 Lecture 10 notes 

    public interface Visitor<R> {
        public R on(Multiplication prod, String s);
        public R on(Addition addition, String s);
        public R on(Variable var, String s);
        public R on(Number num, String s);
    }

    public <R> R accept(Visitor<R> v, String s);
    public Expression getLeft();
    public Expression getRight();

    public int hashCode();
    public String toString();
    @Override
    boolean equals(Object otherObj);

    public String getValue();
    public String toResult();

}
