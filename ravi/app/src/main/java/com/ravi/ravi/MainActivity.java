package com.ravi.ravi;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
		
		// Android tab
		Intent intent1 = new Intent().setClass(this, Tab1.class);
		TabSpec tabSpec1= tabHost
			.newTabSpec("Android")
			.setIndicator("", ressources.getDrawable(R.drawable.ic_launcher))
			.setContent(intent1);

		// Apple tab
		Intent intent2 = new Intent().setClass(this, Tab2.class);
		TabSpec tabSpec2 = tabHost
			.newTabSpec("Apple")
			.setIndicator("", ressources.getDrawable(R.drawable.ic_launcher))
			.setContent(intent2);
		
		// Windows tab
		Intent intent3 = new Intent().setClass(this,Tab3.class);
		TabSpec tabSpec3 = tabHost
			.newTabSpec("Windows")
			.setIndicator("", ressources.getDrawable(R.drawable.ic_launcher))
			.setContent(intent3);
		
		// Blackberry tab
		Intent intent4= new Intent().setClass(this,Tab4.class);
		TabSpec tabSpec4 = tabHost
			.newTabSpec("Berry")
			.setIndicator("", ressources.getDrawable(R.drawable.ic_launcher))
			.setContent(intent4);
	
		// add all tabs 
		tabHost.addTab(tabSpec1);
		tabHost.addTab(tabSpec2);
		tabHost.addTab(tabSpec3);
		tabHost.addTab(tabSpec4);
		
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(2);
	}

}