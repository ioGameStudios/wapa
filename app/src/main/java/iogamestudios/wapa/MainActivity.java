package iogamestudios.wapa;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MSG", Storage.test);
        if(Storage.alreadyLogin){
            loadServicesActivity();
        }
    }


    public void loadLoginActivity(View view){
        Log.d("MSG", "Loading Login!");
        Intent intent = new Intent(this, LoginActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = "Hola";//editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }

    void loadServicesActivity(){
        Log.d("MSG", "Loading Services");
        Intent intent = new Intent(this, ServicesActivity.class);
        startActivity(intent);
    }
}
