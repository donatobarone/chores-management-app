package com.application.restfulclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

public class MyHttpClientPOST  extends AsyncTask<String, String, String> {
	
	private String url;

	public MyHttpClientPOST(String url) {
		this.url = url;
	}

	@Override
	protected String doInBackground(String... params) {
		String result = new String();

		try {

			URL url = new URL(this.url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			
			String bodyRequest = "{\"name\": \"Marco\", \"lastname\": \"Summa\", \"groupid\": [1, 2] }";
					
		    conn.setUseCaches (false);
		    conn.setDoInput(true);
		    conn.setDoOutput(true);

		    DataOutputStream wr = new DataOutputStream ( conn.getOutputStream ());
		    wr.writeBytes(bodyRequest);
		    wr.flush();
		    wr.close();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				result += output;
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return result;

	}

}