// Generated from Expression.g4 by ANTLR 4.0

package differentiator.grammar;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class ExpressionBaseListener implements ExpressionListener {
	@Override public void enterPlus(ExpressionParser.PlusContext ctx) { }
	@Override public void exitPlus(ExpressionParser.PlusContext ctx) { }

	@Override public void enterTerm(ExpressionParser.TermContext ctx) { }
	@Override public void exitTerm(ExpressionParser.TermContext ctx) { }

	@Override public void enterLeftp(ExpressionParser.LeftpContext ctx) { }
	@Override public void exitLeftp(ExpressionParser.LeftpContext ctx) { }

	@Override public void enterLine(ExpressionParser.LineContext ctx) { }
	@Override public void exitLine(ExpressionParser.LineContext ctx) { }

	@Override public void enterNumber(ExpressionParser.NumberContext ctx) { }
	@Override public void exitNumber(ExpressionParser.NumberContext ctx) { }

	@Override public void enterMultiply(ExpressionParser.MultiplyContext ctx) { }
	@Override public void exitMultiply(ExpressionParser.MultiplyContext ctx) { }

	@Override public void enterExpr(ExpressionParser.ExprContext ctx) { }
	@Override public void exitExpr(ExpressionParser.ExprContext ctx) { }

	@Override public void enterRightp(ExpressionParser.RightpContext ctx) { }
	@Override public void exitRightp(ExpressionParser.RightpContext ctx) { }

	@Override public void enterFactor(ExpressionParser.FactorContext ctx) { }
	@Override public void exitFactor(ExpressionParser.FactorContext ctx) { }

	@Override public void enterVariable(ExpressionParser.VariableContext ctx) { }
	@Override public void exitVariable(ExpressionParser.VariableContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}