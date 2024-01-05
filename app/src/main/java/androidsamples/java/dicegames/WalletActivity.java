package androidsamples.java.dicegames;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class WalletActivity extends AppCompatActivity {

  private WalletViewModel vm;
  private final String UI_TXT_STATE = "UI_TXT_STATE";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wallet);

    vm = new ViewModelProvider(this).get(WalletViewModel.class);
    Button dieButton = findViewById(R.id.btn_die);
    TextView coinBal = findViewById(R.id.txt_balance);
    TextView prevRoll = findViewById(R.id.txt_prev_roll);
    TextView singleSixes = findViewById(R.id.txt_single_sixes);
    TextView doubleSixes = findViewById(R.id.txt_double_sixes);
    TextView doubleOthers = findViewById(R.id.txt_double_others);
    TextView totalRolls = findViewById(R.id.txt_total_rolls);

    if (savedInstanceState != null) {
      int[] data = savedInstanceState.getIntArray(UI_TXT_STATE);
      dieButton.setText(String.valueOf(data[0]));
      coinBal.setText(String.valueOf(data[1]));
      prevRoll.setText(String.valueOf(data[2]));
      totalRolls.setText(String.valueOf(data[3]));
      singleSixes.setText(String.valueOf(data[4]));
      doubleSixes.setText(String.valueOf(data[5]));
      doubleOthers.setText(String.valueOf(data[6]));
    }

    dieButton.setOnClickListener(view -> {
      vm.rollDie();
      if (vm.dieValue() == 6) {
        Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show();
      }
      dieButton.setText(String.valueOf(vm.dieValue()));
      coinBal.setText(String.valueOf(vm.balance()));
      prevRoll.setText(String.valueOf(vm.previousRoll()));
      singleSixes.setText(String.valueOf(vm.singleSixes()));
      doubleSixes.setText(String.valueOf(vm.doubleSixes()));
      doubleOthers.setText(String.valueOf(vm.doubleOthers()));
      totalRolls.setText(String.valueOf(vm.totalRolls()));
    });
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    int[] data = {vm.dieValue(), vm.balance(), vm.previousRoll(), vm.totalRolls(), vm.singleSixes(), vm.doubleSixes(), vm.doubleOthers()};
    outState.putIntArray(UI_TXT_STATE, data);
  }
}