package divinegrace.com.moneyalarm;

import android.content.Context;

/**
 * Created by DGBendicion on 5/16/15.
 */
public class MoneyAlarmController {
    private Context context;
    private DatabaseService databaseService;

    public void initializeController(Context context) {
        this.context = context;

        this.databaseService = new DatabaseService(context);
    }

    public void setIsRegistered(boolean isRegistered) {
        this.databaseService.setRegistered(isRegistered);
    }

    public boolean isRegistered() {
        return this.databaseService.isRegistered();
    }

    public void setCode(String code) {
        this.databaseService.setCode(code);
    }

    public String getCode() {
        return this.databaseService.getCode();
    }

}
