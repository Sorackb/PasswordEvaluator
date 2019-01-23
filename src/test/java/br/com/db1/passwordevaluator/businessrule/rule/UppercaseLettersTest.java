package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class UppercaseLettersTest {

  @Test
  public void testCount() {
    System.out.println("count");
    UppercaseLetters instance = new UppercaseLetters("ABC#@@1ax2$%ABA123");
    Integer expResult = 6;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    UppercaseLetters instance = new UppercaseLetters("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = 24;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
