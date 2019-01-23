package br.com.db1.passwordevaluator.businessrule.rule;

import org.junit.Test;
import static org.junit.Assert.*;

public class RepeatCharactersTest {

  @Test
  public void testCount() {
    System.out.println("count");
    RepeatCharacters instance = new RepeatCharacters("ABC#@@1ax2$%ABA123");
    Integer expResult = 11;
    Integer result = instance.count();
    assertEquals(expResult, result);
  }

}
