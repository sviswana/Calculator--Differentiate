package differentiator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Console user interface. You should not need to modify this. */
public class Main {
    /**
     * Repeatedly reads expressions from the console, and outputs the results of
     * differentiating them. Inputting an empty line will terminate the program.
     * @param args unused
     */
    public static void main(String[] args) throws IOException {
        String result;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String expression;
        do {
            // display prompt
            System.out.print("$ ");
            // read input
            expression = in.readLine();
            // terminate if input empty
            if (!expression.equals("")) {
                try {
                    DifferentiatorInterface diff = new Differentiator();
                    result = diff.apply(expression, "x");
                    System.out.println(result);
                } catch (RuntimeException re) {
                    System.err.println(re.getClass().getName() + ": " + re.getMessage());
                }
            }
        } while (!expression.equals(""));
    }
}