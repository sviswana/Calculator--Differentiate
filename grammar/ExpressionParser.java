// Generated from Expression.g4 by ANTLR 4.0

package differentiator.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MULTIPLY=2, DOT=3, VARNAME=4, CONSTANT=5, LEFTP=6, RIGHTP=7, WS=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'+'", "'*'", "'.'", "VARNAME", "CONSTANT", "'('", "')'", 
		"WS"
	};
	public static final int
		RULE_line = 0, RULE_expr = 1, RULE_term = 2, RULE_factor = 3, RULE_rightp = 4, 
		RULE_leftp = 5, RULE_plus = 6, RULE_multiply = 7, RULE_variable = 8, RULE_number = 9;
	public static final String[] ruleNames = {
		"line", "expr", "term", "factor", "rightp", "leftp", "plus", "multiply", 
		"variable", "number"
	};

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	    // This method makes the lexer or parser stop running if it encounters
	    // invalid input and throw a RuntimeException.
	    public void reportErrorsAsExceptions() {
	        removeErrorListeners();
	        addErrorListener(new ExceptionThrowingErrorListener());
	    }
	    
	    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer,
	                Object offendingSymbol, int line, int charPositionInLine,
	                String msg, RecognitionException e) {
	            throw new RuntimeException(msg);
	        }
	    }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LineContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); expr();
			setState(21); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<PlusContext> plus() {
			return getRuleContexts(PlusContext.class);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public PlusContext plus(int i) {
			return getRuleContext(PlusContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); term();
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(24); plus();
				setState(25); term();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public MultiplyContext multiply(int i) {
			return getRuleContext(MultiplyContext.class,i);
		}
		public List<MultiplyContext> multiply() {
			return getRuleContexts(MultiplyContext.class);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); factor();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY) {
				{
				{
				setState(33); multiply();
				setState(34); factor();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public LeftpContext leftp() {
			return getRuleContext(LeftpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public RightpContext rightp() {
			return getRuleContext(RightpContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_factor);
		try {
			setState(47);
			switch (_input.LA(1)) {
			case CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); number();
				}
				break;
			case VARNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(42); variable();
				}
				break;
			case LEFTP:
				enterOuterAlt(_localctx, 3);
				{
				setState(43); leftp();
				setState(44); expr();
				setState(45); rightp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightpContext extends ParserRuleContext {
		public TerminalNode RIGHTP() { return getToken(ExpressionParser.RIGHTP, 0); }
		public RightpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRightp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRightp(this);
		}
	}

	public final RightpContext rightp() throws RecognitionException {
		RightpContext _localctx = new RightpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rightp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(RIGHTP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftpContext extends ParserRuleContext {
		public TerminalNode LEFTP() { return getToken(ExpressionParser.LEFTP, 0); }
		public LeftpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLeftp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLeftp(this);
		}
	}

	public final LeftpContext leftp() throws RecognitionException {
		LeftpContext _localctx = new LeftpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_leftp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(LEFTP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public PlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitPlus(this);
		}
	}

	public final PlusContext plus() throws RecognitionException {
		PlusContext _localctx = new PlusContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(PLUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyContext extends ParserRuleContext {
		public TerminalNode MULTIPLY() { return getToken(ExpressionParser.MULTIPLY, 0); }
		public MultiplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMultiply(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiply);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(ExpressionParser.VARNAME, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); match(VARNAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(ExpressionParser.CONSTANT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(CONSTANT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\n@\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!"+
		"\13\3\3\4\3\4\3\4\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\62\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2\f"+
		"\2\4\6\b\n\f\16\20\22\24\2\29\2\26\3\2\2\2\4\31\3\2\2\2\6\"\3\2\2\2\b"+
		"\61\3\2\2\2\n\63\3\2\2\2\f\65\3\2\2\2\16\67\3\2\2\2\209\3\2\2\2\22;\3"+
		"\2\2\2\24=\3\2\2\2\26\27\5\4\3\2\27\30\7\1\2\2\30\3\3\2\2\2\31\37\5\6"+
		"\4\2\32\33\5\16\b\2\33\34\5\6\4\2\34\36\3\2\2\2\35\32\3\2\2\2\36!\3\2"+
		"\2\2\37\35\3\2\2\2\37 \3\2\2\2 \5\3\2\2\2!\37\3\2\2\2\"(\5\b\5\2#$\5\20"+
		"\t\2$%\5\b\5\2%\'\3\2\2\2&#\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\7"+
		"\3\2\2\2*(\3\2\2\2+\62\5\24\13\2,\62\5\22\n\2-.\5\f\7\2./\5\4\3\2/\60"+
		"\5\n\6\2\60\62\3\2\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2\2\2\62\t\3\2\2"+
		"\2\63\64\7\t\2\2\64\13\3\2\2\2\65\66\7\b\2\2\66\r\3\2\2\2\678\7\3\2\2"+
		"8\17\3\2\2\29:\7\4\2\2:\21\3\2\2\2;<\7\6\2\2<\23\3\2\2\2=>\7\7\2\2>\25"+
		"\3\2\2\2\5\37(\61";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}