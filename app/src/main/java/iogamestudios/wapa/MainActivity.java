package iogamestudios.wapa;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity implements android.location.LocationListener {

    LocationManager locationManager;
    String provider;
    LocationRequest locationRequest;
    Location lastLocation;
    String lat;
    String lon;

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MSG", Storage.test);
        loadServiceSelectionActivity();
        /*
        if (Storage.alreadyLogin) {
            loadServicesActivity();
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        provider = locationManager.getBestProvider(new Criteria(), false);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            locationRequest = LocationRequest.create();
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            locationRequest.setInterval(100); // Update location every second

            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);


            lastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    googleApiClient);
            if (lastLocation != null) {
                lat = String.valueOf(lastLocation.getLatitude());
                lon = String.valueOf(lastLocation.getLongitude());
                Log.d("MSG latitude", lat.toString());
                Log.d("MSG longitude", lon.toString());
            }
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        googleApiClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();*/
    }


    public void loadLoginActivity(View view) {
        Log.d("MSG", "Loading Login!");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    void loadServicesActivity() {
        Log.d("MSG", "Loading Services");
        Intent intent = new Intent(this, ServicesActivity.class);
        startActivity(intent);
    }

    void loadServiceSelectionActivity (){
        Log.d("MSG", "Loading service selection");
        Intent intent = new Intent(this, ServiceSelection.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();


        // locationManager.requestLocationUpdates(provider, 1000, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();

        Log.d("Location Latitude ", lat.toString());
        Log.d("Location Longitud ", lon.toString());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    /*@Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://iogamestudios.wapa/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }*/

    /*@Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://iogamestudios.wapa/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }*/
}
