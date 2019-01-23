package br.com.db1.passwordevaluator.businessrule.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Evaluates the ocurrence of numbers in the given password
 */
public class Numbers extends Rule {

  public static final Pattern NUMBERS = Pattern.compile("[0-9]");

  public Numbers(String password) {
    super("Numbers", password);
  }

  /**
   * Count the ocurrence of numbers
   */
  @Override
  protected Integer count() {
    Matcher matcher = NUMBERS.matcher(this.password);
    Integer score = 0;

    while (matcher.find()) {
      score++;
    }

    return score;
  }

  /**
   * @return +(n * 4);
   */
  @Override
  protected Integer calculate() {
    return +(this.count * 4);
  }

}
