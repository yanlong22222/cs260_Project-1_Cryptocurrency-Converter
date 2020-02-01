package com.example.cryptocurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    EditText usd_edittext, btc_edittext, gbp_edittext, eur_edittext, cny_edittext, inr_edittext;
    Double usd, btc, gbp, eur, cny, inr;
    Button clear, convert;
    LinearLayout usd_layout, btc_layout, gbp_layout, eur_layout, cny_layout, inr_layout;
    Boolean lock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd_edittext = (EditText) findViewById(R.id.usd_edittext);
        btc_edittext = (EditText) findViewById(R.id.btc_edittext);
        gbp_edittext = (EditText) findViewById(R.id.gbp_edittext);
        eur_edittext = (EditText) findViewById(R.id.eur_edittext);
        cny_edittext = (EditText) findViewById(R.id.cny_edittext);
        inr_edittext = (EditText) findViewById(R.id.inr_edittext);


        usd_layout = (LinearLayout) findViewById(R.id.usDollor_linearlayout);
        btc_layout = (LinearLayout) findViewById(R.id.bitcoin_linearlayout);
        gbp_layout = (LinearLayout) findViewById(R.id.britishPound_linearlayout);
        eur_layout = (LinearLayout) findViewById(R.id.euro_linearlayout);
        cny_layout = (LinearLayout) findViewById(R.id.chineseYuan_linearlayout);
        inr_layout = (LinearLayout) findViewById(R.id.indianRupee_linearlayout);


        clear = (Button) findViewById(R.id.clearButton);
        convert = (Button) findViewById(R.id.convertButton);

        lock = false;


        //after input the number of usd, locks all the inputs and turns the background to grey
        usd_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock) {
                    usd = new Double(usd_edittext.getText().toString());
                    usd_edittext.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    usd_layout.setBackgroundColor(Color.parseColor("#E3E3E3"));
                    lockInput();
                }
            }
        });

        btc_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock) {
                    usd = new Double(btc_edittext.getText().toString())/0.000107259;
                    btc_edittext.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    btc_layout.setBackgroundColor(Color.parseColor("#E3E3E3"));
                    lockInput();
                }
            }

        });

        gbp_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock) {
                    usd = new Double(gbp_edittext.getText().toString())/0.768374;
                    gbp_edittext.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    gbp_layout.setBackgroundColor(Color.parseColor("#E3E3E3"));
                    lockInput();
                }
            }
        });

        eur_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock) {
                    usd = new Double(eur_edittext.getText().toString())/0.907920;
                    eur_edittext.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    eur_layout.setBackgroundColor(Color.parseColor("#E3E3E3"));
                    lockInput();
                }
            }
        });

        cny_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock) {
                    usd = new Double(cny_edittext.getText().toString())/6.93752;
                    cny_edittext.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    cny_layout.setBackgroundColor(Color.parseColor("#E3E3E3"));
                    lockInput();
                }
            }
        });

        inr_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lock) {
                    usd = new Double(inr_edittext.getText().toString())/71.4440;
                    inr_edittext.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    inr_layout.setBackgroundColor(Color.parseColor("#E3E3E3"));
                    lockInput();
                }
            }
        });


        //click the button to convert the currency
        convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                exchangeAll(usd);
                displayAll();
            }
        });

        //clear all the input
        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                usd = 0.00;
                exchangeAll(usd);
                setHintAll();
                clearColor();
                focusTrue();
                lock = false;
            }
        });

    }

    //convert
    public void exchangeAll(Double usd) {
        btc = usd * 0.000107259;
        gbp = usd * 0.768374;
        eur = usd * 0.907920;
        cny = usd * 6.93752;
        inr = usd * 71.4440;
    }

    //show the convert result
    public void displayAll() {
        usd_edittext.setText(String.format("%.2f", usd));
        btc_edittext.setText(String.format("%.2f", btc));
        gbp_edittext.setText(String.format("%.2f", gbp));
        eur_edittext.setText(String.format("%.2f", eur));
        cny_edittext.setText(String.format("%.2f", cny));
        inr_edittext.setText(String.format("%.2f", inr));
    }

    public void focusTrue() {
        usd_edittext.setFocusableInTouchMode(true);
        usd_edittext.setFocusable(true);
        btc_edittext.setFocusableInTouchMode(true);
        btc_edittext.setFocusable(true);
        gbp_edittext.setFocusableInTouchMode(true);
        gbp_edittext.setFocusable(true);
        eur_edittext.setFocusableInTouchMode(true);
        eur_edittext.setFocusable(true);
        cny_edittext.setFocusableInTouchMode(true);
        cny_edittext.setFocusable(true);
        inr_edittext.setFocusableInTouchMode(true);
        inr_edittext.setFocusable(true);
    }

    public void setHintAll() {
        usd_edittext.setText(null);
        btc_edittext.setText(null);
        gbp_edittext.setText(null);
        eur_edittext.setText(null);
        cny_edittext.setText(null);
        inr_edittext.setText(null);

        usd_edittext.setHint("0.00");
        btc_edittext.setHint("0.00");
        gbp_edittext.setHint("0.00");
        eur_edittext.setHint("0.00");
        cny_edittext.setHint("0.00");
        inr_edittext.setHint("0.00");
    }

    //after input number, lock every inputs
    public void lockInput() {
        usd_edittext.setFocusable(false);
        btc_edittext.setFocusable(false);
        gbp_edittext.setFocusable(false);
        gbp_edittext.setFocusable(false);
        eur_edittext.setFocusable(false);
        cny_edittext.setFocusable(false);
        inr_edittext.setFocusable(false);
        lock = true;
    }

    //clear the background color
    public void clearColor() {
        usd_layout.setBackgroundColor(Color.parseColor("#FAFAFA"));
        btc_layout.setBackgroundColor(Color.parseColor("#FAFAFA"));
        gbp_layout.setBackgroundColor(Color.parseColor("#FAFAFA"));
        eur_layout.setBackgroundColor(Color.parseColor("#FAFAFA"));
        cny_layout.setBackgroundColor(Color.parseColor("#FAFAFA"));
        inr_layout.setBackgroundColor(Color.parseColor("#FAFAFA"));
    }
}
