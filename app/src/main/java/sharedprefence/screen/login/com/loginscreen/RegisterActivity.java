package sharedprefence.screen.login.com.loginscreen;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    Button btnCancel;
    EditText edtRegisterUser;
    EditText edtRegisterPass;
    CheckBox cbAgreeRegister;
    String nameShared = "LogginInformation";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addcontrol();
        addevent();
    }

    private void addcontrol() {
        btnCancel = findViewById(R.id.btnCancel);
        btnRegister = findViewById(R.id.btnRegister);
        edtRegisterUser = findViewById(R.id.edtRegisterUser);
        edtRegisterPass = findViewById(R.id.edtRegisterPass);
        cbAgreeRegister = findViewById(R.id.cbAgreeRegister);
    }

    private void addevent() {
    btnCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
    btnRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            xulyregister();
        }
    });
    }

    private void xulyregister() {
        Setting setting = Setting.getIntance(this);
        String user = edtRegisterUser.getText().toString();
        String pass = edtRegisterPass.getText().toString();
        setting.setUsername(user);
        setting.setPASSWORLD(pass);
        if (TextUtils.isEmpty(user) && TextUtils.isEmpty(pass) && !cbAgreeRegister.isChecked())
        {
            Toast.makeText(RegisterActivity.this,"You need agree and don't let empty Username and Password",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(RegisterActivity.this,"Register succesfully",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
