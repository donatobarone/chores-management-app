package com.application.restfulclient;

import java.io.Serializable;
import java.util.List;

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
	public List<Integer> groupid;// (optional) used for notifications
	
	DocumentModel(String name, String lastname, List<Integer> groupid){
		this.name = name;
		this.lastname = lastname;
		this.groupid = groupid;
	}

	private String GroupToString(){
		String array = "[";
		for(int i=0; i<groupid.size(); i++){
			if(i!=0)
				array += ",";
			array += groupid.get(i).toString();
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
