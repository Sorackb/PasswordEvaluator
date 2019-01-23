package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConsecutiveNumbersTest {

  @Test
  public void testCount() {
    System.out.println("count");
    ConsecutiveNumbers instance = new ConsecutiveNumbers("ABC#@@1ax2$%ABA123");
    Integer expResult = 2;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    ConsecutiveNumbers instance = new ConsecutiveNumbers("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = -4;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
