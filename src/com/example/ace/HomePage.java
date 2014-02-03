package com.example.ace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class HomePage extends Activity{
	
	Handler h =new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.homepage);
	h.postDelayed(r, 2000);
	
	}
	Runnable r=new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Intent intent=new Intent(getBaseContext(),CategoryPage.class);
			startActivity(intent);
		}
		
	};

}
