package com.example.ace;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public static final String KEY_SEMAIL = null;
	public static final String KEY_USN = null;
	public static final String KEY_SPHONE = null;
	public static final String KEY_DESCRIPTION = null;
	public static final String KEY_LOCATION = null;
	public static final String KEY_DATE = null;
	public static final String KEY_DATA = null;
	public int position1;
	
	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.android_listview);
		
		listView = (ListView) findViewById(R.id.list);
		
		listView.setBackgroundResource(R.drawable.whatsapp);
		listView.setCacheColorHint(android.R.color.transparent);
		
		Intent intent = getIntent();
		position1 = intent.getIntExtra(CategoryPage.KEY_VALUE, 0);
		
		/*
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		
		try{
		
		Toast.makeText(getBaseContext(), "Here atleast?", Toast.LENGTH_SHORT).show();
		//Create the HTTP request
		HttpParams httpParameters = new BasicHttpParams();

		//Setup timeouts
		HttpConnectionParams.setConnectionTimeout(httpParameters, 15000);
		HttpConnectionParams.setSoTimeout(httpParameters, 15000);			

		HttpClient httpclient = new DefaultHttpClient(httpParameters);
		HttpPost httppost = new HttpPost("http://pesitnotify.uphero.com/get_stuff.php");
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		String result = EntityUtils.toString(entity);
		
		// Create a JSON object from the request response
		JSONObject jsonObject = new JSONObject(result);
		*/
		 String result= "";
		 InputStream isr= null;
		 
		try{
			HttpClient httpclient=new DefaultHttpClient();
			
			if(position1==0)
			{
				HttpPost httppost= new HttpPost("http://pesitnotify.uphero.com/get_stuff_nfm.php");// your ip address  and php file name here 
				HttpResponse response=httpclient.execute(httppost);
				HttpEntity entity= response.getEntity();
				isr=entity.getContent();
			}
			else if(position1==1){
				HttpPost httppost= new HttpPost("http://pesitnotify.uphero.com/get_stuff_nfd.php");// your ip address  and php file name here 
				HttpResponse response=httpclient.execute(httppost);
				HttpEntity entity= response.getEntity();
				isr=entity.getContent();
			}
			else if(position1==2){
				HttpPost httppost= new HttpPost("http://pesitnotify.uphero.com/get_stuff_gn.php");// your ip address  and php file name here 
				HttpResponse response=httpclient.execute(httppost);
				HttpEntity entity= response.getEntity();
				isr=entity.getContent();
			}
				
			

		 
		  
		
		
		
		     BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
		     StringBuilder sb = new StringBuilder();
		     String line = null;
		     while ((line = reader.readLine()) != null) {
		             sb.append(line + "\n");
		     }
		     isr.close();

		     result=sb.toString();
		
		 
		
		
		
		
			 String s = "";
			 JSONArray jArray = new JSONArray(result);
			 final String usn[]=new String[jArray.length()];
			 final String sphone[]=new String[jArray.length()];
			 final String semail[]=new String[jArray.length()];
			 final String description[]=new String[jArray.length()];
			 final String location[]=new String[jArray.length()];
			 final String date[]=new String[jArray.length()];
			 int k=0;
			 for(int i=0; i<jArray.length();i++){
			        JSONObject json = jArray.getJSONObject(i);
			       k++;
			       usn[i]=json.getString("usn");
			       sphone[i]=json.getString("sphone");
			       semail[i]=json.getString("semail");
			       description[i]=json.getString("description");
			       location[i]=json.getString("location");
			       date[i]=json.getString("date");
			 }
			 //Toast.makeText(getBaseContext(), "It happened "+k+" times ", Toast.LENGTH_SHORT).show();

			

			
			
		
		/*
		

		//Retrieve the data from the JSON object
		String usn = jsonObject.getString("usn");
		String sphone = jsonObject.getString("sphone");
		String semail = jsonObject.getString("semail");
		String description = jsonObject.getString("description");
		String location = jsonObject.getString("location");
		String date = jsonObject.getString("date");
		
		
		*/
		
		/*
		TextView text1 = (TextView) findViewById(R.id.textView1);
		text1.setText(usn[0]);
		
		TextView text2 = (TextView) findViewById(R.id.textView2);
		text2.setText(usn[1]);
		
		TextView text3 = (TextView) findViewById(R.id.textView3);
		text3.setText(semail[0]);
		
		TextView text4 = (TextView) findViewById(R.id.textView4);
		text4.setText(semail[1]);
		*/
			   
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, description);

		
		// Assign adapter to ListView
        listView.setAdapter(adapter); 
        listView.setOnItemClickListener(new OnItemClickListener() {
        	 
        

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				String info[]={usn[position],sphone[position],semail[position],description[position],location[position],date[position]};
				Intent intent=new Intent(getBaseContext(),NextActivity.class);
                intent.putExtra(KEY_DATA, info);
                startActivity(intent);
				// ListView Clicked item index
                int itemPosition     = position;
                
                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                
                
                // Show Alert 
                
                
                	
                
			}

       }); 
		 }
		 catch (Exception e) {
				// TODO: handle exception
					Toast.makeText(getBaseContext(), "Oops. We've encountered an Error!", Toast.LENGTH_SHORT).show();
				   Log.e("log_tag", "Error Parsing Data "+e.toString());
				}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.menu_refresh:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            
        	Toast.makeText(getBaseContext(), "Refreshing...", Toast.LENGTH_SHORT).show();
            Intent next=new Intent(this,MainActivity.class);
            startActivity(next);
            return true;
        case R.id.menu_about:
        	Intent next1=new Intent(this,About.class);
            startActivity(next1);
            return true;
        	
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }

}
