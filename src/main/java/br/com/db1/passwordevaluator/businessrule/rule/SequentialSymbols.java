package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the ocurrence of symbols in sequence in the given password
 */
public class SequentialSymbols extends Sequential {

  public SequentialSymbols(String password) {
    super("Sequential Symbols (3+)", ")!@#$%^&*()", password);
  }
}
