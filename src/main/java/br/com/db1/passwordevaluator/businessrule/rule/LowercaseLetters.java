package br.com.db1.passwordevaluator.businessrule.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Evaluates the number of lowercase letters in the given password
 */
public class LowercaseLetters extends Rule {

  public static final Pattern LOWER = Pattern.compile("[a-z]");

  public LowercaseLetters(String password) {
    super("Lowercase Letters", password);
  }

  /**
   * Count the number of lowercase letters
   */
  @Override
  protected Integer count() {
    Matcher matcher = LOWER.matcher(this.password);
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
