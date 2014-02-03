package com.example.ace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CategoryPage extends Activity{
	
	protected static final String KEY_VALUE = null;
	ListView listView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.android_listview);
		listView = (ListView) findViewById(R.id.list);
		String s[]={"Management","Department","General",};
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
				Intent intent=new Intent(getBaseContext(),MainActivity.class);
				intent.putExtra(KEY_VALUE, position);
                startActivity(intent);
				// ListView Clicked item index
                int itemPosition     = position;
                
                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                
        
			}

       });    
            
	}
	
	

}
