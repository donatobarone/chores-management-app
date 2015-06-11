package com.application.restfulclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

public class MyHttpClientGET extends AsyncTask<String, String, String> {
	
	private String url;

	public MyHttpClientGET(String url) {
		this.url = url;
	}

	@Override
	protected String doInBackground(String... params) {
		String result = new String();

		try {

//			URL url = new URL("https://api.mongolab.com/api/1/databases?apiKey=BaqHYkFSYkoL0HqQSrkDbXfvAo26NhXp");
			URL url = new URL(this.url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

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