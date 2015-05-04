package in.sarnathkj.googlespreadsheet.post;

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	final String myTag = "DocsUpload";
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(myTag, "OnCreate()");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				postData();
				
			}
		});
		t.start();
	}

	

	public void postData() {

		String fullUrl = "https://docs.google.com/forms/d/1yd8oQb1TMtNDYYwkqgV78wTu8Fd9P3OGJSa1MCJoE9U/formResponse";
		HttpRequest mReq = new HttpRequest();
		String col1 = "Sarnath";
		
		String data = "entry.75015930=" + URLEncoder.encode(col1);
		String response = mReq.sendPost(fullUrl, data);
		Log.i(myTag, response);
	} 

}
