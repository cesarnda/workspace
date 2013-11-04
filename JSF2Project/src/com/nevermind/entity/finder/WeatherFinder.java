package com.nevermind.entity.finder;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.nevermind.entity.Weather;

public class WeatherFinder extends AbstractFinder{

	public WeatherFinder()
			throws UnknownHostException {
		super("weather", "data");
	}


	public List<Weather> getAllWeathers(){
		return getCollection(Weather.class);
	}
	
	public List<Weather> getAllWeathersSortedByStateAndTemperature(){
		Map<String, Integer> sortingOrder = new LinkedHashMap<String, Integer>();
		sortingOrder.put("State", 1);
		sortingOrder.put("Temperature", -1);
		return getCollection(Weather.class, sortingOrder);
	}
	
	public void updateMonthHigh(Weather weather){
		Weather weatherQuery = new Weather();
		weatherQuery.setState(weather.getState());
		weatherQuery.setTemperature(weather.getTemperature());
		
		Map<String, Object> newValues = new HashMap<String, Object>();
		newValues.put("month_high", true);
		
		updateByQuery(weatherQuery, newValues);
	}
	
}
