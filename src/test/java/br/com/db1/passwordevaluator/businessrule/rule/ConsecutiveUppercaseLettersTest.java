package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConsecutiveUppercaseLettersTest {

  @Test
  public void testCount() {
    System.out.println("count");
    ConsecutiveUppercaseLetters instance = new ConsecutiveUppercaseLetters("ABC#@@1ax2$%ABA123");
    Integer expResult = 4;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    ConsecutiveUppercaseLetters instance = new ConsecutiveUppercaseLetters("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = -8;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
