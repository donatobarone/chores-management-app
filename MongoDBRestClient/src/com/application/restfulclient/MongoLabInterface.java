package com.application.restfulclient;

public interface MongoLabInterface {
	
	void listDatabases();
	
	void listCollections(String databaseName);
	
	void listDocuments(String databaseName, String collectionName);
	
	void insertDocument(String databaseName, String collectionName);
	
	void insertDocuments();
	
	void updateDocument();
	
	void updateDocuments();
	
	void deleteDocument();
	
	void deleteDocuments();
	
//	Delete/replace multiple documents
//	View, update or delete a single document
	
	

}
