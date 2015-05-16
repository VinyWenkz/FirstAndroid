package divinegrace.com.moneyalarm;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by DGBendicion on 5/16/15.
 */
public class EnterCodeActivity extends Activity {
    @InjectView(R.id.et_enter_password)
    EditText etEnterPassword;
    @InjectView(R.id.tv_enter_password_status)
    TextView tvEnterPasswordStatus;


    private MoneyAlarmController moneyAlarmController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_login_layout);

        moneyAlarmController = new MoneyAlarmController();
        moneyAlarmController.initializeController(EnterCodeActivity.this);

        ButterKnife.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        addEnterPasswordEditTextListener();
    }

    private void addEnterPasswordEditTextListener() {
        final String code = moneyAlarmController.getCode();
        etEnterPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (code.equalsIgnoreCase(etEnterPassword.getText().toString())) {
                    tvEnterPasswordStatus.setText("Code Accepted!");
                    tvEnterPasswordStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                } else {
                    tvEnterPasswordStatus.setText("Invalid Code...");
                    tvEnterPasswordStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
                tvEnterPasswordStatus.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
