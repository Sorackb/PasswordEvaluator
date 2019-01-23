package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the number of sequential ocurrences in of given sequence
 */
public abstract class Sequential extends Rule {

  private final String sequence;

  /**
   * Constructor to be used as <strong>super(description, pattern,
   * password)</strong>
   *
   * @param description the description to be shown in the final report
   * @param sequence the sequence used to count the ocurrences
   * @param password the password to evaluate
   */
  public Sequential(String description, String sequence, String password) {
    super(description, password);
    this.sequence = sequence;
  }

  /**
   * Count the number of sequence (3+) in the given sequence
   */
  @Override
  protected Integer count() {
    Integer score = 0;
    Integer step = 3;

    for (Integer index = 0; index < this.sequence.length() - step; index++) {
      String part = this.sequence.substring(index, index + step);
      String partReverse = new StringBuilder(part).reverse().toString();

      if (this.password.toLowerCase().contains(part) || this.password.toLowerCase().contains(partReverse)) {
        score++;
      }
    }

    return score;
  }

  /**
   * @return -(n * 3);
   */
  @Override
  protected Integer calculate() {
    return -(this.count * 3);
  }
}
