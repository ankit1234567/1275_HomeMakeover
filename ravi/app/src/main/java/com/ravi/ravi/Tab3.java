package com.ravi.ravi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Vinay Parashar on 15-05-2015.
 */
public class Tab3 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview;
        textview = new TextView(this);
        textview.setText("This is tab3 tab");
        setContentView(textview);
    }
}