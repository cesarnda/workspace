package com.nevermind.entity.finder;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;
import com.nevermind.util.JSONUtil;

public abstract class AbstractFinder {

	private DBCollection dbCollection;
	private JSONUtil jsonUtil;
	
	protected AbstractFinder(String db, String collection) throws UnknownHostException{
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017 ));
		DB dataBase = mongoClient.getDB(db);
		dbCollection = dataBase.getCollection(collection);
		jsonUtil = new JSONUtil();
	}
	
	protected <T>T getUniqueElement(T object, Class<T> type){
		String queryString = jsonUtil.fromObjectToJSON(object);
		DBObject query = (DBObject)JSON.parse(queryString);
		DBObject result = dbCollection.findOne(query);
		
		if(result == null){
			return null;
		}
		
		return jsonUtil.fromJSONToObject(result.toString(), type);
	}
	
	protected <T>List<T> getCollectionByQuery(Object object, Class<T> type){
		String queryString = jsonUtil.fromObjectToJSON(object);
		DBObject query = (DBObject)JSON.parse(queryString);
		DBCursor cursor = dbCollection.find(query);	
		List<T> result = new ArrayList<T>();
		while(cursor.hasNext()){
			result.add(jsonUtil.fromJSONToObject(cursor.next().toString(), type));
		}
		
		return result;
	}
	
	protected <T>T getRandomElement(Class<T> type){
		DBObject result = dbCollection.findOne();
		if(result == null){
			return null;
		}
		return jsonUtil.fromJSONToObject(result.toString(), type);
	}
}
