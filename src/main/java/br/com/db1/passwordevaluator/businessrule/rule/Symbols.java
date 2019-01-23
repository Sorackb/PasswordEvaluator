package br.com.db1.passwordevaluator.businessrule.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Evaluates the ocurrence of symbols in the given password
 */
public class Symbols extends Rule {

  public static final Pattern SYMBOLS = Pattern.compile("[^a-zA-Z0-9_ ]");

  public Symbols(String password) {
    super("Symbols", password);
  }

  /**
   * Count the ocurrence of symbols
   */
  @Override
  protected Integer count() {
    Matcher matcher = SYMBOLS.matcher(this.password);
    Integer score = 0;

    while (matcher.find()) {
      score++;
    }

    return score;
  }

  /**
   * @return +(n * 6);
   */
  @Override
  protected Integer calculate() {
    return +(this.count * 6);
  }

}
