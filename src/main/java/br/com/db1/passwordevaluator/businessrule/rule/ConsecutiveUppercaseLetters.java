package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the number of consecutive uppercase letters in the given password
 */
public class ConsecutiveUppercaseLetters extends Consecutive {

  public ConsecutiveUppercaseLetters(String password) {
    super("Consecutive Uppercase Letters", "[A-Z]", password);
  }
}
