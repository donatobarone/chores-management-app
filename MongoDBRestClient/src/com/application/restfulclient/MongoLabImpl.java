package com.application.restfulclient;

import java.util.concurrent.ExecutionException;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MongoLabImpl implements MongoLabInterface{

	public static String TAG = "mymongolab.donato.barone";
	static String baseUrl = "https://api.mongolab.com/api/1/databases";
	String apiKey;    
	
	protected Gson gson;
	protected JsonParser jsonParser;
	
	private static MongoLabImpl mongoLabImpl;
	
	public static MongoLabImpl createInstance() {
		if (mongoLabImpl == null) {
			mongoLabImpl = new MongoLabImpl();
		}
		return mongoLabImpl;
	}
	

	private MongoLabImpl(){
		this.apiKey = "BaqHYkFSYkoL0HqQSrkDbXfvAo26NhXp";
    	gson = new Gson();
		jsonParser = new JsonParser();
	}
	
	@Override
	public void listDatabases(){
		MyHttpClientGET connector = new MyHttpClientGET(baseUrl + "?apiKey=" + this.apiKey);
		
		AsyncTask<String, String, String> connectTask = connector.execute();
		
		try {
			String result = connectTask.get();	
			JsonArray jsonResult = gson.fromJson(result, JsonArray.class);
			for(int i=0; i<jsonResult.size(); i++){
				String database = jsonResult.get(i).getAsString();
				Log.d(TAG, "Database #" + (i+1) + ": " + database);
			}					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // retrieve the result of the query.
	}
	
	@Override
	public void listCollections(String databaseName){
		MyHttpClientGET connector = new MyHttpClientGET(baseUrl + "/" + databaseName + "/collections?apiKey=" + this.apiKey);
		
		AsyncTask<String, String, String> connectTask = connector.execute();
		
		try {
			String result = connectTask.get();	
			JsonArray jsonResult = gson.fromJson(result, JsonArray.class);
			Log.d(TAG, "Database  " + databaseName);
			for(int i=0; i<jsonResult.size(); i++){
				String collection = jsonResult.get(i).getAsString();
				Log.d(TAG, "Collection #" + (i+1) + ": " + collection);
			}					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // retrieve the result of the query.
	
	}
	
	@Override
	public void listDocuments(String databaseName, String collectionName){
		MyHttpClientGET connector = new MyHttpClientGET(baseUrl + "/" + databaseName + "/collections/" + collectionName + "?apiKey=" + this.apiKey);
		
		AsyncTask<String, String, String> connectTask = connector.execute();
		
		try {
			String result = connectTask.get();	
			JsonArray jsonResult = gson.fromJson(result, JsonArray.class);
			Log.d(TAG, "Database  " + databaseName);
			Log.d(TAG, "Collection  " + collectionName);
			for(int i=0; i<jsonResult.size(); i++){
				JsonObject document = jsonResult.get(i).getAsJsonObject();
				Log.d(TAG, "Document #" + (i+1));
				DocumentModel documentModel = (DocumentModel)gson.fromJson(document, DocumentModel.class);
				Log.d(TAG, documentModel.toString());				
			}					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // retrieve the result of the query.
	
	}
	
	
	@Override
	public void insertDocument(String databaseName, String collectionName) {
		// TODO Auto-generated method stub
		// Dummy comment
		
		MyHttpClientPOST connector = new MyHttpClientPOST(baseUrl + "/" + databaseName + "/collections/" + collectionName + "?apiKey=" + this.apiKey);
		
		AsyncTask<String, String, String> connectTask = connector.execute();
		
		try {
			String result = connectTask.get();	
			Log.d(TAG, result);				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // retrieve the result of the query.
	}


	@Override
	public void insertDocuments() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateDocument() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateDocuments() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteDocument() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteDocuments() {
		// TODO Auto-generated method stub
		
	}
}
