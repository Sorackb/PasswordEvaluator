package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluate considering the minimum requirements
 * <ul>
 *   <li>Minimum 8 characters in length</li>
 *   <li>Contains 3/4 of the following items:</li>
 *   <ul>
 *     <li>Uppercase Letters</li>
 *     <li>Lowercase Letters</li>
 *     <li>Numbers</li>
 *     <li>Symbols</li>
 *   </ul>   
 * </ul>
 */
public class Requirements extends Rule {

  public Requirements(String password) {
    super("Requirements", password);
  }

  /**
   * Totalize the bonus only if the characters lenght and at least 3 of the
   * secondary requirements are satisfied
   */
  @Override
  public void totalize() {
    this.count = this.count();
    this.bonus = 0;

    if (this.password.length() >= 8 && this.count >= 4) {
      this.bonus = this.calculate();
    }
  }

  /**
   * Computes 1 for each satisfied requirement
   */
  @Override
  protected Integer count() {
    Integer score = 0;

    score = score + (this.password.length() >= 8 ? 1 : 0);
    score = score + (UppercaseLetters.UPPER.matcher(this.password).find() ? 1 : 0);
    score = score + (LowercaseLetters.LOWER.matcher(this.password).find() ? 1 : 0);
    score = score + (Numbers.NUMBERS.matcher(this.password).find() ? 1 : 0);
    score = score + (Symbols.SYMBOLS.matcher(this.password).find() ? 1 : 0);

    return score;
  }

  /**
   * @return +(n * 2)
   */
  @Override
  protected Integer calculate() {
    return +(this.count * 2);
  }

}
