// Generated from Expression.g4 by ANTLR 4.0

package differentiator.grammar;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExpressionListener extends ParseTreeListener {
	void enterPlus(ExpressionParser.PlusContext ctx);
	void exitPlus(ExpressionParser.PlusContext ctx);

	void enterTerm(ExpressionParser.TermContext ctx);
	void exitTerm(ExpressionParser.TermContext ctx);

	void enterLeftp(ExpressionParser.LeftpContext ctx);
	void exitLeftp(ExpressionParser.LeftpContext ctx);

	void enterLine(ExpressionParser.LineContext ctx);
	void exitLine(ExpressionParser.LineContext ctx);

	void enterNumber(ExpressionParser.NumberContext ctx);
	void exitNumber(ExpressionParser.NumberContext ctx);

	void enterMultiply(ExpressionParser.MultiplyContext ctx);
	void exitMultiply(ExpressionParser.MultiplyContext ctx);

	void enterExpr(ExpressionParser.ExprContext ctx);
	void exitExpr(ExpressionParser.ExprContext ctx);

	void enterRightp(ExpressionParser.RightpContext ctx);
	void exitRightp(ExpressionParser.RightpContext ctx);

	void enterFactor(ExpressionParser.FactorContext ctx);
	void exitFactor(ExpressionParser.FactorContext ctx);

	void enterVariable(ExpressionParser.VariableContext ctx);
	void exitVariable(ExpressionParser.VariableContext ctx);
}