package com.example.jayphoto;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Writer extends Activity implements OnClickListener {
	private Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_writer);
		
		button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button1:
			Intent intentWrite = new Intent(this, MainActivity.class);
			startActivity(intentWrite);
			break;

		}			
	}

}
