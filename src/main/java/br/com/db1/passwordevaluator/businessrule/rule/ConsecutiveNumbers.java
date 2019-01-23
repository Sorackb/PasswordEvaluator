package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the number of consecutive numbers in the given password
 */
public class ConsecutiveNumbers extends Consecutive {

  public ConsecutiveNumbers(String password) {
    super("Consecutive Numbers", "[0-9]", password);
  }
}
