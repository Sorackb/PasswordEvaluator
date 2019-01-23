package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharactersNumberTest {

  @Test
  public void testCount() {
    System.out.println("count");
    CharactersNumber instance = new CharactersNumber("ABC#@@1ax2$%ABA123");
    Integer expResult = 18;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

  @Test
  public void testCalculate() {
    System.out.println("calculate");
    CharactersNumber instance = new CharactersNumber("ABC#@@1ax2$%ABA123");
    instance.totalize();
    Integer expResult = 72;
    Integer result = instance.calculate();
    assertEquals(expResult, result);
  }

}
