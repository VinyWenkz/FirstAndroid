package divinegrace.com.moneyalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by DGBendicion on 5/16/15.
 */
public class MoneyAlarmMainActivity extends Activity {
    MoneyAlarmController moneyAlarmController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.moneyAlarmController = new MoneyAlarmController();

        this.moneyAlarmController.initializeController(MoneyAlarmMainActivity.this);

        if (moneyAlarmController.isRegistered()) {
            // call BaseActivity
            Intent baseActivityIntent = new Intent(this, EnterCodeActivity.class);
            startActivity(baseActivityIntent);
            this.finish();
        } else {
            // call RegistrationActivity
            Intent registrationIntent = new Intent(this, RegistrationActivity.class);
            startActivity(registrationIntent);
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
