package iogamestudios.wapa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateSelectionActivity extends AppCompatActivity {

    Button toSelectLocationActivity;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView badtextWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        toSelectLocationActivity = (Button)findViewById(R.id.toSelectLocationButton);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        badtextWarning = (TextView)findViewById(R.id.badDateWarning);

        toSelectLocationActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkDateAndTime();
                    }
                }
        );
    }

    void checkDateAndTime(){
        Calendar cal = Calendar.getInstance();

        //String currentDate = Integer.toString(currentYear) + "/" + Integer.toString(currentMonth) + "/" + Integer.toString(currentDay);
        //Log.d("Current date", currentDate);

        int selectedYear = datePicker.getYear();

        Log.d("Picket date", Integer.toString(selectedYear));

        if(datePicker.getYear() < cal.get(Calendar.YEAR)){
            //badtextWarning.setText("Selecciona una fecha que sea posterior a la actual");
            badtextWarning.setVisibility(View.VISIBLE);
        }else if(datePicker.getMonth() < cal.get(Calendar.MONTH)){
            badtextWarning.setVisibility(View.VISIBLE);
        }else if(datePicker.getDayOfMonth() < cal.get(Calendar.DAY_OF_MONTH)){
            badtextWarning.setVisibility(View.VISIBLE);
        }else{
            loadLocationSelectionActivity();
        }
    }

    void loadLocationSelectionActivity(){
        Log.d("MSG", "Loading date selection");
        Intent intent = new Intent(this, LocationSelectionActivity.class);
        startActivity(intent);
    }
}
