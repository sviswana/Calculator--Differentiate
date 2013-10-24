package differentiator;

/**
 * This class handles variables (any sequence of letters). 
 */

public class Variable implements Expression {
    private final String strValue;

    /**
     * Initializes the variable.
     * @param val input variable; requires val != null
     *        Must consist of only alphabets [a-zA-Z]
     *        mix of lower and upper case allowed
     */
    public Variable(String val) {
        this.strValue = val;
    }

    /**
     * Value of the variable
     * @return the value of the variable, as a String 
     */
    @Override
    public String getValue() {
        return this.strValue;
    }

    /**
     * Checks whether two variables are equal to one another
     * @param otherObj The other Object we are comparing to
     * @return true, if the two expressions are structurally equal; false otherwise
     */
    @Override
    public boolean equals(Object otherObj) {
        if (!(otherObj instanceof Variable)) return false;
        Variable t = (Variable) otherObj; 
        return this.toString() == t.toString();
    }

    /**
     * Returns unique hashcode, which is simply the value of the string
     * @return hashcode for variable
     */
    public int hashCode() {
        return this.strValue.hashCode();
    }

    /**
     * Returns variable as string
     * @return variable as a string 
     */
    @Override
    public String toString() {
        return this.strValue;
    }

    /**
     * Final display of answer.
     * @return variable as string
     */
    @Override
    public String toResult() {
        return this.strValue;
    }

    /**
     * Method for invoking this visitor class
     * @return invokes on this visitor object (variable)
     */
    @Override
    public <R> R accept(Visitor<R> v, String s) {
        return v.on(this, s);
    }

    /**
     * This method is not applicable for variables 
     * Generate exception if this routine is called
     * (this routine is used only for addition and multiplication expression classes) 
     */
    @Override
    public Expression getLeft() {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    /**
     * This method is not applicable for variables 
     * Generate exception if this routine is called
     * (this routine is used only for addition and multiplication expression classes) 
     */
    @Override
    public Expression getRight() {
        throw new UnsupportedOperationException("Unsupported operation");
    }

}
