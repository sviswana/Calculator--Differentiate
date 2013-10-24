package differentiator;

/**
 * This class handles Multiplication (* operator). 
 */
public class Multiplication implements Expression {
    private Expression left;
    private Expression right;


    /**
     * Initializes the left and right sides of the multiplication expression.
     * @param left Expression; requires left != null
     * @param right Expression; requires right != null 
     */
    public Multiplication(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Returns sum in easy-to-read format
     * @return output as a string 
     */
    @Override
    public String toString() {
        String output = "(" + this.left.toString() + "*" + this.right.toString() + ")";
        return output;
    }

    /**
     * Checks whether two multiplication expressions are equal to one another
     * @param otherObj The other Object we are comparing to
     * @return true, if the two expressions are structurally equal; false otherwise
     */
    @Override
    public boolean equals(Object otherObj) {
        if (!(otherObj instanceof Expression)) return false;
        Expression left  = ((Expression) (otherObj)).getLeft();
        Expression right = ((Expression) (otherObj)).getRight();
        return this.left.toString().equals(left.toString()) && this.right.toString().equals(right.toString());

    }
    /**
     * Returns unique hashcode to expression
     * @return hashcode for multiplication expression
     */
    public int hashCode() {
        int prime1 = 17;
        int prime2 = 19;
        return prime1 * left.hashCode() + prime2 * right.hashCode();
    }


    /**
     * This method is not implemented, because it is not needed for this particular variant.
     * (needed for Number.java)
     */
    @Override
    public String getValue() {
        throw new UnsupportedOperationException();
    }

    /**
     * Final display of answer.
     * @return omits unnecessary zeros in final answer representation
     */
    @Override
    public String toResult() {
        if (left.toResult().equals("0") || right.toResult().equals("0"))
            return "0";
        if (left.toResult().equals("1"))
            return right.toResult();
        if (right.toResult().equals("1"))
            return left.toResult();

        String finalAnswer = "(" + left.toResult() + "*" + right.toResult() + ")";
        return finalAnswer;

    }

    /**
     * The left side of the multiplication expression.
     * @return Expression, the left side of multiplication
     */
    @Override
    public Expression getLeft() {
        return this.left;
    }

    /**
     * The right side of the multiplication expression.
     * @return Expression, the right side of multiplication
     */
    @Override
    public Expression getRight() {
        return this.right;
    }
    /**
     * Method for invoking this visitor class
     * @return invokes on this visitor object (Multiplication Expression)
     */
    @Override
    public <R> R accept(Visitor<R> v, String s) {
        return v.on(this, s);
    }
}