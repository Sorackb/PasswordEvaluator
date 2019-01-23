package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class MiddleNumbersOrSymbolsTest {

  @Test
  public void testCount() {
    System.out.println("count");
    MiddleNumbersOrSymbols instance = new MiddleNumbersOrSymbols("ABC#@@1ax2$%ABA123");
    Integer expResult = 9;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    MiddleNumbersOrSymbols instance = new MiddleNumbersOrSymbols("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = 18;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
