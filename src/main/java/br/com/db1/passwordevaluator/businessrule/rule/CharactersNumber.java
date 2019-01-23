package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates the number of characters provided in the password
 */
public class CharactersNumber extends Rule {

  public CharactersNumber(String password) {
    super("Number of Characters", password);
  }

  /**
   * Count the number of characters in the password
   */
  @Override
  protected Integer count() {
    return this.password.length();
  }

  /**
   * @return +(n * 4)
   */
  @Override
  protected Integer calculate() {
    return +(this.count * 4);
  }

}
