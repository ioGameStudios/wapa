package iogamestudios.wapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText nameField;
    EditText emailField;
    EditText confirmEmailField;
    EditText passwordField;
    EditText confirmPasswordField;
    EditText phoneField;
    Button createaccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameField = (EditText)findViewById(R.id.nameField);
        emailField = (EditText)findViewById(R.id.emailField);
        confirmEmailField = (EditText)findViewById(R.id.emailConfirmationField);
        passwordField = (EditText)findViewById(R.id.passwordField);
        confirmPasswordField = (EditText)findViewById(R.id.confirmPasswordField);
        phoneField = (EditText)findViewById(R.id.phoneField);
        createaccountButton = (Button)findViewById(R.id.createAccountButton);

        createaccountButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkFields();
                    }
                }
        );
    }

    void checkFields(){

        Boolean notEmptyFields = false;
        Boolean emailOK  = false;
        Boolean passwordOK = false;

        TextView warningMessage = (TextView)findViewById(R.id.warningMessage);

        if(nameField.getText().toString().matches("") || emailField.getText().toString().matches("") ||
                confirmEmailField.getText().toString().matches("") || passwordField.getText().toString().matches("") ||
                confirmPasswordField.getText().toString().matches("") || phoneField.getText().toString().matches("")) {
            Log.d("MSG", "Not Cool");
            warningMessage.setVisibility(View.VISIBLE);
        }else{
            notEmptyFields = true;
        }

        if(emailField.getText().toString().matches(confirmEmailField.getText().toString())){
            emailOK = true;
        }else{
            warningMessage.setText("Los campos de Email no coinciden");
            warningMessage.setVisibility(View.VISIBLE);
        }

        if(passwordField.getText().toString().matches(confirmPasswordField.getText().toString())){
            passwordOK = true;
        }else{
            warningMessage.setText("Las contraseñas no coinciden");
            warningMessage.setVisibility(View.VISIBLE);
        }

        if(notEmptyFields && emailOK && passwordOK){
            //Send info to server
            Log.d("MSG", "Sending info to server");
        }
    }

}
