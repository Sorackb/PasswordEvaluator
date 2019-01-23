package br.com.db1.passwordevaluator.businessrule.rule;

public class RepeatCharacters extends Rule {

  public RepeatCharacters(String password) {
    super("Repeat Characters (Case Insensitive)", password);
  }

  @Override
  public void totalize() {
    this.count();
  }

  /**
   * Count the ocurrences of repeated characters in the given password and set
   * the <strong>count</strong> and <strong>bonus</strong> attributes of the
   * class
   */
  @Override
  protected Integer count() {
    Double increment = 0.0;
    Double repeatedChar = 0.0;
    char[] letters;
    Double uniqueChar;

    String used = this.password.replaceAll("\\s+", "");
    letters = used.toCharArray();

    for (Integer a = 0; a < letters.length; a++) {
      Boolean repeated = false;

      for (Integer b = 0; b < letters.length; b++) {
        if (letters[a] == letters[b] && a != b) {
          repeated = true;

          /*
           * Calculate increment deduction based on proximity to identical characters
           * Deduction is incremented each time a new match is discovered
           * Deduction amount is based on total password length divided by the
           * difference of distance between currently selected match
           */
          increment += Math.abs(letters.length / (b - a));
        }
      }

      if (repeated) {
        repeatedChar++;
        uniqueChar = letters.length - repeatedChar;
        increment = uniqueChar > 0.0 ? Math.ceil(increment / uniqueChar) : Math.ceil(increment);
      }
    }

    this.count = repeatedChar.intValue();
    this.bonus = -Math.abs(increment.intValue());

    return repeatedChar.intValue();
  }

  /**
   * Won't be implemented because the <strong>count</strong> and
   * <strong>bonus</strong> are setted in the same method
   */
  @Override
  protected Integer calculate() {
    throw new UnsupportedOperationException("Use the overrided 'totalize' method instead.");
  }

}
