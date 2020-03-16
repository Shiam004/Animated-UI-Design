package com.example.modern_ui_splash_animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;
    String username,name,upassword,phone,uemail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        Menu menu = navigationView.getMenu();


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent( Dashboard.this, Dashboard.class);
                startActivity(intent);
                break;
            case R.id.nav_bus:

                intent = new Intent(Dashboard.this, bus_Booking.class);

                startActivity(intent);
                break;
            case R.id.nav_update:
                intent = getIntent();

                username = intent.getStringExtra("username");
                name = intent.getStringExtra("name");
                phone = intent.getStringExtra("phone");
                upassword = intent.getStringExtra("pass");
                uemail = intent.getStringExtra("email");

                intent = new Intent(Dashboard.this, user_profile.class);

                intent.putExtra("name",name);
                intent.putExtra("username",username);
                intent.putExtra("phone",phone);
                intent.putExtra("email",uemail);
                intent.putExtra("pass",upassword);

                startActivity(intent);
                break;
            case R.id.nav_walk:
                intent = new Intent(Dashboard.this, walk.class);
                startActivity(intent);
                break;
            case R.id.nav_plane:
                intent = new Intent(Dashboard.this, plane_book.class);
                startActivity(intent);
                break;
            case R.id.nav_train:
                intent = new Intent(Dashboard.this, train_book.class);
                startActivity(intent);
                break;
            case R.id.nav_ship:
                intent = new Intent(Dashboard.this, ship_book.class);
                startActivity(intent);
                break;
            case R.id.nav_car:
                intent = new Intent(Dashboard.this, car_book.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void walk(View view) {
       Intent intent = new Intent(Dashboard.this, walk.class);
        startActivity(intent);
    }

    public void ship_book(View view) {
        Intent intent = new Intent(Dashboard.this, ship_book.class);
        startActivity(intent);

    }

    public void bus_book(View view) {
        Intent intent = new Intent(Dashboard.this, bus_Booking.class);
        startActivity(intent);

    }

    public void train_book(View view) {
        Intent intent = new Intent(Dashboard.this, train_book.class);
        startActivity(intent);
    }

    public void car(View view) {
        Intent intent = new Intent(Dashboard.this, car_book.class);
        startActivity(intent);
    }

    public void plane_book(View view) {
        Intent intent = new Intent(Dashboard.this, plane_book.class);
        startActivity(intent);
    }
}
