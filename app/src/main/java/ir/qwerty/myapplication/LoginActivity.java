package ir.qwerty.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    String user, pass, tmpu, tmppas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.usernameEditTextLogin);
        password = findViewById(R.id.passEditTextLogin);
    }

    public void onClickBtnLogin(View view) {

        tmpu = username.getText().toString();
        tmppas = password.getText().toString();
        user="amir";
        pass="1228";

       if (tmpu.equals(user)&&tmppas.equals(pass)) {
            Toast.makeText(getApplicationContext(), "با موفقیت وارد شدید", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "خظا ... !!", Toast.LENGTH_LONG).show();
        }
    }
}
