package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class LowercaseLettersTest {

  @Test
  public void testCount() {
    System.out.println("count");
    LowercaseLetters instance = new LowercaseLetters("ABC#@@1ax2$%ABA123");
    Integer expResult = 2;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    LowercaseLetters instance = new LowercaseLetters("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = 32;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
