package differentiator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTest {

    /*
     * *********************  toString() tests ********************************
     * 
     * The testing strategy is to make sure that all combinations of the 4 variants
     * (Addition, Multiplication, Constant and Variable) are tested
     *    Each expression will consist of
     *    	Only one type of variant 
     *    	Combinations of two variants from the above 4
     *    	Combinations of three variants from the above 4 
     *    	All 4 combinations
     *    Also multiple occurrences of same type of variants 
     *    
     * There are test cases to test the following are not equal   
     *    Variables that match only when case insensitive comparison is done
     *    Extra trailing zeroes in decimal point (2.00 != 2.0)
     *    
     * Since expression objects can be created only with valid input, invalid inputs will not be tested
     */

    @Test
    public void testToStringSingleNumber() {

        Expression expr = new Number("5690");
        String expectedOutput = "5690";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringSingleFpNumber() {

        Expression expr =  new Number("5.3910001");
        String expectedOutput = "5.3910001";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    // Not equals test (24.930 != 24.93)
    public void testToStringSingleFpNumberExtraZeroes() {

        Expression expr =  new Number("24.930");
        String expectedOutput = "24.93";
        assertEquals(false, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringSingleVariable() {

        Expression expr =  new Variable("FooBar");
        String expectedOutput = "FooBar";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    // Not equals test - Mixed case variable names
    public void testToStringSingleVariableMixedCase() {

        Expression expr =  new Variable("FooBar");
        String expectedOutput = "foobar";
        assertEquals(false, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringSingleAddition() {

        Expression expr = new Addition(new Number("3"), new Number("5"));
        String expectedOutput = "(3+5)";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringSingleMultiplication() {

        Expression expr = new Multiplication(new Number("2.4"), new Number("5.7"));
        String expectedOutput = "(2.4*5.7)";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringAddTwoCombined() {

        Expression expr = new Addition(new Number("30"), new Number("592")); 
        String expectedOutput = "(30+592)";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringMultTwoCombined() {

        Expression expr = new Multiplication(new Number("309"), new Number("59")); 
        String expectedOutput = "(309*59)";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringAddThreeCombined() {

        Expression expr = new Addition(new Addition(new Number("3.5"), new Number("5")), 
                new Number("7.999"));
        String expectedOutput = "((3.5+5)+7.999)";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    public void testToStringMultThreeCombined() {

        Expression expr = new Multiplication(new Multiplication(new Number("60"), new Number("50")), 
                new Number("7.999"));
        String expectedOutput = "((60*50)*7.999)";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }
    @Test
    //Combining variants: Addition,multiplication, number, and variable
    public void testToStringAddMultVarNum() {

        Expression expr = new Addition (new Multiplication(new Number("2.4"), new Number("5.7")), 
                new Multiplication(new Number("4.9"), new Variable("Bar")));
        String expectedOutput = "((2.4*5.7)+(4.9*Bar))";
        assertEquals(true, expectedOutput.equals(expr.toString()));
    }


    /*
     * *********************  equals() tests ********************************
     * 
     * The testing strategy is to make sure that all combinations of the Addition, Multiplication, Number and 
     * Variable expressions are tested
     * 
     * The testing strategy is to make sure that all combinations of the 4 variants
     * (Addition, Multiplication, Constant and Variable) are tested
     *    Each expression will consist of
     *    	Only one type of variant 
     *    	Combinations of two variants from the above 4
     *    	Combinations of three variants from the above 4 
     *    	All 4 combinations
     *    Also multiple occurrences of same type of variants 
     *    for number objects, string level comparisons done. So 2.0 != 2 and 2.00 != 2.0
     * 
     * For structural equality, order is important. So a+b != b+a
     *    there are test cases where order of operands will be swapped to test the above
     *       
     * There are also tests where one of the expressions will not be equal to the other
     *    by changing the value of one of the variants
     *    
     * Since expression objects can be created only with valid input, invalid inputs will not be tested
     * 
     */


    @Test
    public void testEqualsSingleNumber() {
        Expression expr1 = new Number("5");
        Expression expr2 = new Number("5");
        assertEquals(true, expr1.equals(expr2));
    }
    @Test
    public void testEqualsSingleVariable() {
        Expression expr1 = new Variable("ABC");
        Expression expr2 = new Variable("ABC");
        assertEquals(true, expr1.equals(expr2));
    }
    @Test
    public void testNotEqualsSingleNumber() {
        Expression expr1 = new Number("55");
        Expression expr2 = new Number("556");
        assertEquals(false, expr1.equals(expr2));
    }
    @Test
    public void testNotEqualsSingleVariable() {
        Expression expr1 = new Variable("ABC");
        Expression expr2 = new Variable("dABC");
        assertEquals(false, expr1.equals(expr2));
    }
    @Test
    // Multiply two constants
    public void testEqualsMultAndNumberCombined() {

        Expression expr1 = new Multiplication(new Number("30"), new Number("54"));
        Expression expr2 = new Multiplication(new Number("30"), new Number("54"));
        assertEquals(true, expr1.equals(expr2));
    }
    @Test
    // Multiply two variables
    public void testEqualsMultAndVarCombined() {

        Expression expr1 = new Multiplication(new Variable("ABCabc"), new Number("XYZxyz"));
        Expression expr2 = new Multiplication(new Variable("ABCabc"), new Number("XYZxyz"));
        assertEquals(true, expr1.equals(expr2));
    }
    @Test
    // Add two constants
    public void testEqualsAddAndNumberCombined() {

        Expression expr1 =  new Addition(new Number("393"), new Number("566"));
        Expression expr2 =  new Addition(new Number("393"), new Number("566"));
        assertEquals(true, expr1.equals(expr2));
    }
    @Test
    // Add two variables
    public void testEqualsAddAndVarCombined() {

        Expression expr1 =  new Addition(new Variable("var"), new Variable("varVAR"));
        Expression expr2 =  new Addition(new Variable("var"), new Variable("varVAR"));
        assertEquals(true, expr1.equals(expr2));
    }
    @Test
    // test a+b is not the same as b+a (for constants)
    public void testNotEqualsAddWithOrderSwappedNumbers() {

        Expression expr1 = new Addition(new Number("333"), new Number("55"));
        Expression expr2 = new Addition(new Number("55"), new Number("333"));
        assertEquals(false, expr1.equals(expr2));
    }
    @Test
    // test a+b is not the same as b+a (for variables)
    public void testNotEqualsAddWithOrderSwappedVariables() {

        Expression expr1 = new Addition(new Variable("ab"), new Variable("cd"));
        Expression expr2 = new Addition(new Variable("cd"), new Variable("ab"));
        assertEquals(false, expr1.equals(expr2));
    }
    @Test
    // test a*b is not the same as b*a
    public void testNotEqualsMultWithOrderSwappedNumbers() {

        Expression expr1 = new Multiplication(new Number("88"), new Number("55"));
        Expression expr2 = new Multiplication(new Number("55"), new Number("88"));
        assertEquals(false, expr1.equals(expr2));
    }
    @Test
    // test num1*(num2+num3)
    public void testEqualsInputAddMultAndNumberCombined() {

        Expression expr1 = new Multiplication(new Number("30"), 
                new Addition(new Number("100"),new Number("333")));
        Expression expr2 = new Multiplication(new Number("30"), 
                new Addition(new Number("100"),new Number("333")));
        assertEquals(true, expr1.equals(expr2));
    }
    @Test
    // test var1*(var2+var3)
    public void testEqualsInputAddMultAndVarCombined() {

        Expression expr1 = new Multiplication(new Variable("aaa"), 
                new Addition(new Variable("bbb"),new Variable("EEE")));
        Expression expr2 = new Multiplication(new Variable("aaa"), 
                new Addition(new Variable("bbb"),new Variable("EEE")));
        assertEquals(true, expr1.equals(expr2));
    }

    @Test
    // test to make sure that ((a+b)+c) is not structurally equal to (a+(b+c))
    public void testEqualsSwappedInputWithAddAndMult() {

        Expression expr1 = new Addition(new Variable("x"), new Addition(new Number("1"),new Number("2")));
        Expression expr2 = new Addition(new Addition(new Variable("x"), new Number("1")), new Number("2"));
        assertEquals(false, expr1.equals(expr2));
    }

    @Test
    // test a*(b+c) with one number changed
    public void negativeTestEqualsInputWithAddAndMult() {

        Expression expr1 = new Multiplication(new Number("30"), 
                new Addition(new Number("101"),new Number("400")));
        Expression expr2 = new Multiplication(new Number("30"), 
                new Addition(new Number("102"),new Number("400")));
        assertEquals(false, expr1.equals(expr2));
    }

    /*
     * *********************  hashCode() tests ********************************
     * The testing strategy is to make sure that all combinations of the 4 variants
     * (Addition, Multiplication, Constant and Variable) are tested
     *    Each expression will consist of
     *    	Only one type of variant 
     *    	Combinations of two variants from the above 4
     *    	Combinations of three variants from the above 4 
     *    	All 4 combinations
     *    Also multiple occurrences of same type of variants 
     *    string level comparisons done. So 2.0 != 2 and 2.00 != 2.0
     * 
     * For structural equality, order is important. So a+b != b+a
     *    there are test cases where order of operands will be swapped to test the above
     *       
     *    There will also be tests where one of the expressions will not be equal to the other
     *    by changing the value of one of the variants
     * Since expression objects can be created only with valid input, invalid inputs will not be tested
     */

    @Test
    //Testing numbers have same hashcode
    public void testHashCodeNumber() {
        Expression expr1 = new Number("233");
        Expression expr2 = new Number("233");
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing variables have same hashcode
    public void testHashCodeVariable() {
        Expression expr1 = new Variable("abc");
        Expression expr2 = new Variable("abc");
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing numbers that have different hashcode
    public void testNotEqualsHashCodeNumber() {
        Expression expr1 = new Number("233");
        Expression expr2 = new Number("243");
        assertEquals(false, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing variables that have different hashcode
    public void testNotEqualsHashCodeVariable() {
        Expression expr1 = new Variable("adbc");
        Expression expr2 = new Variable("abc");
        assertEquals(false, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing addition have same hashcodes
    public void testHashCodeAddNumbers() {
        Expression expr1 = new Addition(new Number("10.0"),new Number("14.0"));
        Expression expr2 = new Addition(new Number("10.0"),new Number("14.0"));
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing addition that have different hashcodes
    public void testNotEqualsHashCodeAddNumbers() {
        Expression expr1 = new Addition(new Number("100"),new Number("333"));
        Expression expr2 = new Addition(new Number("333"),new Number("100"));
        assertEquals(false, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing addition of variables
    public void testHashCodeAddVariables() {
        Expression expr1 = new Addition(new Variable("foo"),new Variable("bar"));
        Expression expr2 = new Addition(new Variable("foo"),new Variable("bar"));
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing multiplication of constants
    public void testHashCodeMultNumbers() {
        Expression expr1 = new Multiplication(new Number("3645"), new Number("4.5555"));
        Expression expr2 = new Multiplication(new Number("3645"), new Number("4.5555"));
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    //Testing multiplication of variables
    public void testHashCodeMultVariables() {
        Expression expr1 = new Multiplication(new Variable("foo"), new Variable("fooBAR"));
        Expression expr2 = new Multiplication(new Variable("foo"), new Variable("fooBAR"));
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    // testing addition of constant and variable
    public void testHashCodeAddNumAndVariables() {
        Expression expr1 = new Addition(new Variable("foo"),new Number("1122"));
        Expression expr2 = new Addition(new Variable("foo"),new Number("1122"));
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    // testing multiplication of constant and variable
    public void testHashCodeMultNumAndVariables() {
        Expression expr1 = new Multiplication(new Variable("foo"),new Number("1122"));
        Expression expr2 = new Multiplication(new Variable("foo"),new Number("1122"));
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    // Tests with all 4 (+,*,constant and var)
    public void testHashCodeAddMultNumAndVariables() {
        Expression expr1 = new Multiplication(new Variable("foo"),
                new Addition(new Variable("vvv"), new Number("1122")));
        Expression expr2 = new Multiplication(new Variable("foo"),
                new Addition(new Variable("vvv"), new Number("1122")));
        assertEquals(true, expr1.hashCode() == expr2.hashCode());
    }
    @Test
    // test to make sure that ((a+b)+c) is not structurally equal to (a+(b+c))
    public void testHashCodeSwappedParantheses() {
        Expression expr1 = 
                new Addition(new Variable("x"), new Addition(new Number("1"),new Number("2")));
        Expression expr2 =
                new Addition(new Addition(new Variable("x"), new Number("1")), new Number("2"));
        assertEquals(false, expr1.hashCode() == expr2.hashCode());
    }

    /*
     * *********************  differentiate tests ********************************
     * 
     * The testing strategy is to make sure that all combinations of the Addition, Multiplication, Number and 
     * Variable expressions are tested
     *    Only one type of expression where it makes sense (e.g multiplication can't be alone)
     *    Combinations of two expressions from the above 4
     *    Combinations of three expressions from the above 4 
     *    All 4 combinations
     *    Also multiple occurrences of same type of expression objects
     *    string level comparisons done. So 2.0 != 2 and 2.00 != 2.0
     * 
     * For structural equality, order is important. So a+b != b+a
     *    there are test cases where order of operands will be swapped to test the above
     *       
     *    There will also be tests where one of the expressions will not be equal to the other
     *    by changing the value of one of the variants
     * Since expression objects can be created only with valid input, invalid inputs will not be tested
     * 
     */

    @Test
    // Single constant
    public void testDifferentiateSingleNumber() {
        Expression expr1 =  new Number("3");
        Expression output = new Differentiator().differentiate(expr1, "x");
        String expectedOutput = "0";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Single variable differentiated against the same
    public void testDifferentiateSingleVariable() {
        Expression expr1 =  new Variable("xyz");
        Expression output = new Differentiator().differentiate(expr1, "xyz");
        String expectedOutput = "1";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Single variable differentiated against a different variable
    public void testDifferentiateSingleVariableNoMatch() {
        Expression expr1 =  new Variable("xyz");
        Expression output = new Differentiator().differentiate(expr1, "abx");
        String expectedOutput = "0";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Adding two constants
    public void testDifferentiateSimpleAddition() {
        Expression expr1 =
                new Addition(new Number("3"), new Number("5"));
        Expression output = new Differentiator().differentiate(expr1, "x");
        String expectedOutput = "0";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Adding two variables that match the differentiating variable
    public void testDifferentiateAddTwoVariables() {
        Expression expr1 =
                new Addition(new Variable("x"), new Variable("x"));
        Expression output = new Differentiator().differentiate(expr1, "x");
        String expectedOutput = "(1+1)";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Adding two variables where only one match with the differentiating variable
    public void testDifferentiateAddTwoVariablesOnlyMatch() {
        Expression expr1 =
                new Addition(new Variable("xyz"), new Variable("x"));
        Expression output = new Differentiator().differentiate(expr1, "x");
        String expectedOutput = "1";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Differentiate 30+100*foo w.r.t foo
    public void testDifferentiateAddMult() {
        Expression expr1 =
                new Addition(new Number("30"), new Multiplication(new Number("100"),new Variable("foo")));
        Expression output = new Differentiator().differentiate(expr1, "foo");
        String expectedOutput = "100";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Multiply var and floating point - Test 10.55*bar+30.5
    public void testDifferentiateAddMultfloatingPt() {
        Expression expr1 =
                new Addition(new Multiplication(new Number("10.55"), new Variable("bar")), new Number("30.5"));        
        Expression output = new Differentiator().differentiate(expr1, "bar");
        String expectedOutput = "10.55";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Multiply vars and floating point but differentiate against diff var- Test 10.55*bar+30.5
    public void testDifferentiateMultTwoConstantsAddVar() {
        Expression expr1 =
                new Addition(new Variable("bar"), new Multiplication(
                        new Multiplication(new Number("10.2"),new Number("90")), new Variable("foo")));
        Expression output = new Differentiator().differentiate(expr1, "foo");
        String expectedOutput = "(10.2*90)";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Test 30+(102.*90*foo)
    public void testDifferentiateMultTwoConstantsAddNum() {
        Expression expr1 =
                new Addition(new Number("30"), new Multiplication(
                        new Multiplication(new Number("10.2"),new Number("90")), new Variable("foo")));
        Expression output = new Differentiator().differentiate(expr1, "foo");
        String expectedOutput = "(10.2*90)";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Test (30*foo)+(10.2*90*foo)
    public void testDifferentiateMultipleOperandsSameVar() {
        Expression expr1 =
                new Addition(new Multiplication(new Number("30"),new Variable("foo")), new Multiplication(
                        new Multiplication(new Number("10.2"),new Number("90")), new Variable("foo")));
        Expression output = new Differentiator().differentiate(expr1, "foo");
        String expectedOutput = "(30+(10.2*90))";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
    @Test
    // Test (999*bar)+(102*90.99*foo) differentiate w.r.t foo
    public void testDifferentiateMultipleOperandsDiffVar() {
        Expression expr1 =
                new Addition(new Multiplication(new Number("999"),new Variable("bar")), new Multiplication(
                        new Multiplication(new Number("102"),new Number("90.99")), new Variable("foo")));
        Expression output = new Differentiator().differentiate(expr1, "foo");
        String expectedOutput = "(102*90.99)";
        assertEquals(true, expectedOutput.equals(output.toResult()));
    }
}
