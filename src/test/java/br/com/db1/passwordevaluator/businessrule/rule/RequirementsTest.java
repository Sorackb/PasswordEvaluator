package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class RequirementsTest {

  @Test
  public void testCount() {
    System.out.println("count");
    Requirements instance = new Requirements("ABC#@@1ax2$%ABA123");
    Integer expResult = 5;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    Requirements instance = new Requirements("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = 10;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
