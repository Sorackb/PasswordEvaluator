package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the number of ocurrences of symbols and numbers in the middle of
 * the given password
 */
public class MiddleNumbersOrSymbols extends Rule {

  public MiddleNumbersOrSymbols(String password) {
    super("Middle Numbers or Symbols", password);
  }

  /**
   * Count the number of ocurrences of symbols and numbers in the middle of the
   * given password
   */
  @Override
  protected Integer count() {
    char[] letters = this.password.toCharArray();
    Integer score = 0;

    for (int index = 1; index < letters.length - 1; index++) {
      Character letter = letters[index];

      if (Numbers.NUMBERS.matcher(letter.toString()).matches() || Symbols.SYMBOLS.matcher(letter.toString()).matches()) {
        score++;
      }
    }

    return score;
  }

  /**
   * @return +(n * 2);
   */
  @Override
  protected Integer calculate() {
    return +(this.count * 2);
  }

}
