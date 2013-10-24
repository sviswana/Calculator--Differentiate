package differentiator;

/**
 * This class handles addition (+ operator). 
 */
public class Addition implements Expression {
    private Expression left;
    private Expression right; 

    /**
     * Initializes the left and right sides of the addition expression.
     * @param left Expression; requires left != null
     * @param right Expression; requires right != null  
     */
    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Returns sum in easy-to-read format
     * @return output as a string 
     */
    @Override
    public String toString() {
        String output = "(" + this.left.toString() + "+" + this.right.toString() + ")";
        return output;
    }
    /**
     * Checks whether two addition expressions are equal to one another
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
     * @return hashcode for addition expression
     */
    public int hashCode() {
        int prime1 = 7;
        int prime2 = 11;
        return prime1*left.hashCode() + prime2*right.hashCode();
    }


    /**
     * Final display of answer.
     * @return omits unnecessary zeros in final answer representation
     */
    @Override
    public String toResult() {
        //if both left and right are 0, simply return 0
        if (left.toResult().equals("0") && right.toResult().equals("0"))
            return "0";
        if (left.toResult().equals("0"))
            return right.toResult();
        if (right.toResult().equals("0"))
            return left.toResult();

        String finalAnswer = "(" + left.toResult() + "+" + right.toResult() + ")";
        return finalAnswer;
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
     * The left side of the addition expression.
     * @return Expression, the left side of Addition
     */
    @Override
    public Expression getLeft() {
        return this.left;
    }

    /**
     * The right side of the addition expression.
     * @return Expression, the right side of Addition
     */
    @Override
    public Expression getRight() {
        return this.right;
    }
    /**
     * Method for invoking this visitor class
     * @return invokes on this visitor object (Addition Expression)
     */
    @Override
    public <R> R accept(Visitor<R> v, String s) {
        return v.on(this, s);
    }
}