package sharedprefence.screen.login.com.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername;
    EditText edtPassworld;
    CheckBox cbSave;
    Button btnLoggin;
    Button btnClickhere;
    Button btnExit;

    String nameShared = "LogginInformation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        addevent();
    }

    private void addcontrol() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassworld = findViewById(R.id.edtPassword);
        cbSave = findViewById(R.id.cbSave);
        btnLoggin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);
        btnClickhere = findViewById(R.id.btnClickhere);
    }
    private void addevent() {
        btnLoggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulylogin();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnClickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void xulylogin() {
        String id = Setting.getIntance(this).getUsername(edtUsername.getText().toString());
        String pas = Setting.getIntance(this).getPASSWORLD(edtPassworld.getText().toString());

        if (edtUsername.getText().toString().equals(id) && edtPassworld.getText().toString().equals(pas)){
            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            startActivity(intent);
        }else if (TextUtils.isEmpty((edtUsername.getText().toString())) && TextUtils.isEmpty(edtPassworld.getText().toString())){
            Toast.makeText( MainActivity.this,"UserName and Password can't empty",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();//luu thong tin dang nhap vao shared prefence
        SharedPreferences preferences = getSharedPreferences(nameShared,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",edtUsername.getText().toString());
        editor.putString("passworld",edtPassworld.getText().toString());
        editor.putBoolean("saveinfo",cbSave.isChecked());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();//doc lai thong tin dang nhap
        SharedPreferences preferences = getSharedPreferences(nameShared,MODE_PRIVATE);
        String user = preferences.getString("user","");
        String password = preferences.getString("passworld","");
        boolean saveinfo = preferences.getBoolean("saveinfo",false);
        if (saveinfo){
            edtUsername.setText(user);
            edtPassworld.setText(password);
        }
        cbSave.setChecked(saveinfo);


    }
}
