package com.example.ace;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class NextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.android_listview);
		
		String usn = "";
		String sphone = "";
		String semail = "";
		String description = "";
		String location = "";
		String date = "";

		Intent intent = getIntent();
		Bundle extras = getIntent().getExtras();
		
			String[] info = extras.getStringArray(MainActivity.KEY_DATA);
			
		//	date = intent.getStringExtra(KEY_DATE);
			
	
			//
	/*	TextView headlineTxt = (TextView) findViewById(R.id.usntext);
		headlineTxt.setText(info[0]);
		//
		TextView headlineTxt1 = (TextView) findViewById(R.id.locationtext);
		headlineTxt1.setText(info[2]);
		
		TextView headlineTxt2 = (TextView) findViewById(R.id.datetext);
		headlineTxt2.setText(info[4]);
		
		//
		TextView headlineTxt3 = (TextView) findViewById(R.id.semailtext);
		headlineTxt3.setText(info[1]);
		
		TextView headlineTxt4 = (TextView) findViewById(R.id.sphonetext);
		headlineTxt4.setText(info[5]);
		
		
		*/
		ListView listView;
		listView = (ListView) findViewById(R.id.list);
		String s[]={"USN : "+info[0],"Location  :  "+info[4],"Date  :  "+info[5].substring(0, 8),"Time  :  "+info[5].substring(11),"Email id  :  "+info[2], "Contact no  :  "+info[1]};
		listView.setBackgroundResource(R.drawable.whatsapp);
		
		listView.setCacheColorHint(android.R.color.transparent);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, s);
		
		listView.setAdapter(adapter); 
      listView.setOnItemClickListener(new OnItemClickListener() {
      	 
      

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				
				// ListView Clicked item index
              int itemPosition     = position;
              
              // ListView Clicked item value
             // String  itemValue    = (String) listView.getItemAtPosition(position);
              
      
			}

     }); 
		
		
		
		
/*
		TextView pubdateTxt = (TextView) findViewById(R.id.pub_date);
		pubdateTxt.setText(pubDate);

		TextView descriptionTxt = (TextView) findViewById(R.id.description);
		descriptionTxt.setText(details);
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}