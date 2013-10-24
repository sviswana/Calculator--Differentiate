// Generated from Expression.g4 by ANTLR 4.0

package differentiator.grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MULTIPLY=2, DOT=3, VARNAME=4, CONSTANT=5, LEFTP=6, RIGHTP=7, WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'+'", "'*'", "'.'", "VARNAME", "CONSTANT", "'('", "')'", "WS"
	};
	public static final String[] ruleNames = {
		"PLUS", "MULTIPLY", "DOT", "VARNAME", "CONSTANT", "LEFTP", "RIGHTP", "WS"
	};


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


	public ExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 7: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\n\67\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\3\2\3\2\3\3\3\3\3\4\3\4\3\5\6\5\33\n\5\r\5\16\5\34\3\6\7\6 \n"+
		"\6\f\6\16\6#\13\6\3\6\5\6&\n\6\3\6\6\6)\n\6\r\6\16\6*\3\7\3\7\3\b\3\b"+
		"\3\t\6\t\62\n\t\r\t\16\t\63\3\t\3\t\2\n\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1"+
		"\r\b\1\17\t\1\21\n\2\3\2\4\4C\\c|\5\13\f\16\17\"\";\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\3\23\3\2\2\2\5\25\3\2\2\2\7\27\3\2\2\2\t\32\3\2\2\2\13!\3"+
		"\2\2\2\r,\3\2\2\2\17.\3\2\2\2\21\61\3\2\2\2\23\24\7-\2\2\24\4\3\2\2\2"+
		"\25\26\7,\2\2\26\6\3\2\2\2\27\30\7\60\2\2\30\b\3\2\2\2\31\33\t\2\2\2\32"+
		"\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\n\3\2\2\2\36"+
		" \4\62;\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#!"+
		"\3\2\2\2$&\5\7\4\2%$\3\2\2\2%&\3\2\2\2&(\3\2\2\2\')\4\62;\2(\'\3\2\2\2"+
		")*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\f\3\2\2\2,-\7*\2\2-\16\3\2\2\2./\7+\2"+
		"\2/\20\3\2\2\2\60\62\t\3\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\65\3\2\2\2\65\66\b\t\2\2\66\22\3\2\2\2\b\2\34!%*\63";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}