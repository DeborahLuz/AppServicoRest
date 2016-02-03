package com.example.appservicorest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 Button calcularIMCButton = (Button) findViewById(R.id.calcularIMCButton);
	     calcularIMCButton.setOnClickListener((OnClickListener) this);
	}

	

	
}
