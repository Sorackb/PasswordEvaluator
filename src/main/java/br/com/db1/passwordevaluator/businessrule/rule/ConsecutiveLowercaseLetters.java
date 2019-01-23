package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the number of consecutive lowercase letters in the given password
 */
public class ConsecutiveLowercaseLetters extends Consecutive {

  public ConsecutiveLowercaseLetters(String password) {
    super("Consecutive Lowercase Letters", "[a-z]", password);
  }

}
