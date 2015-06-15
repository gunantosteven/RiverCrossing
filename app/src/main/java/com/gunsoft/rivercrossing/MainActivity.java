package com.gunsoft.rivercrossing;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    TextView txtPetani, txtAyam, txtKambing, txtAnjing, txtSayuran, txtPadi, txtPerahu;
    LinearLayout linearlayout, seberangKiri, perahu, seberangKanan;

    String letakPerahu = "kiri";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);

        seberangKiri = (LinearLayout) findViewById(R.id.linearSeberangKiri);
        seberangKanan = (LinearLayout) findViewById(R.id.linearSeberangKanan);
        perahu = (LinearLayout) findViewById(R.id.linearPerahu);

        Button btnCross = (Button) findViewById(R.id.btnCross);

        txtPerahu = (TextView) findViewById(R.id.txtPerahu);

        txtPetani = (TextView) findViewById(R.id.txtPetani);
        txtPetani.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        if((((ViewGroup)txtPetani.getParent()) == seberangKiri ||
                                ((ViewGroup)txtPetani.getParent()) == seberangKanan) &&!checkPerahu())
                            return false;
                        // finger touches the screen
                        if(((ViewGroup)txtPetani.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                            perahu.addView(txtPetani);

                        }
                        else if(((ViewGroup)txtPetani.getParent()) == perahu)
                        {
                            ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                            if(letakPerahu.equals("kiri"))
                            {
                                seberangKiri.addView(txtPetani);
                            }
                            else
                            {
                                seberangKanan.addView(txtPetani);
                            }
                        }
                        else if(((ViewGroup)txtPetani.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                            perahu.addView(txtPetani);
                        }
                        return true;
                }

                return false;
            }
        });

        txtAyam = (TextView) findViewById(R.id.txtAyam);
        txtAyam.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        if((((ViewGroup)txtAyam.getParent()) == seberangKiri
                            || ((ViewGroup)txtAyam.getParent()) == seberangKanan)
                            &&!checkPerahu())
                            return false;
                        // finger touches the screen
                        if(((ViewGroup)txtAyam.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtPadi.getParent()) == perahu)
                            {
                                Toast.makeText(getApplicationContext(), "Ayam tidak bisa bersama dengan padi", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            else if(((ViewGroup)txtAnjing.getParent()) == perahu)
                            {
                                Toast.makeText(getApplicationContext(), "Ayam tidak bisa bersama dengan anjing", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                            perahu.addView(txtAyam);

                        }
                        else if(((ViewGroup)txtAyam.getParent()) == perahu)
                        {
                            ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                            if(letakPerahu.equals("kiri"))
                            {
                                seberangKiri.addView(txtAyam);
                            }
                            else
                            {
                                seberangKanan.addView(txtAyam);
                            }
                        }
                        else if(((ViewGroup)txtAyam.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                            perahu.addView(txtAyam);
                        }
                        return true;
                }

                return false;
            }
        });

        txtKambing = (TextView) findViewById(R.id.txtKambing);
        txtKambing.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        if((((ViewGroup)txtKambing.getParent()) == seberangKiri ||
                                ((ViewGroup)txtKambing.getParent()) == seberangKanan)
                                        && !checkPerahu())
                            return false;
                        // finger touches the screen
                        if(((ViewGroup)txtKambing.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtSayuran.getParent()) == perahu)
                            {
                                Toast.makeText(getApplicationContext(), "Kambing tidak bisa bersama dengan sayuran", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                            perahu.addView(txtKambing);

                        }
                        else if(((ViewGroup)txtKambing.getParent()) == perahu)
                        {
                            ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                            if(letakPerahu.equals("kiri"))
                            {
                                seberangKiri.addView(txtKambing);
                            }
                            else
                            {
                                seberangKanan.addView(txtKambing);
                            }
                        }
                        else if(((ViewGroup)txtKambing.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                            perahu.addView(txtKambing);
                        }
                        return true;
                }

                return false;
            }
        });

        txtAnjing = (TextView) findViewById(R.id.txtAnjing);
        txtAnjing.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        if((((ViewGroup)txtAnjing.getParent()) == seberangKiri
                                || ((ViewGroup)txtAnjing.getParent()) == seberangKanan)
                                && !checkPerahu())
                            return false;
                        // finger touches the screen
                        if(((ViewGroup)txtAnjing.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtAyam.getParent()) == perahu)
                            {
                                Toast.makeText(getApplicationContext(), "Anjing tidak bisa bersama dengan ayam", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                            perahu.addView(txtAnjing);

                        }
                        else if(((ViewGroup)txtAnjing.getParent()) == perahu)
                        {
                            ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                            if(letakPerahu.equals("kiri"))
                            {
                                seberangKiri.addView(txtAnjing);
                            }
                            else
                            {
                                seberangKanan.addView(txtAnjing);
                            }
                        }
                        else if(((ViewGroup)txtAnjing.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                            perahu.addView(txtAnjing);
                        }
                        return true;
                }

                return false;
            }
        });

        txtSayuran = (TextView) findViewById(R.id.txtSayuran);
        txtSayuran.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        if((((ViewGroup)txtSayuran.getParent()) == seberangKiri
                                || ((ViewGroup)txtSayuran.getParent()) == seberangKanan)
                                && !checkPerahu())
                            return false;
                        // finger touches the screen
                        if(((ViewGroup)txtSayuran.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtKambing.getParent()) == perahu)
                            {
                                Toast.makeText(getApplicationContext(), "Sayuran tidak bisa bersama dengan kambing", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                            perahu.addView(txtSayuran);

                        }
                        else if(((ViewGroup)txtSayuran.getParent()) == perahu)
                        {
                            ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                            if(letakPerahu.equals("kiri"))
                            {
                                seberangKiri.addView(txtSayuran);
                            }
                            else
                            {
                                seberangKanan.addView(txtSayuran);
                            }
                        }
                        else if(((ViewGroup)txtSayuran.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                            perahu.addView(txtSayuran);
                        }
                        return true;
                }

                return false;
            }
        });

        txtPadi = (TextView) findViewById(R.id.txtPadi);
        txtPadi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        if((((ViewGroup)txtPadi.getParent()) == seberangKiri
                                && ((ViewGroup)txtPadi.getParent()) == seberangKanan)
                                || !checkPerahu())
                            return false;
                        // finger touches the screen
                        if(((ViewGroup)txtPadi.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtAyam.getParent()) == perahu)
                            {
                                Toast.makeText(getApplicationContext(), "Padi tidak bisa bersama dengan ayam", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);
                            perahu.addView(txtPadi);

                        }
                        else if(((ViewGroup)txtPadi.getParent()) == perahu)
                        {
                            ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);
                            if(letakPerahu.equals("kiri"))
                            {
                                seberangKiri.addView(txtPadi);
                            }
                            else
                            {
                                seberangKanan.addView(txtPadi);
                            }
                        }
                        else if(((ViewGroup)txtPadi.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);
                            perahu.addView(txtPadi);
                        }
                        return true;
                }

                return false;
            }
        });

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout seberang;
                if(letakPerahu.equals("kiri"))
                {
                    seberang = seberangKiri;
                }
                else
                {
                    seberang = seberangKanan;
                }

                if(((ViewGroup)txtAyam.getParent()) == seberang &&
                        ((ViewGroup)txtPadi.getParent()) == seberang   )
                {
                    Toast.makeText(getApplicationContext(), "Ayam dan Padi tidak bisa bersama", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(((ViewGroup)txtAyam.getParent()) == seberang &&
                        ((ViewGroup)txtAnjing.getParent()) == seberang   )
                {
                    Toast.makeText(getApplicationContext(), "Ayam dan Anjing tidak bisa bersama", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(((ViewGroup)txtKambing.getParent()) == seberang &&
                        ((ViewGroup)txtSayuran.getParent()) == seberang   )
                {
                    Toast.makeText(getApplicationContext(), "Kambing dan Sayuran tidak bisa bersama", Toast.LENGTH_SHORT).show();
                    return;
                }



                int count = perahu.getChildCount();
                if(((ViewGroup)txtPetani.getParent()) != perahu)
                {
                    Toast.makeText(getApplicationContext(), "Petani perlu ada di kapal", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(count == 1)
                {
                    Toast.makeText(getApplicationContext(), "Tidak bisa menyebrang tidak ada objek", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(int i = 1; count > i; i++)
                {
                    TextView t = (TextView) perahu.getChildAt(1);
                    ((ViewGroup)t.getParent()).removeView(t);
                    if(letakPerahu.equals("kiri"))
                    {
                        seberangKanan.addView(t);
                    }
                    else
                    {
                        seberangKiri.addView(t);
                    }
                }
                if(letakPerahu.equals("kiri"))
                {
                    letakPerahu = "kanan";

                }
                else
                    letakPerahu = "kiri";

                txtPerahu.setText("Perahu Ada Di " + letakPerahu);

                // check if win
                if(seberangKiri.getChildCount() == 1)
                    Toast.makeText(getApplicationContext(), "You WIN", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public boolean checkPerahu()
    {
        if(perahu.getChildCount() <= 3)
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Perahu tidak bisa diisi lebih dari 3 objek", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                // finger touches the screen
                Log.e("Action Down", "Action Down");
                break;

            case MotionEvent.ACTION_MOVE:
                // finger moves on the screen
                Log.e("Action Move", "Action Move");
                break;

            case MotionEvent.ACTION_UP:
                // finger leaves the screen
                Log.e("Action Up", "Action Up");
                break;
        }

        // tell the system that we handled the event and no further processing is required
        return true;
    }
}
