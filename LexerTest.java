package differentiator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import differentiator.grammar.ExpressionLexer;

/**
 * 
 * Testing Strategy: Tests ensured that all aspects of the grammar were tested: variables, constants, addition, multiplication,
 * varying numbers of parentheses and white spaces. 
 * 
 * In general, simple tests were conducted first with a few numbers. Then larger inputs were tested with 
 * floating points as well as integers 
 * 
 * Also illegal inputs (like -, & etc) were tested to ensure that an exception was thrown
 */
public class LexerTest {

    @Test
    //Test one token
    public void testOneToken() {
        verifyLexer("+", new String[] {"+"});
    }
    @Test
    //Test constant
    public void testConstant() {
        verifyLexer("0", new String[] {"0"});
    }
    @Test
    //Test constant (large number)
    public void testLargeConstant() {
        verifyLexer("1234554321", new String[] {"1234554321"});
    }
    @Test
    //Test floating point number
    public void testFloatingPoint() {
        verifyLexer("3.1415", new String[] {"3.1415"});
    }
    @Test
    //Test variables
    public void testVariable() {
        verifyLexer("Foo", new String[] {"Foo"});
    }
    @Test
    //Test whitespaces 
    public void testSpaces() {
        verifyLexer("y +     12", new String[] {"y","+","12"});
    }
    @Test
    //Test parentheses
    public void testParantheses() {
        verifyLexer("((2)+4)", new String[] {"(","(","2",")","+","4",")"});
    }
    @Test
    //Test extra parentheses (but still balanced)
    public void testExtraParantheses() {
        verifyLexer("(((2))+4)", new String[] {"(","(","(","2",")",")","+","4",")"});
    }
    @Test
    // large input string with a mix of spaces, decimals, +, *, etc
    public void testLargeInput() {
        verifyLexer("((3.45+x ) + 22*foo + (.43 +x)) * (x*71*x)", new String[] {"(","(","3.45","+","x",")","+","22","*",
                "foo","+","(",".43","+","x",")",")","*","(","x","*","71","*","x",")"});
    }
    @Test
    // both large integer and floating point number tested
    public void testLargeNumber() {
        verifyLexer("1234567890*x + 1234.987654321*x*x", new String[] {"1234567890","*","x","+","1234.987654321","*","x","*","x"});
    }
    @Test
    //Test decimals (<1 without leading zero) at the start
    public void testDecimalWithBeginningDot() {
        verifyLexer(".456*x+.44*x", new String[] {".456","*","x","+",".44","*","x"});
    }
    @Test(expected = RuntimeException.class)
    //Testing illegal token such as '&', and catching exception
    public void testIllegalInputTestAlphaNumeric()
    {
        verifyLexer("x&y", new String[] {""});
    }

    @Test(expected = RuntimeException.class)
    //Testing illegal constant (like -23)
    public void testIllegalInputTestConstant()
    {
        verifyLexer("-23", new String[] {""});
    }

    public void verifyLexer(String input, String[] expectedTokens) {
        CharStream stream = new ANTLRInputStream(input);
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();
        List<? extends Token> actualTokens = lexer.getAllTokens();

        assertEquals(expectedTokens.length, actualTokens.size());

        for(int i = 0; i < actualTokens.size(); i++) {
            String actualToken = actualTokens.get(i).getText();
            String expectedToken = expectedTokens[i];
            assertEquals(actualToken, expectedToken);
        }
    }


}