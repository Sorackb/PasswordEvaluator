package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the ocurrence of letters in sequence in the given password
 */
public class SequentialLetters extends Sequential {

  public SequentialLetters(String password) {
    super("Sequential Letters (3+)", "abcdefghijklmnopqrstuvwxyz", password);
  }
}
