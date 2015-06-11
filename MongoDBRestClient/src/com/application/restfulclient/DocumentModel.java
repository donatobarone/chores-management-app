package com.application.restfulclient;

import java.io.Serializable;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;


public class DocumentModel implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@SerializedName("_id")
	public Object id;
	
	@SerializedName("name")
	public String name;

	@SerializedName("lastname")
    public String lastname;// (optional) used for notifications

	@SerializedName("groupid")
    public JsonArray groupid;// (optional) used for notifications
	
	private String GroupToString(){
		String array = "[";
		for(int i=0; i<groupid.size(); i++){
			if(i!=0)
				array += ",";
			array += groupid.get(i).getAsString();
		}	
		array += "]";
		return array;
	}
	
	@Override
	public String toString() {
		return "DocumentModel {"
				+ " name=" + name
				+ ", lastname=" + lastname
				+ ", groupid=" + GroupToString()
				+ "}";
	}
}
