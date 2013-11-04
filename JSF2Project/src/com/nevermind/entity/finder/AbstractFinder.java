package com.nevermind.entity.finder;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mongodb.BasicDBObject;
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
	
	protected <T>List<T> getCollection(Class<T> type){
		DBCursor cursor = dbCollection.find();	
		List<T> result = new ArrayList<T>();
		while(cursor.hasNext()){
			result.add(jsonUtil.fromJSONToObject(cursor.next().toString(), type));
		}
		
		return result;
	}
	
	protected <T>List<T> getCollection(Class<T> type, Map<String, Integer> sortingOrder){
		BasicDBObject sort = new BasicDBObject();
		for(Entry<String, Integer> entry : sortingOrder.entrySet()){
			sort.append(entry.getKey(), entry.getValue());
		}
		DBCursor cursor = dbCollection.find().sort(sort);	
		List<T> result = new ArrayList<T>();
		while(cursor.hasNext()){
			result.add(jsonUtil.fromJSONToObject(cursor.next().toString(), type));
		}
		
		return result;
	}
	
	public void save(Object object){
		String queryString = jsonUtil.fromObjectToJSON(object);
		DBObject query = (DBObject)JSON.parse(queryString);
		dbCollection.save(query);	
	}
	
	public void updateByQuery(Object query, Map<String, Object> newValues){
		BasicDBObject updatedValues = new BasicDBObject();
		for(Entry<String, Object> entry : newValues.entrySet()){
			updatedValues.append(entry.getKey(), entry.getValue());
		}
		DBObject sortingSet = new BasicDBObject("$set", updatedValues);
		String queryString = jsonUtil.fromObjectToJSON(query);
		DBObject queryObject = (DBObject)JSON.parse(queryString);
		dbCollection.update(queryObject, sortingSet);
	}
	
	protected <T>T getRandomElement(Class<T> type){
		DBObject result = dbCollection.findOne();
		if(result == null){
			return null;
		}
		return jsonUtil.fromJSONToObject(result.toString(), type);
	}
}
