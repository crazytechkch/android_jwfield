package co.crazytech.jwfield;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import co.crazytech.jwfield.db.DatabaseManager;
import co.crazytech.jwfield.terrsurvey.TerrsurveyFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_language) {
            final Context context = this;
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            DatabaseManager dbman = new DatabaseManager(context);
            dbman.open();
            SQLiteDatabase db = dbman.getDb();
            Cursor cursor = db.rawQuery("select * from languages order by name", null);
            final List<Language> languages = new ArrayList<Language>();
            String[] items = new String[cursor.getCount()];
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                languages.add(new Language(cursor.getString(cursor.getColumnIndex("locale")),cursor.getString(cursor.getColumnIndex("name")),cursor.getString(cursor.getColumnIndex("basename"))));
                items[cursor.getPosition()] = cursor.getString(cursor.getColumnIndex("name"));
                cursor.moveToNext();
            }
            cursor.close();
            dbman.close();
            builder.setTitle(getString(R.string.action_language));
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Language language = languages.get(which);
                    setLocale(context,language.getLocale());
                }
            });
            builder.create().show();
        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = new Fragment();
        if (id == R.id.nav_territory_survey_form) {
            fragment = new TerrsurveyFragment();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        FragmentManager fragman = getSupportFragmentManager();
        fragman.beginTransaction().replace(R.id.fragment,fragment).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected static void setLocale(Context context,String locale){
        Locale loc = new Locale(locale);
        Locale.setDefault(loc);

        Configuration config = new Configuration();
        config.locale = loc;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }
}
