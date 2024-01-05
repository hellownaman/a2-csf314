package androidsamples.java.dicegames;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class WalletTest {
  private final WalletViewModel wvm = new WalletViewModel();
  private final Die d = mock(Die6.class);
  @Test
  public void rolling6IncrementsBalanceBy5() {
    int oldBalance = wvm.balance();
    when(d.value()).thenReturn(6);
    wvm.setDie(d);
    wvm.rollDie();
    assertThat(wvm.balance(), Is.is(oldBalance + 5));
  }
  @Test
  public void rollingDouble6IncrementsBalanceBy15() {
    int oldBalance = wvm.balance();
    when(d.value()).thenReturn(6);
    wvm.setDie(d);
    wvm.rollDie();
    wvm.rollDie();
    assertThat(wvm.balance(), Is.is(oldBalance + 15));
  }

  @Test
  public void rollingDoubleOthersDecrementsBalanceBy5() {
    int oldBalance = wvm.balance();
    int rngVal = (int)(Math.random() * 5) + 1;
    when(d.value()).thenReturn(rngVal);
    wvm.setDie(d);
    wvm.rollDie();
    wvm.rollDie();
    assertThat(wvm.balance(), Is.is(oldBalance - 5));
  }
  @Test
  public void anyRollIncreasesTotalRollsBy1() {
    int oldVal = wvm.totalRolls();
    wvm.setDie(d);
    wvm.rollDie();
    assertThat(wvm.totalRolls(), Is.is(oldVal + 1));
  }
  @Test
  public void checkPrevRoll() {
    int rngVal = (int)(Math.random() * 6) + 1;
    when(d.value()).thenReturn(rngVal);
    wvm.setDie(d);
    wvm.rollDie();
    wvm.setDie(new Die6());
    wvm.rollDie();
    assertThat(wvm.previousRoll(), Is.is(rngVal));
  }
}