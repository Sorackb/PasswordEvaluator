package br.com.db1.passwordevaluator.businessrule.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Evaluates the number of uppercase letters in the given password
 */
public class UppercaseLetters extends Rule {

  public static final Pattern UPPER = Pattern.compile("[A-Z]");

  public UppercaseLetters(String password) {
    super("Uppercase Letters", password);
  }

  /**
   * Count the number of uppercase letters
   */
  @Override
  protected Integer count() {
    Matcher matcher = UPPER.matcher(this.password);
    Integer score = 0;

    while (matcher.find()) {
      score++;
    }

    return score;
  }

  /**
   * @return <strong>+((len - n) * 2)</strong> if <strong>n > 0</strong>
   */
  @Override
  protected Integer calculate() {
    if (this.count > 0) {
      return +((this.password.length() - this.count) * 2);
    } else {
      return 0;
    }
  }

}
