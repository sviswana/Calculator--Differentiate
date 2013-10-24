package differentiator;

/**
 * This class handles numbers (including integers and floats). 
 */
public class Number implements Expression {

    private final String strValue;

    /**
     * Initializes the number.
     * @param val input String; requires val != null
     *        must only contain digit characters [0..9] that translate to integer or floating point
     *        one dot ('.') allowed to represent floating point
     *        negative number not allowed (i.e val >= 0)
     *        Exponent ['E'] not allowed
     */
    public Number(String val) {
        this.strValue = val;
    }

    /**
     * Value of the number
     * @return the value of the number, as a String 
     */
    @Override
    public String getValue() {
        return this.strValue;
    }

    /**
     * Checks whether two numbers are equal to one another
     * Only string level comparisons done. So 2.0 != 2 and 2.00 != 2.0
     * @param otherObj The other Object we are comparing to
     * @return true, if the two expressions are structurally equal; false otherwise
     */
    @Override
    public boolean equals(Object otherObj) {
        if (!(otherObj instanceof Number)) return false;
        Number t = (Number) otherObj; 
        return this.toString() == t.toString();

    }
    /**
     * Returns unique hashcode, which is simply the value of the number
     * @return hashcode for number
     */
    public int hashCode() {

        return this.strValue.hashCode();

    }

    /**
     * Returns number as string
     * @return output as a string 
     */
    @Override
    public String toString() {
        return this.strValue;
    }


    /**
     * Final display of answer.
     * @return number as string
     */
    @Override
    public String toResult() {
        return this.strValue;
    }

    /**
     * Method for invoking this visitor class
     * @return invokes on this visitor object (Number)
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

