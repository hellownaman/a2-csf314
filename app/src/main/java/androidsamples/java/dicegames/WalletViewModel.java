package androidsamples.java.dicegames;

import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {

  private Die d;
  private int bal, currVal, prevVal, singleSixes, dblSixes, totRolls, dblOthers;

  /**
   * The no argument constructor.
   */
  public WalletViewModel() {
    // TODO implement method
    d = new Die6();
    currVal = prevVal = bal = singleSixes = dblSixes = totRolls = dblOthers = 0;
  }

  /**
   * Reports the current balance.
   *
   */
  public int balance() {
    // TODO implement method
    return bal;
  }

  /**
   * Rolls the {@link Die} in the wallet and implements the changes accordingly.
   */
  public void rollDie() {
    // TODO implement method
    d.roll();
    totRolls++;
    prevVal = currVal;
    currVal = d.value();
    if (currVal == prevVal) {
      if (currVal == 6) {
        bal += 10;
        dblSixes++;
      }
      else {
        bal -= 5;
        dblOthers++;
      }
    }
    else if (currVal == 6) {
      bal += 5;
      singleSixes++;
    }
  }

  /**
   * Reports the current value of the {@link Die}.
   *
   */
  public int dieValue() {
    // TODO implement method
    return currVal;
  }

  /**
   * Reports the number of single (or first) sixes rolled so far.
   *
   */
  public int singleSixes() {
    // TODO implement method
    return singleSixes;
  }

  /**
   * Reports the total number of dice rolls so far.
   *
   */
  public int totalRolls() {
    // TODO implement method
    return totRolls;
  }

  /**
   * Reports the number of times two sixes were rolled in a row.
   *
   */
  public int doubleSixes() {
    // TODO implement method
    return dblSixes;
  }

  /**
   * Reports the number of times any other number was rolled twice in a row.
   *
   */
  public int doubleOthers() {
    // TODO implement method
    return dblOthers;
  }

  /**
   * Reports the value of the die on the previous roll.
   *
   */
  public int previousRoll() {
    // TODO implement method
    return prevVal;
  }
  
  public void setDie(Die d) {
    this.d = d;
  }
}
