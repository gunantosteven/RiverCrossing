package com.gunsoft.rivercrossing;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    TextView txtPetani, txtAyam, txtKambing, txtAnjing, txtSayuran, txtPadi, txtStep;
    LinearLayout linearlayout, seberangKiri, perahuKiri, perahuKanan, seberangKanan, sisiPerahuSekarang;

    String letakPerahu = "kiri";

    int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // << hide title bar
        setContentView(R.layout.activity_main);

        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);

        seberangKiri = (LinearLayout) findViewById(R.id.linearSeberangKiri);
        seberangKanan = (LinearLayout) findViewById(R.id.linearSeberangKanan);
        perahuKiri = (LinearLayout) findViewById(R.id.linearPerahuKiri);
        perahuKanan = (LinearLayout) findViewById(R.id.linearPerahuKanan);

        // default perahu ada di kiri
        sisiPerahuSekarang = perahuKiri;

        final Button btnCross = (Button) findViewById(R.id.btnCross);
        Button btnReset = (Button) findViewById(R.id.btnReset);

        txtStep = (TextView) findViewById(R.id.txtStep);

        // hide perahu kanan
        perahuKanan.setVisibility(View.INVISIBLE);

        //Urutan Logika IF
        // IF pertama seberang Kiri
        // Kedua perahu kiri
        // Ketiga perahu kanan
        // Keempat seberang kanan



        txtPetani = (TextView) findViewById(R.id.txtPetani);
        txtPetani.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        ViewGroup parentPetani = (ViewGroup)txtPadi.getParent();
                        //  check condition where boat where object in the same side
                        if(!checkCondition(txtPetani))
                            return false;

                        // start condition
                        if(((ViewGroup)txtPetani.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                            perahuKiri.addView(txtPetani);

                        }
                        else if(((ViewGroup)txtPetani.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                            seberangKiri.addView(txtPetani);
                        }
                        else if(((ViewGroup)txtPetani.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                            seberangKanan.addView(txtPetani);
                        }
                        else if(((ViewGroup)txtPetani.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                            perahuKanan.addView(txtPetani);
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
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtAyam))
                            return false;


                        // start condition
                        if(((ViewGroup)txtAyam.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtPadi.getParent()) == perahuKiri)
                            {
                                Toast.makeText(getApplicationContext(), "Ayam tidak bisa bersama dengan padi", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            else if(((ViewGroup)txtAnjing.getParent()) == perahuKiri)
                            {
                                Toast.makeText(getApplicationContext(), "Ayam tidak bisa bersama dengan anjing", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                            perahuKiri.addView(txtAyam);

                        }
                        else if(((ViewGroup)txtAyam.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                            seberangKiri.addView(txtAyam);
                        }
                        else if(((ViewGroup)txtAyam.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                            seberangKanan.addView(txtAyam);
                        }
                        else if(((ViewGroup)txtAyam.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            if(((ViewGroup)txtPadi.getParent()) == perahuKanan)
                            {
                                Toast.makeText(getApplicationContext(), "Ayam tidak bisa bersama dengan padi", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            else if(((ViewGroup)txtAnjing.getParent()) == perahuKanan)
                            {
                                Toast.makeText(getApplicationContext(), "Ayam tidak bisa bersama dengan anjing", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                            perahuKanan.addView(txtAyam);
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
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtKambing))
                            return false;

                        // start condition
                        if(((ViewGroup)txtKambing.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtSayuran.getParent()) == perahuKiri)
                            {
                                Toast.makeText(getApplicationContext(), "Kambing tidak bisa bersama dengan sayuran", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                            perahuKiri.addView(txtKambing);

                        }
                        else if(((ViewGroup)txtKambing.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                            seberangKiri.addView(txtKambing);
                        }
                        else if(((ViewGroup)txtKambing.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                            seberangKanan.addView(txtKambing);
                        }
                        else if(((ViewGroup)txtKambing.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            if(((ViewGroup)txtSayuran.getParent()) == perahuKanan)
                            {
                                Toast.makeText(getApplicationContext(), "Kambing tidak bisa bersama dengan sayuran", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                            perahuKanan.addView(txtKambing);
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
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtAnjing))
                            return false;

                        // start condition
                        if(((ViewGroup)txtAnjing.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtAyam.getParent()) == perahuKiri)
                            {
                                Toast.makeText(getApplicationContext(), "Anjing tidak bisa bersama dengan ayam", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                            perahuKiri.addView(txtAnjing);

                        }
                        else if(((ViewGroup)txtAnjing.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                            seberangKiri.addView(txtAnjing);
                        }
                        else if(((ViewGroup)txtAnjing.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                            seberangKanan.addView(txtAnjing);
                        }
                        else if(((ViewGroup)txtAnjing.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            if(((ViewGroup)txtAyam.getParent()) == perahuKanan)
                            {
                                Toast.makeText(getApplicationContext(), "Anjing tidak bisa bersama dengan ayam", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                            perahuKanan.addView(txtAnjing);
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
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtSayuran))
                            return false;

                        // start condition
                        if(((ViewGroup)txtSayuran.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtKambing.getParent()) == perahuKiri)
                            {
                                Toast.makeText(getApplicationContext(), "Sayuran tidak bisa bersama dengan kambing", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                            perahuKiri.addView(txtSayuran);

                        }
                        else if(((ViewGroup)txtSayuran.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                            seberangKiri.addView(txtSayuran);
                        }
                        else if(((ViewGroup)txtSayuran.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                            seberangKanan.addView(txtSayuran);
                        }
                        else if(((ViewGroup)txtSayuran.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            if(((ViewGroup)txtKambing.getParent()) == perahuKanan)
                            {
                                Toast.makeText(getApplicationContext(), "Sayuran tidak bisa bersama dengan kambing", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                            perahuKanan.addView(txtSayuran);
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
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtPadi))
                            return false;

                        // start condition
                        if(((ViewGroup)txtPadi.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            if(((ViewGroup)txtAyam.getParent()) == perahuKiri)
                            {
                                Toast.makeText(getApplicationContext(), "Padi tidak bisa bersama dengan ayam", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);
                            perahuKiri.addView(txtPadi);

                        }
                        else if(((ViewGroup)txtPadi.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);
                            seberangKiri.addView(txtPadi);
                        }
                        else if(((ViewGroup)txtPadi.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);
                            seberangKanan.addView(txtPadi);
                        }
                        else if(((ViewGroup)txtPadi.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            if(((ViewGroup)txtAyam.getParent()) == perahuKanan)
                            {
                                Toast.makeText(getApplicationContext(), "Padi tidak bisa bersama dengan ayam", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);
                            perahuKanan.addView(txtPadi);
                        }
                        return true;
                }

                return false;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout seberang;
                int count = sisiPerahuSekarang.getChildCount();
                // initialize current position
                if (letakPerahu.equals("kiri")) {
                    seberang = seberangKiri;
                    sisiPerahuSekarang = perahuKiri;
                } else {
                    seberang = seberangKanan;
                    sisiPerahuSekarang = perahuKanan;
                }

                if (count == 0) {
                    Toast.makeText(getApplicationContext(), "Tidak bisa menyebrang tidak ada objek", Toast.LENGTH_SHORT).show();
                    return;
                } else if (((ViewGroup) txtPetani.getParent()) != sisiPerahuSekarang) {
                    Toast.makeText(getApplicationContext(), "Petani perlu ada di kapal", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (((ViewGroup) txtAyam.getParent()) == seberang &&
                        ((ViewGroup) txtPadi.getParent()) == seberang) {
                    Toast.makeText(getApplicationContext(), "Ayam dan Padi tidak bisa bersama", Toast.LENGTH_SHORT).show();
                    return;
                } else if (((ViewGroup) txtAyam.getParent()) == seberang &&
                        ((ViewGroup) txtAnjing.getParent()) == seberang) {
                    Toast.makeText(getApplicationContext(), "Ayam dan Anjing tidak bisa bersama", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (((ViewGroup) txtKambing.getParent()) == seberang &&
                        ((ViewGroup) txtSayuran.getParent()) == seberang) {
                    Toast.makeText(getApplicationContext(), "Kambing dan Sayuran tidak bisa bersama", Toast.LENGTH_SHORT).show();
                    return;
                }


                btnCross.setEnabled(false);

                // pindah perahu ke kanan
                if (letakPerahu.equals("kiri")) {
                    TranslateAnimation animationboat = new TranslateAnimation(0, 320, 0, 0);
                    animationboat.setDuration(1000);
                    animationboat.setFillAfter(false);

                    perahuKiri.startAnimation(animationboat);
                    // move objects to right
                    for (int i = 0; count > i; i++) {
                        TranslateAnimation animationobjects = new TranslateAnimation(0, 0, 0, 0);
                        animationobjects.setDuration(1000);
                        animationobjects.setFillAfter(true);

                        TextView t = (TextView) sisiPerahuSekarang.getChildAt(i);
                        t.startAnimation(animationobjects);
                    }

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            perahuKiri.setVisibility(View.INVISIBLE);
                            perahuKanan.setVisibility(View.VISIBLE);
                        }
                    }, 1000);

                    // remove object from left and add object to right
                    for (int i = 0; count > i; i++) {
                        TextView t = (TextView) sisiPerahuSekarang.getChildAt(0);
                        ((ViewGroup) t.getParent()).removeView(t);
                        perahuKanan.addView(t);
                    }

                    letakPerahu = "kanan";
                    sisiPerahuSekarang = perahuKanan;
                } else // pindah perahu ke kiri
                {
                    TranslateAnimation animationboat = new TranslateAnimation(0, -320, 0, 0);
                    animationboat.setDuration(1000);
                    animationboat.setFillAfter(false);

                    perahuKanan.startAnimation(animationboat);
                    // move objects to left
                    for (int i = 0; count > i; i++) {
                        TranslateAnimation animationobjects = new TranslateAnimation(0, 0, 0, 0);
                        animationobjects.setDuration(1000);
                        animationobjects.setFillAfter(true);

                        TextView t = (TextView) sisiPerahuSekarang.getChildAt(i);
                        t.startAnimation(animationobjects);
                    }

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            perahuKanan.setVisibility(View.INVISIBLE);
                            perahuKiri.setVisibility(View.VISIBLE);
                        }
                    }, 1000);

                    // remove object from right and add object to left
                    for (int i = 0; count > i; i++) {
                        TextView t = (TextView) sisiPerahuSekarang.getChildAt(0);
                        ((ViewGroup) t.getParent()).removeView(t);
                        perahuKiri.addView(t);
                    }

                    letakPerahu = "kiri";
                    sisiPerahuSekarang = perahuKiri;
                }


                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        btnCross.setEnabled(true);
                    }
                }, 1000);

                // check if win
                if (seberangKiri.getChildCount() == 0) {
                    tryagain();
                }


            }
        });
    }

    public boolean checkCondition(TextView object)
    {
        ViewGroup parentObject = (ViewGroup)object.getParent();
        if(((parentObject == seberangKiri || parentObject == perahuKiri) && sisiPerahuSekarang == perahuKiri) ||
                ((parentObject == seberangKanan || parentObject == perahuKanan) && sisiPerahuSekarang == perahuKanan))
        {
            // jika kapal diisi oleh lebih dari 3 objek maka ditolak
            if((((ViewGroup)object.getParent()) == seberangKiri
                    || ((ViewGroup)object.getParent()) == seberangKanan)
                    && !checkPerahu())
                return false;

            // if condition is right then add step
            txtStep.setText(++step + "");
        }

        return true;
    }

    public boolean checkPerahu()
    {
        if(sisiPerahuSekarang.getChildCount() < 3)
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Perahu tidak bisa diisi lebih dari 3 objek", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void reset()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Reset ?");
        builder.setMessage("Coba lagi ?");


        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Code that is executed when clicking YES
                ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);

                seberangKiri.addView(txtPetani);
                seberangKiri.addView(txtAyam);
                seberangKiri.addView(txtKambing);
                seberangKiri.addView(txtSayuran);
                seberangKiri.addView(txtAnjing);
                seberangKiri.addView(txtPadi);

                sisiPerahuSekarang = perahuKiri;
                letakPerahu = "kiri";

                // hide perahu kanan
                perahuKanan.setVisibility(View.INVISIBLE);
                // show perahu kiri
                perahuKiri.setVisibility(View.VISIBLE);

                // reset step
                step = 0;
                txtStep.setText("0");

                dialog.dismiss();
            }

        });


        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Code that is executed when clicking NO
                dialog.dismiss();
            }

        });


        AlertDialog alert = builder.create();
        alert.show();
    }

    public void tryagain()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Try Again");
        builder.setMessage("You WIN Brooo, Try Again ?");


        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Code that is executed when clicking YES
                ((ViewGroup)txtPetani.getParent()).removeView(txtPetani);
                ((ViewGroup)txtAyam.getParent()).removeView(txtAyam);
                ((ViewGroup)txtKambing.getParent()).removeView(txtKambing);
                ((ViewGroup)txtSayuran.getParent()).removeView(txtSayuran);
                ((ViewGroup)txtAnjing.getParent()).removeView(txtAnjing);
                ((ViewGroup)txtPadi.getParent()).removeView(txtPadi);

                seberangKiri.addView(txtPetani);
                seberangKiri.addView(txtAyam);
                seberangKiri.addView(txtKambing);
                seberangKiri.addView(txtSayuran);
                seberangKiri.addView(txtAnjing);
                seberangKiri.addView(txtPadi);

                sisiPerahuSekarang = perahuKiri;
                letakPerahu = "kiri";

                // hide perahu kanan
                perahuKanan.setVisibility(View.INVISIBLE);
                // show perahu kiri
                perahuKiri.setVisibility(View.VISIBLE);

                // reset step
                step = 0;
                txtStep.setText("0");

                dialog.dismiss();
            }

        });


        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Code that is executed when clicking NO
                dialog.dismiss();

                System.exit(0);
            }

        });


        AlertDialog alert = builder.create();
        alert.show();
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
