package br.com.db1.passwordevaluator.businessrule.rule;

/**
 * Evaluates if the password has only letters disregarding whitespaces
 */
public class LettersOnly extends Rule {

  public LettersOnly(String password) {
    super("Letters Only", password);
  }

  /**
   * Count the number of letters if the password has only then
   */
  @Override
  protected Integer count() {
    return this.password.replaceAll("\\s+", "").matches("[a-zA-Z]+\\.?") ? this.password.length() : 0;
  }

  /**
   * @return -(n)
   */
  @Override
  protected Integer calculate() {
    return -(this.count);
  }

}
