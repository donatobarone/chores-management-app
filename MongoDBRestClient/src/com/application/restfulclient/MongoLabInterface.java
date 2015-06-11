package com.application.restfulclient;

import com.google.gson.JsonObject;

public interface MongoLabInterface {
	
	void listDatabases();
	
	void listCollections(String databaseName);
	
	void listDocuments(String databaseName, String collectionName);
	
	void insertDocument(String databaseName, String collectionName);
	
	void insertDocuments();
	
	void updateDocument(String databaseName, String collectionName, JsonObject query, JsonObject update);
	
	void updateDocuments();
	
	void deleteDocument();
	
	void deleteDocuments();	

	void queryDocuments(String databaseName, String collectionName, JsonObject query);
	
//	Delete/replace multiple documents
//	View, update or delete a single document
	
	

}
