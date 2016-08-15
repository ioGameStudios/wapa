package iogamestudios.wapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServicesActivity extends AppCompatActivity {


    Button toDateSelectionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        toDateSelectionButton = (Button)findViewById(R.id.toDateSelectionButton);

        toDateSelectionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadDateSelectionView();
                    }
                }
        );
    }

    void loadDateSelectionView(){
        Log.d("MSG", "Loading date selection");
        Intent intent = new Intent(this, DateSelectionActivity.class);
        startActivity(intent);
    }
}
