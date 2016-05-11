package pl.edu.ur.kulturalia;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by f3cro12 on 5/3/2016.
 */
public class Dojazd extends AppCompatActivity {


    public String position() {

        LocationManager locationManager;
        LocationListener locationListener;

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };


        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);

        boolean enabled = locationManager.isProviderEnabled(provider);

        if(enabled == false) {
            locationListener.onProviderDisabled(provider);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        Location location = locationManager.getLastKnownLocation(provider);

        String position="";

        if(location != null) {
            String latitude = Double.toString(location.getLatitude());
            String longtitude = Double.toString(location.getLongitude());
            position = latitude + "," + longtitude;
        }
        return position;
    }

    ;

    public class Choose {
        private String destination;
        private String startPosition;
        AlertDialog.Builder alertDialog;

        private Choose(String dest) {
            destination = dest;
        }

        private Choose(String start, String dest) {
            startPosition = start;
            destination = dest;

        }

        private void Navi() {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?saddr=" + startPosition + "&" + "daddr=" + destination));
            startActivity(intent);
        }

        private void jakDojade() {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://rzeszow.jakdojade.pl/?fc=" + startPosition + "&" + "tc=" + destination));
            startActivity(intent);
        }

        public void dialogBox() {
            alertDialog = new AlertDialog.Builder(Dojazd.this);


            alertDialog.setPositiveButton("Nawigacja (GoogleMaps)", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Navi();
                }


            });

            alertDialog.setNegativeButton("MPK (Rzeszów)", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startPosition = startPosition.replace(",",":");
                    destination = destination.replace(",", ":");
                    jakDojade();
                }
            });

            alertDialog.show();


        }


    }


    Button koncerty;
    Button cs;
    Button before;
    Button skoki;
    Button palma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dojazd);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                }, 10);

            }
        }



        koncerty = (Button) findViewById(R.id.button);
        koncerty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = "50.017261, 22.004949";
                Choose box = new Choose(position(), destination);
                box.dialogBox();
            }
        });

        cs = (Button) findViewById(R.id.button6);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = "50.029903, 22.014384";
                Choose box = new Choose(position(), destination);
                box.dialogBox();
            }
        });

        before = (Button) findViewById(R.id.button7);
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = "50.016529, 22.004761";
                Choose box = new Choose(position(), destination);
                box.dialogBox();
            }
        });

        skoki = (Button) findViewById(R.id.button8);
        skoki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = "50.009963, 22.920656";
                Choose box = new Choose(position(), destination);
                box.dialogBox();
            }
        });

        palma = (Button) findViewById(R.id.button9);
        palma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = "50.016529, 22.004761";
                Choose box = new Choose(position(), destination);
                box.dialogBox();
            }
        });




    }
}
