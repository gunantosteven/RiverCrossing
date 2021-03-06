package com.gunsoft.rivercrossing;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MenuActivity extends ActionBarActivity {

    Button btnLevel1, btnLevel2, btnLevel3, btnLevel4, btnLevel5, btnLevel6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnLevel1 = (Button) findViewById(R.id.btnLevel1);
        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Level1Activity.class);
                startActivity(intent);
                MusicService.getMp().pause();
            }
        });

        btnLevel2 = (Button) findViewById(R.id.btnLevel2);
        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Level2Activity.class);
                startActivity(intent);
                MusicService.getMp().pause();
            }
        });

        btnLevel3 = (Button) findViewById(R.id.btnLevel3);
        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Level3Activity.class);
                startActivity(intent);
                MusicService.getMp().pause();
            }
        });

        btnLevel4 = (Button) findViewById(R.id.btnLevel4);
        btnLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tunggu Update Selanjutnya", Toast.LENGTH_SHORT).show();
            }
        });

        btnLevel5 = (Button) findViewById(R.id.btnLevel5);
        btnLevel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tunggu Update Selanjutnya", Toast.LENGTH_SHORT).show();
            }
        });

        btnLevel6 = (Button) findViewById(R.id.btnLevel6);
        btnLevel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tunggu Update Selanjutnya", Toast.LENGTH_SHORT).show();
            }
        });

        startService(new Intent(MenuActivity.this, MusicService.class));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(new Intent(this, MusicService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(this, MusicService.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
