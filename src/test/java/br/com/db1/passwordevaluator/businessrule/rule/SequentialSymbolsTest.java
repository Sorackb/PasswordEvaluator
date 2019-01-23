package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class SequentialSymbolsTest {

  @Test
  public void testCount() {
    System.out.println("count");
    SequentialSymbols instance = new SequentialSymbols("ABC#@@1ax2$%ABA123");
    Integer expResult = 0;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    SequentialSymbols instance = new SequentialSymbols("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = 0;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
