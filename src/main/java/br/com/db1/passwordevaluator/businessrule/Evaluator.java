package br.com.db1.passwordevaluator.businessrule;

import br.com.db1.passwordevaluator.model.Report;
import br.com.db1.passwordevaluator.businessrule.rule.CharactersNumber;
import br.com.db1.passwordevaluator.businessrule.rule.ConsecutiveLowercaseLetters;
import br.com.db1.passwordevaluator.businessrule.rule.ConsecutiveNumbers;
import br.com.db1.passwordevaluator.businessrule.rule.ConsecutiveUppercaseLetters;
import br.com.db1.passwordevaluator.businessrule.rule.LettersOnly;
import br.com.db1.passwordevaluator.businessrule.rule.LowercaseLetters;
import br.com.db1.passwordevaluator.businessrule.rule.MiddleNumbersOrSymbols;
import br.com.db1.passwordevaluator.businessrule.rule.Numbers;
import br.com.db1.passwordevaluator.businessrule.rule.NumbersOnly;
import br.com.db1.passwordevaluator.businessrule.rule.RepeatCharacters;
import br.com.db1.passwordevaluator.businessrule.rule.Requirements;
import br.com.db1.passwordevaluator.businessrule.rule.Rule;
import br.com.db1.passwordevaluator.businessrule.rule.SequentialLetters;
import br.com.db1.passwordevaluator.businessrule.rule.SequentialNumbers;
import br.com.db1.passwordevaluator.businessrule.rule.SequentialSymbols;
import br.com.db1.passwordevaluator.businessrule.rule.Symbols;
import br.com.db1.passwordevaluator.businessrule.rule.UppercaseLetters;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Evaluator {

  private static final List<Class<? extends Rule>> RULES;

  static {
    RULES = Arrays.asList(CharactersNumber.class, UppercaseLetters.class, LowercaseLetters.class,
            Numbers.class, Symbols.class, MiddleNumbersOrSymbols.class, Requirements.class,
            LettersOnly.class, NumbersOnly.class, RepeatCharacters.class, ConsecutiveUppercaseLetters.class,
            ConsecutiveLowercaseLetters.class, ConsecutiveNumbers.class, SequentialLetters.class,
            SequentialNumbers.class, SequentialSymbols.class);
  }

  /**
   * Evaluates the password provided according to the rules previously defined
   * in the RULES List
   *
   * @param password password to evaluate
   * @return the full report of appraisal
   * @throws ReflectiveOperationException
   */
  public static Report evaluate(String password) throws ReflectiveOperationException {
    List<Rule> rules = new LinkedList<>();
    Report report;

    for (Class<? extends Rule> ruleClass : RULES) {
      Rule rule = ruleClass.getConstructor(String.class).newInstance(password);

      rule.totalize();
      rules.add(rule);
    }

    report = new Report(rules);

    return report;
  }
}
