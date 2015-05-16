package divinegrace.com.moneyalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by DGBendicion on 5/16/15.
 */
public class RegistrationActivity extends Activity {
    @InjectView(R.id.et_type_password1)
    EditText etPassword1;
    @InjectView(R.id.et_type_password2)
    EditText etPassword2;
    @InjectView(R.id.tv_create_password_status)
    TextView tvCreatePasswordStatus;
    @InjectView(R.id.btn_start_money_alarm)
    Button btnStartMoneyAlarm;

    private MoneyAlarmController moneyAlarmController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration_layout);

        moneyAlarmController = new MoneyAlarmController();
        moneyAlarmController.initializeController(RegistrationActivity.this);

        ButterKnife.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        addPasswordEditextListeners();
        addStartMoneyAlarmButtonListener();
    }

    private void addPasswordEditextListeners() {
        etPassword1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etPassword1.getText().toString().equalsIgnoreCase(etPassword2.getText().toString())) {
                    showPasswordCreationStatusAndButton(true);
                } else {
                    showPasswordCreationStatusAndButton(false);
                }
            }
        });

        etPassword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etPassword1.getText().toString().equalsIgnoreCase(etPassword2.getText().toString())) {
                    showPasswordCreationStatusAndButton(true);
                } else {
                    showPasswordCreationStatusAndButton(false);
                }
            }
        });
    }

    private void showPasswordCreationStatusAndButton(boolean passwordsMatch) {
        if (passwordsMatch) {
            tvCreatePasswordStatus.setText("Passwords Match!");
            tvCreatePasswordStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            tvCreatePasswordStatus.setVisibility(View.VISIBLE);
            btnStartMoneyAlarm.setVisibility(View.VISIBLE);
        } else {
            tvCreatePasswordStatus.setText("Passwords do not match...");
            tvCreatePasswordStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            tvCreatePasswordStatus.setVisibility(View.VISIBLE);
            btnStartMoneyAlarm.setVisibility(View.GONE);
        }
    }

    private void addStartMoneyAlarmButtonListener() {
        btnStartMoneyAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moneyAlarmController.setCode(etPassword1.getText().toString());
                moneyAlarmController.setIsRegistered(true);

                Intent baseActivityIntent = new Intent(RegistrationActivity.this, MoneyAlarmBaseActivity.class);
                startActivity(baseActivityIntent);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
