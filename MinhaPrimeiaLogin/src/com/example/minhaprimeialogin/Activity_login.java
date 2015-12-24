package com.example.minhaprimeialogin;

import java.net.HttpURLConnection;
import java.nio.channels.AsynchronousCloseException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_login extends Activity implements OnClickListener {
	
	EditText UsaNome, UsaPassword;
    Button buttonLogin; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		UsaNome = (EditText)findViewById(R.id.editNome);
	    UsaPassword = (EditText)findViewById(R.id.editPassword);
	    buttonLogin = (Button)findViewById(R.id.buttonLogin);
	    buttonLogin.setOnClickListener(this);

	}

	@Override
	public void onClick(View sender) {
		if(sender.getId() == R.id.buttonLogin){
			Teslogin login = new Teslogin();
			login.execute("http://");
		}
		
	}
	
	private class Teslogin extends AsyncTask<String, Void,
	HttpURLConnection>{
		
		ProgressDialog dialog = new ProgressDialog(Activity_login.this);
		
		@Override
		protected void onPreExecute(){
			dialog.setMessage("message");
			dialog.show();
		}
		
		Boolean result = false;
		
		@Override
		protected HttpURLConnection doInBackground(String... params) {
			HttpURLConnection connection = null;
			Log.i("MainActivity: ", "doInBackGround");
			
			try {
				connection = HttpService.sendPostRequest("servicoservlet");
				
			} catch (Exception e) {
				
			}
			
			return null;
		}
		
		
		protected void onPostExecte(HttpURLConnection connection) {
			
			Log.i("MainActivity:", "onPostExecute");
			if (result == true){
			Toast.makeText(Activity_login.this, "Data Inserted", Toast.LENGTH_LONG).show();
		}
			else{
				Toast.makeText(Activity_login.this, "Mostra", Toast.LENGTH_LONG).show();
			}
			dialog.dismiss();
			
		}
		
	}
}
