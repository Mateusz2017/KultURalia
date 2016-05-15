package pl.edu.ur.kulturalia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(pl.edu.ur.kulturalia.R.layout.activity_urz);
        Toolbar toolbar = (Toolbar) findViewById(pl.edu.ur.kulturalia.R.id.toolbar);
        final Time odliczanie = new Time();
        FloatingActionButton fab = (FloatingActionButton) findViewById(pl.edu.ur.kulturalia.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, odliczanie.wyrazenie, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(pl.edu.ur.kulturalia.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, pl.edu.ur.kulturalia.R.string.navigation_drawer_open, pl.edu.ur.kulturalia.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.urz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.harmonogram) {
            Toast.makeText(this,"Harmonogram imprez", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Harmonogram.class);
            startActivity(intent);
        } else if (id == R.id.pogoda) {
            Toast.makeText(this,"Pogoda", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            startActivity(intent);

        } else if (id == R.id.mapa_kampusu) {
            Toast.makeText(this,"Mapa kampusu", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.dojazd) {
            Toast.makeText(this, "Jak do nas dojechać?", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Dojazd.class);
            startActivity(intent);

        } else if (id == R.id.scena_klubowa) {
            Toast.makeText(this,"Scena klubowa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Scena_klubowa.class);
            startActivity(intent);

        } else if (id == R.id.eventy) {
            Toast.makeText(this,"Eventy KultURaliowe", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Events.class);
            startActivity(intent);

        } else if (id == R.id.sponsorzy) {
            Toast.makeText(this,"Sponsorzy KultURaliów ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MainDonors.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.autorzy) {
            Toast.makeText(this,"Autorzy aplikacji", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Autorzy.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.fanpage) {
            Toast.makeText(this,"Nasz fanpage", Toast.LENGTH_SHORT).show();
            Uri uri = Uri.parse("http://facebook.com/kultURaliaUR");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
