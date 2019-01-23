package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the number of consecutive ocurrences in of given pattern
 */
public class Consecutive extends Rule {

  private final String pattern;

  /**
   * Constructor to be used as <strong>super(description, pattern,
   * password)</strong>
   *
   * @param description the description to be shown in the final report
   * @param pattern the pattern used to count the ocurrences
   * @param password the password to evaluate
   */
  public Consecutive(String description, String pattern, String password) {
    super(description, password);
    this.pattern = pattern;
  }

  /**
   * Count the number of consecutive ocurrences in the defined pattern
   */
  @Override
  protected Integer count() {
    Integer score = 0;
    Boolean last = false;
    char[] letters;

    String used = this.password.replaceAll("\\s+", "");
    letters = used.toCharArray();

    for (Integer index = 0; index < letters.length; index++) {
      String letter = String.valueOf(letters[index]);

      if (letter.matches(this.pattern)) {
        score = score + (last ? 1 : 0);
        last = true;
      } else {
        last = false;
      }
    }

    return score;
  }

  /**
   * @return -(n * 2)
   */
  @Override
  protected Integer calculate() {
    return -(this.count * 2);
  }
}
