package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates if the password has only numbers disregarding whitespaces
 */
public class NumbersOnly extends Rule {

  public NumbersOnly(String password) {
    super("Numbers Only", password);
  }

  /**
   * Count the ocurrences of numbers if the password has only then
   */
  @Override
  protected Integer count() {
    return this.password.replaceAll("\\s+", "").matches("[0-9]+\\.?") ? password.length() : 0;
  }

  /**
   * @return -(n)
   */
  @Override
  protected Integer calculate() {
    return -(this.count);
  }

}
