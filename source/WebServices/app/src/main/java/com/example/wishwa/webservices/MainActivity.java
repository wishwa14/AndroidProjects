package com.example.wishwa.webservices;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {
    //new thing
    public static final String TAG = MainActivity.class.getCanonicalName();

    TextView textView;
    String weather1;
    ProgressBar progressBar;
    Handler handler = new Handler();
    int progressstat=0;

    public String readJson(String url){
        StringBuilder stringBuilder = new StringBuilder();
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try{
            HttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statcode=statusLine.getStatusCode();
            if(statcode==200){
                HttpEntity entity = response.getEntity();
                InputStream input = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line;
                while((line=reader.readLine())!=null){
                    stringBuilder.append(line);
                }
                input.close();
            }   else{
                Log.d("JSON","Failed to get the content");
            }
        }catch (Exception e) {
            Toast.makeText(getBaseContext(),"No Location Inserted",Toast.LENGTH_SHORT).show();
            //filtering
            Log.d(TAG,e.getLocalizedMessage());
        }
        return stringBuilder.toString();
    }

    private class readWeather extends AsyncTask <String, Void ,String>{

        @Override
        protected String doInBackground(String... urls) {
            return readJson(urls[0]);
        }
        protected void onPostExecute(String result){
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONObject weather =new JSONObject(jsonObject.getString("weatherObservation"));
                weather1 = "Weather Station :\n " + weather.getString("stationName")+"\n\n"
                        + "Cloud Condition :\n " + weather.getString("clouds")+"\n\n"
                        + "Temperature : \n" + weather.getString("temperature") + " C";
                textView.setText(weather1);
            } catch (Exception e) {
                Log.d("readWeather",e.getLocalizedMessage());
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.weather);
        textView.setText("Welcome To Weather Reporter");

    }
    public void getweather(View view){
        progressBar=(ProgressBar)findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("Wait A Moment");
        new Thread(new Runnable() {
            public void run() {

                while (progressstat < 10) {
                    progressstat += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressstat);
                        }
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                EditText lat = (EditText) findViewById(R.id.lat);
                EditText lon = (EditText) findViewById(R.id.lon);

                new readWeather().execute(
                        "http://ws.geonames.org/findNearByWeatherJSON?lat=" +
                                lat.getEditableText().toString() + "&lng=" +
                                lon.getText().toString() + "&username=demo");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }
}
