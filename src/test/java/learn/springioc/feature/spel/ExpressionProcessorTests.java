package learn.springioc.feature.spel;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import learn.springioc.entity.Festival;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ExpressionProcessorTests {
	
	@Autowired
	ExpressionProcessor exprProcessor;

	@Test
	public void testSqlQuery() {
		String query = "select * from table where col1='#{#festival.name}' and col2=#{#festival.capacity}";
		Festival fest = new Festival("Tech Week", 100);
		String expected = "select * from table where col1='Tech Week' and col2=100";
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("festival", fest);
		assertEquals(expected, exprProcessor.process(query, dataMap));
	}
	
	
	
	@Test
	public void testSqlQuery2() {
		ExpressionParser parser = new SpelExpressionParser();
		Festival fest = new Festival("Nikola Tesla", 50);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("fest", fest);
		StandardEvaluationContext context = new StandardEvaluationContext();
		//context.setRootObject(fest);
//		context.setVariable("fest", fest);
		context.setVariables(dataMap);
		String name = parser.parseExpression("name of the festival is #{#fest.name} with capacity #{#fest.capacity}", new TemplateParserContext()).getValue(context, String.class);

		System.out.println(name); // Nikola Tesla

	}
	
	

}
