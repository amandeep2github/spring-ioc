package learn.springioc.feature.spel;

import java.util.Map;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class ExpressionProcessor {
	public String process(String template, Map<String, Object> dataMap){
		SpelExpressionParser expParser = new SpelExpressionParser();
		Expression expr = expParser.parseExpression(template, new TemplateParserContext());
		StandardEvaluationContext stdEvalCtx = new StandardEvaluationContext();
		stdEvalCtx.setVariables(dataMap);
		return expr.getValue(stdEvalCtx, String.class);
		
	}
	
}
