package divinegrace.com.moneyalarm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by DGBendicion on 5/16/15.
 */
public class DatabaseService {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public DatabaseService(Context context) {
        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        this.editor = sharedPreferences.edit();
    }

    private void saveBooleanToSharedPref(String sharedPrefKey, Boolean booleanValue) {
        this.editor.putBoolean(sharedPrefKey, booleanValue);
        editor.commit();
    }

    private boolean getBooleanValueFromSharedPref(String sharedPrefKey) {
        return this.sharedPreferences.getBoolean(sharedPrefKey, false);
    }

    private void saveStringToSharedPref(String sharedPrefKey, String stringValue) {
        this.editor.putString(SharedPreferenceKeys.CODE, stringValue);
        editor.commit();
    }

    private String getStringFromSharedPref(String sharedPrefKey) {
        return this.sharedPreferences.getString(sharedPrefKey, "");
    }

    public void setRegistered(boolean isRegistered) {
        saveBooleanToSharedPref(SharedPreferenceKeys.REGISTERED, isRegistered);
    }

    public boolean isRegistered() {
        return getBooleanValueFromSharedPref(SharedPreferenceKeys.REGISTERED);
    }

    public void setCode(String code) {
        saveStringToSharedPref(SharedPreferenceKeys.CODE, code);
    }

    public String getCode() {
        return getStringFromSharedPref(SharedPreferenceKeys.CODE);
    }
}
