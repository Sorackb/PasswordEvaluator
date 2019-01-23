package br.com.db1.passwordevaluator.model;

import br.com.db1.passwordevaluator.businessrule.rule.Rule;
import java.util.List;

public class Report {

  private final List<Rule> rules;
  private Integer score;
  private Complexity complexity;

  public Report(List<Rule> rules) {
    this.rules = rules;
    this.totalize();
  }

  /**
   * Totalize the final score based in the defined rules
   */
  private void totalize() {
    Integer totalScore = 0;

    for (Rule rule : this.rules) {
      totalScore = totalScore + rule.getBonus();
    }

    if (totalScore > 100) {
      this.score = 100;
    } else if (totalScore < 0) {
      this.score = 0;
    } else {
      this.score = totalScore;
    }

    if (this.score >= 0 && this.score < 20) {
      this.complexity = Complexity.VERY_WEAK;
    } else if (this.score >= 20 && this.score < 40) {
      this.complexity = Complexity.WEAK;
    } else if (this.score >= 40 && this.score < 60) {
      this.complexity = Complexity.GOOD;
    } else if (this.score >= 60 && this.score < 80) {
      this.complexity = Complexity.STRONG;
    } else if (this.score >= 80 && this.score <= 100) {
      this.complexity = Complexity.VERY_STRONG;
    }
  }

  public List<Rule> getRules() {
    return this.rules;
  }

  public Integer getScore() {
    return this.score;
  }

  public Complexity getComplexity() {
    return this.complexity;
  }
}
