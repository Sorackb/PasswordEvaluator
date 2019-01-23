package br.com.db1.passwordevaluator.businessrule.rule;

public abstract class Rule {

  protected final String description;
  protected final String password;
  protected Integer count;
  protected Integer bonus;

  /**
   * @return the number of ocurrences of the rule
   */
  protected abstract Integer count();

  /**
   * calculates the score based in the rate
   *
   * @return the final score of the password applied to the rule
   */
  protected abstract Integer calculate();

  public Rule(String description, String password) {
    this.description = description;
    this.password = password;
  }

  public void totalize() {
    this.count = this.count();
    this.bonus = this.calculate();
  }

  public String getDescription() {
    return this.description;
  }

  public Integer getCount() {
    return this.count;
  }

  public Integer getBonus() {
    return this.bonus;
  }
}
