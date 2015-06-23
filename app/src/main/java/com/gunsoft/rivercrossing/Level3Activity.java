package com.gunsoft.rivercrossing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Level3Activity extends ActionBarActivity {

    TextView txtAnjingBesar, txtAnjingSedang, txtAnjingKecil, txtKucingBesar, txtKucingSedang, txtKucingKecil, txtStep;
    LinearLayout linearlayout, seberangKiri, perahuKiri, perahuKanan, seberangKanan, sisiPerahuSekarang;

    String letakPerahu = "kiri";

    int step = 0;

    int totalAnjingSeberangKiri = 3, totalAnjingSeberangKanan, totalKucingSeberangKiri = 3, totalKucingSeberangKanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // << hide title bar
        setContentView(R.layout.activity_level3);

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



        txtAnjingBesar = (TextView) findViewById(R.id.txtAnjingBesar);
        txtAnjingBesar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        //  check condition where boat where object in the same side
                        if(!checkCondition(txtAnjingBesar))
                            return false;

                        // start condition
                        if(((ViewGroup)txtAnjingBesar.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            ((ViewGroup)txtAnjingBesar.getParent()).removeView(txtAnjingBesar);
                            perahuKiri.addView(txtAnjingBesar);
                        }
                        else if(((ViewGroup)txtAnjingBesar.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtAnjingBesar.getParent()).removeView(txtAnjingBesar);
                            seberangKiri.addView(txtAnjingBesar);
                        }
                        else if(((ViewGroup)txtAnjingBesar.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtAnjingBesar.getParent()).removeView(txtAnjingBesar);
                            seberangKanan.addView(txtAnjingBesar);
                        }
                        else if(((ViewGroup)txtAnjingBesar.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtAnjingBesar.getParent()).removeView(txtAnjingBesar);
                            perahuKanan.addView(txtAnjingBesar);
                        }
                        return true;
                }

                return false;
            }
        });

        txtAnjingSedang = (TextView) findViewById(R.id.txtAnjingSedang);
        txtAnjingSedang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtAnjingSedang))
                            return false;


                        // start condition
                        if(((ViewGroup)txtAnjingSedang.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            ((ViewGroup)txtAnjingSedang.getParent()).removeView(txtAnjingSedang);
                            perahuKiri.addView(txtAnjingSedang);

                        }
                        else if(((ViewGroup)txtAnjingSedang.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtAnjingSedang.getParent()).removeView(txtAnjingSedang);
                            seberangKiri.addView(txtAnjingSedang);
                        }
                        else if(((ViewGroup)txtAnjingSedang.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtAnjingSedang.getParent()).removeView(txtAnjingSedang);
                            seberangKanan.addView(txtAnjingSedang);
                        }
                        else if(((ViewGroup)txtAnjingSedang.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtAnjingSedang.getParent()).removeView(txtAnjingSedang);
                            perahuKanan.addView(txtAnjingSedang);
                        }
                        return true;
                }

                return false;
            }
        });

        txtAnjingKecil = (TextView) findViewById(R.id.txtAnjingKecil);
        txtAnjingKecil.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtAnjingKecil))
                            return false;

                        // start condition
                        if(((ViewGroup)txtAnjingKecil.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            ((ViewGroup)txtAnjingKecil.getParent()).removeView(txtAnjingKecil);
                            perahuKiri.addView(txtAnjingKecil);

                        }
                        else if(((ViewGroup)txtAnjingKecil.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtAnjingKecil.getParent()).removeView(txtAnjingKecil);
                            seberangKiri.addView(txtAnjingKecil);
                        }
                        else if(((ViewGroup)txtAnjingKecil.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtAnjingKecil.getParent()).removeView(txtAnjingKecil);
                            seberangKanan.addView(txtAnjingKecil);
                        }
                        else if(((ViewGroup)txtAnjingKecil.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtAnjingKecil.getParent()).removeView(txtAnjingKecil);
                            perahuKanan.addView(txtAnjingKecil);
                        }
                        return true;
                }

                return false;
            }
        });

        txtKucingBesar = (TextView) findViewById(R.id.txtKucingBesar);
        txtKucingBesar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtKucingBesar))
                            return false;

                        // start condition
                        if(((ViewGroup)txtKucingBesar.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            ((ViewGroup)txtKucingBesar.getParent()).removeView(txtKucingBesar);
                            perahuKiri.addView(txtKucingBesar);

                        }
                        else if(((ViewGroup)txtKucingBesar.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtKucingBesar.getParent()).removeView(txtKucingBesar);
                            seberangKiri.addView(txtKucingBesar);
                        }
                        else if(((ViewGroup)txtKucingBesar.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtKucingBesar.getParent()).removeView(txtKucingBesar);
                            seberangKanan.addView(txtKucingBesar);
                        }
                        else if(((ViewGroup)txtKucingBesar.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtKucingBesar.getParent()).removeView(txtKucingBesar);
                            perahuKanan.addView(txtKucingBesar);
                        }
                        return true;
                }

                return false;
            }
        });

        txtKucingSedang = (TextView) findViewById(R.id.txtKucingSedang);
        txtKucingSedang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtKucingSedang))
                            return false;

                        // start condition
                        if(((ViewGroup)txtKucingSedang.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {
                            ((ViewGroup)txtKucingSedang.getParent()).removeView(txtKucingSedang);
                            perahuKiri.addView(txtKucingSedang);

                        }
                        else if(((ViewGroup)txtKucingSedang.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtKucingSedang.getParent()).removeView(txtKucingSedang);
                            seberangKiri.addView(txtKucingSedang);
                        }
                        else if(((ViewGroup)txtKucingSedang.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtKucingSedang.getParent()).removeView(txtKucingSedang);
                            seberangKanan.addView(txtKucingSedang);
                        }
                        else if(((ViewGroup)txtKucingSedang.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtKucingSedang.getParent()).removeView(txtKucingSedang);
                            perahuKanan.addView(txtKucingSedang);
                        }
                        return true;
                }

                return false;
            }
        });

        txtKucingKecil = (TextView) findViewById(R.id.txtKucingKecil);
        txtKucingKecil.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        // check condition where boat where object in the same side
                        if(!checkCondition(txtKucingKecil))
                            return false;

                        // start condition
                        if(((ViewGroup)txtKucingKecil.getParent()) == seberangKiri && letakPerahu.equals("kiri"))
                        {

                            ((ViewGroup)txtKucingKecil.getParent()).removeView(txtKucingKecil);
                            perahuKiri.addView(txtKucingKecil);

                        }
                        else if(((ViewGroup)txtKucingKecil.getParent()) == perahuKiri)
                        {
                            ((ViewGroup)txtKucingKecil.getParent()).removeView(txtKucingKecil);
                            seberangKiri.addView(txtKucingKecil);
                        }
                        else if(((ViewGroup)txtKucingKecil.getParent()) == perahuKanan)
                        {
                            ((ViewGroup)txtKucingKecil.getParent()).removeView(txtKucingKecil);
                            seberangKanan.addView(txtKucingKecil);
                        }
                        else if(((ViewGroup)txtKucingKecil.getParent()) == seberangKanan && letakPerahu.equals("kanan"))
                        {
                            ((ViewGroup)txtKucingKecil.getParent()).removeView(txtKucingKecil);
                            perahuKanan.addView(txtKucingKecil);
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
                }

                int anjingkiri = totalAnjingSeberangKiri, anjingkanan = totalAnjingSeberangKanan, kucingkiri = totalKucingSeberangKiri, kucingkanan = totalKucingSeberangKanan;
                for (int i = 0; sisiPerahuSekarang.getChildCount() > i; i++) {
                    TextView t = (TextView) sisiPerahuSekarang.getChildAt(i);
                    if (letakPerahu.equals("kiri")) {
                        if(t == txtAnjingBesar || t == txtAnjingSedang || t == txtAnjingKecil)
                        {
                            anjingkiri--;
                            anjingkanan++;
                        }
                        else
                        {
                            kucingkiri--;
                            kucingkanan++;
                        }
                    } else {
                        if(t == txtAnjingBesar || t == txtAnjingSedang || t == txtAnjingKecil)
                        {
                            anjingkiri++;
                            anjingkanan--;
                        }
                        else
                        {
                            kucingkiri++;
                            kucingkanan--;
                        }
                    }

                }
                if((kucingkiri < anjingkiri && kucingkiri != 0) || (kucingkanan < anjingkanan && kucingkanan != 0))
                {
                    Toast.makeText(getApplicationContext(), "Anjing tidak boleh lebih banyak daripada kucing", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (((ViewGroup) txtAnjingSedang.getParent()) == sisiPerahuSekarang &&
                        ((ViewGroup) txtAnjingBesar.getParent()) == sisiPerahuSekarang)
                {
                    Toast.makeText(getApplicationContext(), "Anjing sedang tidak bisa bersama dengan sejenisnya", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (((ViewGroup) txtAnjingSedang.getParent()) == sisiPerahuSekarang &&
                        ((ViewGroup) txtAnjingKecil.getParent()) == sisiPerahuSekarang)
                {
                    Toast.makeText(getApplicationContext(), "Anjing sedang tidak bisa bersama dengan sejenisnya", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (((ViewGroup) txtKucingSedang.getParent()) == sisiPerahuSekarang &&
                        ((ViewGroup) txtKucingBesar.getParent()) == sisiPerahuSekarang)
                {
                    Toast.makeText(getApplicationContext(), "Kucing sedang tidak bisa bersama dengan sejenisnya", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (((ViewGroup) txtKucingSedang.getParent()) == sisiPerahuSekarang &&
                        ((ViewGroup) txtKucingKecil.getParent()) == sisiPerahuSekarang)
                {
                    Toast.makeText(getApplicationContext(), "Kucing sedang tidak bisa bersama dengan sejenisnya", Toast.LENGTH_SHORT).show();
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

                        if(t == txtAnjingBesar || t == txtAnjingSedang || t == txtAnjingKecil)
                        {
                            totalAnjingSeberangKiri--;
                            totalAnjingSeberangKanan++;
                        }
                        else
                        {
                            totalKucingSeberangKiri--;
                            totalKucingSeberangKanan++;
                        }
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

                        if(t == txtAnjingBesar || t == txtAnjingSedang || t == txtAnjingKecil)
                        {
                            totalAnjingSeberangKiri++;
                            totalAnjingSeberangKanan--;
                        }
                        else
                        {
                            totalKucingSeberangKiri++;
                            totalKucingSeberangKanan--;
                        }
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
        if(sisiPerahuSekarang.getChildCount() < 2)
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Perahu tidak bisa diisi lebih dari 2 objek", Toast.LENGTH_SHORT).show();
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
                ((ViewGroup)txtAnjingBesar.getParent()).removeView(txtAnjingBesar);
                ((ViewGroup)txtAnjingSedang.getParent()).removeView(txtAnjingSedang);
                ((ViewGroup)txtAnjingKecil.getParent()).removeView(txtAnjingKecil);
                ((ViewGroup)txtKucingBesar.getParent()).removeView(txtKucingBesar);
                ((ViewGroup)txtKucingSedang.getParent()).removeView(txtKucingSedang);
                ((ViewGroup)txtKucingKecil.getParent()).removeView(txtKucingKecil);

                seberangKiri.addView(txtAnjingBesar);
                seberangKiri.addView(txtAnjingSedang);
                seberangKiri.addView(txtAnjingKecil);
                seberangKiri.addView(txtKucingBesar);
                seberangKiri.addView(txtKucingSedang);
                seberangKiri.addView(txtKucingKecil);

                sisiPerahuSekarang = perahuKiri;
                letakPerahu = "kiri";

                // hide perahu kanan
                perahuKanan.setVisibility(View.INVISIBLE);
                // show perahu kiri
                perahuKiri.setVisibility(View.VISIBLE);

                // reset step
                step = 0;
                txtStep.setText("0");

                totalAnjingSeberangKiri = 3;
                totalAnjingSeberangKanan = 0;
                totalKucingSeberangKiri = 3;
                totalKucingSeberangKanan = 0;

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
                ((ViewGroup)txtAnjingBesar.getParent()).removeView(txtAnjingBesar);
                ((ViewGroup)txtAnjingSedang.getParent()).removeView(txtAnjingSedang);
                ((ViewGroup)txtAnjingKecil.getParent()).removeView(txtAnjingKecil);
                ((ViewGroup)txtKucingBesar.getParent()).removeView(txtKucingBesar);
                ((ViewGroup)txtKucingSedang.getParent()).removeView(txtKucingSedang);
                ((ViewGroup)txtKucingKecil.getParent()).removeView(txtKucingKecil);

                seberangKiri.addView(txtAnjingBesar);
                seberangKiri.addView(txtAnjingSedang);
                seberangKiri.addView(txtAnjingKecil);
                seberangKiri.addView(txtKucingBesar);
                seberangKiri.addView(txtKucingSedang);
                seberangKiri.addView(txtKucingKecil);

                sisiPerahuSekarang = perahuKiri;
                letakPerahu = "kiri";

                // hide perahu kanan
                perahuKanan.setVisibility(View.INVISIBLE);
                // show perahu kiri
                perahuKiri.setVisibility(View.VISIBLE);

                // reset step
                step = 0;
                txtStep.setText("0");

                totalAnjingSeberangKiri = 3;
                totalAnjingSeberangKanan = 0;
                totalKucingSeberangKiri = 3;
                totalKucingSeberangKanan = 0;


                dialog.dismiss();
            }

        });


        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Code that is executed when clicking NO
                dialog.dismiss();

                Intent intent = new Intent(Level3Activity.this, MenuActivity.class);
                startActivity(intent);
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
