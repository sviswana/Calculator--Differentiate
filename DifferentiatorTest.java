package differentiator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is the test suite for Differentiator class. 
 * It contains test suites for 2 functions
 *      Differentiator.apply()
 *      Differentiator.parse()
 * 
 */
public class DifferentiatorTest {

    /*
     **************   Testing Strategy for Differentiator.apply() ****************
     * 
     * The testing strategy is to make sure that all combinations of the 4 variants
     * Constants, Variables, Additions, and Multiplications are tested against a 
     * differentiating variable (we will call it x)
     *    Only one type of variant against x 
     *    Combinations of two variants from the above 4 against x
     *    Combinations of three variants from the above 4  against x
     *    All 4 variants  against x
     *    Also multiple occurrences of same type of variants (2 or more additions, multiplication etc)
     *    Changing the differentiating variable x to either match the variant variable or not
     *    
     * Constant values tested
     *    values = { 0, 1, large_value}
     * Variable values tested
     *    values = { 'x', 'X', combination of lower&upper case alphabets, large string}
     * differentiating variable values tested         
     *    values = { 'x', 'X', combination of lower&upper case alphabets, large string}
     *
     * Many different groupings of numbers, constants, add and multiply operators will be tested with
     * grouped parenthesis
     * 
     * Extra parentheses (while still being balanced) will be tested
     * 
     * Also, different number of white spacing between constants/variables and operators
     * will be tested. These tests will be mixed with the inputs mentioned in above tests
     *    
     *  Testing order of operator precedence where we test a+b*c is same as a+(b*c)
     *  
     *  We will also test for following invalid inputs that would lead to parsing errors and
     *  throw exceptions
     *  Constants
     *    Incorrect floating points - multiple decimal points, exponent E
     *    negative number
     *    Presence of alphabets while at least the first character is a digit 
     *  Variable
     *    Presence of numerals and alphanumeric characters after the first character (which is alphabet)
     *  Operators
     *    Consecutive presence of more than one + or * operators
     *    Invalid operators like '/'
     *  Parenthesis
     *    Missing right or left parenthesis , empty set within ()
     *
     */ 
    @Test
    // Single variable
    public void testDifferentiateSingleVariable() {
        String input = "x";
        String variable = "x";
        assertEquals("1", new Differentiator().apply(input, variable));
    }
    @Test
    // Single large variable
    public void testDifferentiateSingleLargeVariable() {
        String input = "abcdefghijklmmno";
        String variable = "abcdefghijklmmno";
        assertEquals("1", new Differentiator().apply(input, variable));
    }
    @Test
    // Single large variable with mixed cases
    public void testDifferentiateSingleLargeVariableMixedCase() {
        String input = "FooBarAbCDef";
        String variable = "FooBarAbCDef";
        assertEquals("1", new Differentiator().apply(input, variable));
    }
    @Test
    // Single variable (Upper case X differentiated against lower case x)
    public void testDifferentiateSingleUpperCaseVariable() {
        String input = "X";
        String variable = "x";
        assertEquals("0", new Differentiator().apply(input, variable));
    }
    @Test
    // Single number
    public void testDifferentiateSingleNumber() {
        String input = "100";
        String variable = "x";
        assertEquals("0", new Differentiator().apply(input, variable));
    }
    @Test
    // Number=0
    public void testDifferentiateNumberValueZero() {
        String input = "0*x";
        String variable = "x";
        assertEquals("0", new Differentiator().apply(input, variable));
    }
    @Test
    // Number=1
    public void testDifferentiateNumberValueOne() {
        String input = "1*x";
        String variable = "x";
        assertEquals("1", new Differentiator().apply(input, variable));
    }
    @Test
    // large Number
    public void testDifferentiateLargeNumber() {
        String input = "11223344556 * x";
        String variable = "x";
        assertEquals("11223344556", new Differentiator().apply(input, variable));
    }
    @Test
    // Addition of two constants
    public void testDifferentiateAddTwoConstants() {
        String input = "22+44";
        String variable = "x";
        assertEquals("0", new Differentiator().apply(input, variable));
    }
    @Test
    // Addition of same two variables as the differentiating variable
    public void testDifferentiateAddTwoSameVariables() {
        String input = "bar+bar";
        String variable = "bar";
        assertEquals("(1+1)", new Differentiator().apply(input, variable));
    }
    @Test
    // Addition of two variables only one of which matches the differentiating var
    public void testDifferentiateAddTwoDifferentVariables() {
        String input = "bar+foo";
        String variable = "bar";
        assertEquals("1", new Differentiator().apply(input, variable));
    }
    @Test
    // multiplying two constants  
    public void testDifferentiateMultTwoConstants() {
        String input = "23 * 44.5";
        String variable = "x";
        assertEquals("0", new Differentiator().apply(input, variable));
    }
    @Test
    // multiplying two variables (same as differentiating var)
    public void testDifferentiateMultTwoSameVariables() {
        String input = "bar*bar";
        String variable = "bar";
        assertEquals("(bar+bar)", new Differentiator().apply(input, variable));
    }
    @Test
    // multiplication of two variables only one of which matches the differentiating var
    public void testDifferentiateMultTwoDiffVariables() {
        String input = "bar*  foo";
        String variable = "bar";
        assertEquals("foo", new Differentiator().apply(input, variable));
    }
    @Test
    // combinations of add and multiply
    public void testDifferentiateAddAndMult() {
        String input = "2*x+2*x";
        String variable = "x";
        assertEquals("(2+2)", new Differentiator().apply(input, variable));
    }
    @Test
    // Testing large integers
    public void testDifferentiateAddAndMultLargeIntegers() {
        String input = "1234567890 * x + 9876543210123 *x";
        String variable = "x";
        assertEquals("(1234567890+9876543210123)", new Differentiator().apply(input, variable));
    }
    @Test
    // Testing floating point with a lot of significant digits
    public void testDifferentiateAddAndMultLargeFloatingPoints() {
        String input = "1.234567890121 * ABC + 0.9876543210123 *ABC";
        String variable = "ABC";
        assertEquals("(1.234567890121+0.9876543210123)", new Differentiator().apply(input, variable));
    }
    @Test
    // addition and multiplication with different variables
    public void testDifferentiateAddAndMultDiffVar() {
        String input = "72*xyz + 25*  abc";
        String variable = "abc";
        assertEquals("25", new Differentiator().apply(input, variable));
    }
    @Test
    // many multiply operations in the same group
    public void testDifferentiateManyMultiplications() {
        String input = "(2*x*x)*(4*x)";
        String variable = "x";
        assertEquals("(((2*(x+x))*(4*x))+((2*(x*x))*4))", new Differentiator().apply(input, variable));
    }
    @Test
    // many add operations in the same group
    public void testDifferentiateManyAdditions() {
        String input = "(24 +   4.35 +7)* y + (( 5 + y))";
        String variable = "y";
        assertEquals("((24+(4.35+7))+1)", new Differentiator().apply(input, variable));
    }
    @Test
    // testing default operator precedence (a+b*c) == (a+(b*c))
    public void testDifferentiateOperatorPrecedence1() {
        String input = "(2 + 5 * 7 + 4) * foo";
        String variable = "foo";
        assertEquals("(2+((5*7)+4))", new Differentiator().apply(input, variable));
    }
    @Test
    // More testing default operator precedence (a+b*c) == (a+(b*c)) with floating pt
    public void testDifferentiateOperatorPrecedence2() {
        String input = "(22 +     799999 *7 + .999) * foo * foo + 9";
        String variable = "foo";
        assertEquals("((22+((799999*7)+.999))*(foo+foo))", new Differentiator().apply(input, variable));
    }
    @Test
    //Extra parentheses 
    public void testDifferentiateParentheses1() {
        String input = "(((z)))";
        String variable = "z";
        assertEquals("1", new Differentiator().apply(input, variable));
    }
    @Test
    //Extra parentheses with add operators and mixed case variables
    public void testDifferentiateParentheses2() {
        String input = "((((22)))+(((((99)))))) * BaR + BAR";
        String variable = "BaR";
        assertEquals("(22+99)", new Differentiator().apply(input, variable));
    }

    /*
     * *****  All the tests below focus on catching errors from incorrect input ***
     */
    @Test(expected=RuntimeException.class)
    //Missing Right Parentheses
    public void testDifferentiateMissingRightParens() {
        String input = "((x+3)";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    //Extra right Parentheses
    public void testDifferentiateExtraRightParens() {
        String input = "(x*3)))";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    // empty set in ()
    public void testDifferentiateEmptySet() {
        String input = "() + x";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    //Only multiply operator present
    public void testDifferentiateOnlyMultiplyOp() {
        String input = "*";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    //Only plus operator present
    public void testDifferentiateOnlyPlusOp() {
        String input = "+";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    //Missing operators between number and variable
    public void testDifferentiateMissingOperator() {
        String input = "3*42 x";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    //Multiple operators together without constants/variables in between
    public void testDifferentiateMultipleOperatorsTogether() {
        String input = "3 ++ 42 + x";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    // Incorrect floating point numbers (2 decimal points in a number)
    public void testDifferentiateIncorrectFloatingPointNumber() {
        String input = "3 + 44.55.666 + x";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    // Incorrect floating point numbers (Exponent not supported)
    public void testDifferentiateIncorrectFloatingPointNumberWithExp() {
        String input = "3 + 4.5E12 + x";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    // Incorrect variable names (numerals in variable names)
    public void testDifferentiateIncorrectVarNme() {
        String input = "3 + x1 ";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    // Alphanumeric values in variable name
    public void testDifferentiateAplhaNumericInVar() {
        String input = "23 * x + x%2";
        String variable = "x";
        new Differentiator().apply(input, variable);
    }
    @Test(expected=RuntimeException.class)
    // -ve number
    public void testDifferentiateNegativeNumber() {
        String input = "-23 * dx";
        String variable = "dx";
        new Differentiator().apply(input, variable);
    }

    /*
     * *************     Testing Strategy for Differentiator.parse()  ********** 
     * 
     * The testing strategy is to make sure that all combinations of the 4 variants
     * Constants, Variables, Additions, and Multiplications are tested 
     * 
     * The test expression would contain
     *    Only one type of variant 
     *    Combinations of two variants 
     *    Combinations of three variants  
     *    All 4 variants
     *    Also multiple occurrences of same type of variants (2 or more additions, multiplication etc)
     *    
     * Values tested for the variants   
     *    Constant values tested
     *       values = { 0, 1, large_value}
     *    Variable values tested
     *       values = { single_letter in both lower&upper cases, 
     *           combination of lower&upper case alphabets, large string}
     *
     * Many different groupings of constants, Variables, and operators (add and multiply)
     * tested with grouped parenthesis
     * 
     * Extra parentheses while still being balanced are also tested
     * 
     * Also, different number of white spacing between constants/variables and operators
     * will be tested. These tests will be mixed with the inputs mentioned above 
     *    
     * Order of operator precedence will be tested. i.e. a+b*c should be parsed as (a+(b*c))
     *    
     * We will also test for invalid input that would lead to parsing errors and
     * throw exceptions
     * Constants
     *    Incorrect floating points - multiple decimal points, exponent E
     *    negative number
     *    Presence of alphabets while at least the first character is a digit 
     * Variable
     *    Presence of numerals and alphanumeric characters after the first character (which is alphabet)
     * Operators
     *    Consecutive presence of more than one + or * operators
     * Parenthesis
     *    Missing right or left parenthesis , empty set within ()
     * 
     */ 

    @Test
    // test constant of value zero
    public void testParseSingleNumberValue0() {
        String inputExpr = "0";
        String expectedOutput = "0";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // test constant of value one
    public void testParseSingleNumberValue1() {
        String inputExpr = "1";
        String expectedOutput = "1";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // test constant of large value
    public void testParseSingleNumberLargeValue() {
        String inputExpr = "1345267890";
        String expectedOutput = "1345267890";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Test floating point number 
    public void testParseFloatingPoint() {
        String inputExpr = "322.256";
        String expectedOutput = "322.256";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // test floating point# with only decimals 
    public void testParseOnlyDecimal() {
        String inputExpr = ".25645303";
        String expectedOutput = ".25645303";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Test variable with one character (upper case)
    public void testParseOnlyVariableOneCharUpperCase() {
        String inputExpr = "M";
        String expectedOutput = "M";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Test variable with one character (lower case)
    public void testParseOnlyVariableOneCharLowerCase() {
        String inputExpr = "m";
        String expectedOutput = "m";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Test variable with large number of characters (both cases mixed) 
    public void testParseVariableManyChars() {
        String inputExpr = "AaBbCcDdEeFfGgZz";
        String expectedOutput = "AaBbCcDdEeFfGgZz";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Test many plus operators
    public void testParseManyPlusOps() {
        String inputExpr = "(3+5+7+  9+111) + (22.33 + 99+ 20000 + .444)";
        String expectedOutput = "((3+(5+(7+(9+111))))+(22.33+(99+(20000+.444))))";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Test many multiply operators
    public void testParseManyMultiplyOps() {
        String inputExpr = "30.3 *400*50004 *99";
        String expectedOutput = "(30.3*(400*(50004*99)))";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Input contains a mix of +, *, decimals and variables, 
    public void testParseMixedInput() {
        String inputExpr = "2.5 + x*5 + (foo + bar+.5)*x";
        String expectedOutput = "(2.5+((x*5)+((foo+(bar+.5))*x)))";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Input contains extra parentheses but balanced
    public void testParseExtraParentheses() {
        String inputExpr = "(2+(3+(((4+x)))))";
        String expectedOutput = "(2+(3+(4+x)))";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Input contains large numbers, +, *
    public void testParseLargeInputNumbersAndOps() {
        String inputExpr = "x + ( 1234512345 + 999999999.1234 ) * x";
        String expectedOutput = "(x+((1234512345+999999999.1234)*x))";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }
    @Test
    // Input contains series of multiplications with numbers and variables
    public void testParseSeriesMultiplications() {
        String inputExpr = "foo *x*  bar *123408";
        String expectedOutput = "(foo*(x*(bar*123408)))";
        Differentiator d = new Differentiator();
        assertEquals(expectedOutput, d.parse(inputExpr).toString());
    }

    /*
     * *****  All the tests below focus on catching errors from incorrect input ***
     */
    @Test(expected=RuntimeException.class)
    //Missing Parentheses
    public void testParseMissingLeftParens() {
        String inputExpr = "(x*3)))";
        Differentiator d = new Differentiator();
        d.parse(inputExpr).toString();
    }
    @Test(expected=RuntimeException.class)
    // input contains empty set ()
    public void testParseEmptySet() {
        String inputExpr = "2 +()";
        Differentiator d = new Differentiator();
        d.parse(inputExpr).toString();
    }
    @Test(expected=RuntimeException.class)
    // Sequence of consecutive Operators
    public void testParseCombinedOperators() {
        String inputExpr = "x ** 5)";
        Differentiator d = new Differentiator();
        d.parse(inputExpr).toString();
    }
    @Test(expected=RuntimeException.class)
    // Illegal Operators
    public void testParseIllegalOperators() {
        String inputExpr = "x-4";
        Differentiator d = new Differentiator();
        d.parse(inputExpr).toString();
    }
    @Test(expected=RuntimeException.class)
    // Invalid variable names 
    public void testParseInvalidVariableNames() {
        String inputExpr = "20 + abc12";
        Differentiator d = new Differentiator();
        d.parse(inputExpr).toString();
    }
    @Test(expected=RuntimeException.class)
    // Invalid Constants 
    public void testParseInvalidConstants() {
        String inputExpr = "20ab + 300";
        Differentiator d = new Differentiator();
        d.parse(inputExpr).toString();
    }
    @Test(expected=RuntimeException.class)
    // Invalid Exponent in floating point 
    public void testParseInvalidConstantsFp() {
        String inputExpr = "2.34E7";
        Differentiator d = new Differentiator();
        d.parse(inputExpr).toString();
    }
}
