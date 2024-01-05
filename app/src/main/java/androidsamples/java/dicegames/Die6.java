package androidsamples.java.dicegames;

import java.util.Random;

/**
 * An implementation of a six-faced {@link Die} using {@link Random}.
 */
public class Die6 implements Die {

  private int val;
  private final Random gen;
  public Die6() {
    // TODO implement method
    gen = new Random();
  }

  @Override
  public void roll() {
    // TODO implement method
    val = gen.nextInt(6) + 1;
  }

  @Override
  public int value() {
    // TODO implement method
    return val;
  }
}
