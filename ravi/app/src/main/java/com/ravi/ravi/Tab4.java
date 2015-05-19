package com.ravi.ravi;
/**
 * Created by Vinay Parashar on 15-05-2015.
 */

/**
 * Created by Vinay Parashar on 15-05-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Vinay Parashar on 15-05-2015.
 */
public class Tab4 extends Activity {
    TextView textView;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab4);
        addListenerOnButton1();


        Button btnPrefs = (Button) findViewById(R.id.btnPrefs);
        Button btnGetPrefs = (Button) findViewById(R.id.btnGetPreferences);

        textView = (TextView) findViewById(R.id.txtPrefs);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnPrefs:
                        Intent intent = new Intent(Tab4.this,
                                PrefsActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.btnGetPreferences:
                        displaySharedPreferences();
                        break;

                    default:
                        break;
                }
            }
        };

        btnPrefs.setOnClickListener(listener);
        btnGetPrefs.setOnClickListener(listener);
    }

    private void displaySharedPreferences() {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(Tab4.this);

        boolean checkBox = prefs.getBoolean("checkBox", false);
        String date = prefs.getString("date", "Default list prefs");
        String  color= prefs.getString("color", "Default list prefs");

        StringBuilder builder = new StringBuilder();
        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        builder.append("Date Formate is: " + date+"\n");
        builder.append("Color code is: " + color);

        textView.setText(builder.toString());
    }


    public void addListenerOnButton1() {

        final Context context1 = this;

        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(context1, Graph.class);
                startActivity(i);

            }

        });






    }


}