package sharedprefence.screen.login.com.loginscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Setting {
    private final String USERNAME = "name";
    private final String PASSWORLD = "pass";

    private SharedPreferences sharedPreferences;

    private static Setting setting;

    public static synchronized Setting getIntance(Context context) {
        if (setting == null) setting = new Setting(context);

        return setting;
    }

    private Setting(Context context) {
        sharedPreferences = context.getSharedPreferences("LogginInformation", Context.MODE_PRIVATE);
    }

    public void setUsername(String username) {
        Log.wtf("Setting", username);
        sharedPreferences.edit().putString(USERNAME, username).commit();
    }

    public  void setPASSWORLD(String passworld){
        sharedPreferences.edit().putString(PASSWORLD,passworld).commit();
    }

    public String getUsername(String s) {
        return sharedPreferences.getString(USERNAME, null);
    }

    public String getPASSWORLD(String s) {
        return sharedPreferences.getString(PASSWORLD,null);
    }
}
