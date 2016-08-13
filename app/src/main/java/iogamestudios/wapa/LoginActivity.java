package iogamestudios.wapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText emailField;
    EditText passwordField;
    Button loginButton;
    Button toRegisterButton;
    Button passwordRecovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = (EditText)findViewById(R.id.emailField);
        passwordField = (EditText)findViewById(R.id.passwordField);
        loginButton = (Button)findViewById(R.id.loginButton);
        toRegisterButton = (Button)findViewById(R.id.toRegisterButton);
        passwordRecovery = (Button)findViewById(R.id.passwordRecoveryButton);

        loginButton.setOnClickListener(
                new OnClickListener()
                {
                    public void onClick(View view){
                        //Log.d("MSG", emailField.getText().toString();
                    }
                });

        toRegisterButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadRegisterActivity();
                    }
                }
        );

        passwordRecovery.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadPasswordRecoveryActivity();
                    }
                }
        );
    }

    public void loadPasswordRecoveryActivity(){
        Log.d("MSG", "Loading password recovery");
        Intent intent = new Intent(this, PasswordRecoveryActivity.class);
        startActivity(intent);
    }

    public void loadRegisterActivity(){
        Log.d("MSG", "Loading Register!");
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
