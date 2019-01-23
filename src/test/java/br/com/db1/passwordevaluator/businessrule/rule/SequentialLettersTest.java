package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class SequentialLettersTest {

  @Test
  public void testCount() {
    System.out.println("count");
    SequentialLetters instance = new SequentialLetters("ABC#@@1ax2$%ABA123");
    Integer expResult = 1;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    SequentialLetters instance = new SequentialLetters("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = -3;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
