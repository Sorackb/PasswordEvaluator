package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the ocurrence of numbers in sequence in the given password
 */
public class SequentialNumbers extends Sequential {

  public SequentialNumbers(String password) {
    super("Sequential Numbers (3+)", "01234567890", password);
  }
}
