package com.nevermind.mongo.course;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nevermind.entity.Weather;
import com.nevermind.entity.finder.WeatherFinder;

public class MongoNodeHW21 {

	public static void main(String[] args) throws UnknownHostException{
		MongoNodeHW21 mongoNodeHW21 = new MongoNodeHW21();
		mongoNodeHW21.start();
	}
	
	public void start() throws UnknownHostException{
		WeatherFinder weatherFinder = new WeatherFinder();
		List<Weather> weathers = weatherFinder.getAllWeathersSortedByStateAndTemperature();
		Map<String, List<Weather>> weathersByState = groupWeathersByState(weathers);
		assignMonthHighFlag(weathersByState);
		for(List<Weather> groupedWeathers : weathersByState.values()){
			for (Weather weather : groupedWeathers) {
				if(Boolean.TRUE.equals(weather.getMonthHigh())){
					weatherFinder.updateMonthHigh(weather);
				}
			}
		}
	}
	
	public void assignMonthHighFlag(Map<String, List<Weather>> weathersByState){
		for(List<Weather> weathers : weathersByState.values()){
			//Collections.sort(weathers);
			Weather hightestTemperature = weathers.get(0);
			hightestTemperature.setMonthHigh(true);
			System.out.println("Highest temperature in " + hightestTemperature.getState() + " is " + hightestTemperature.getTemperature());
		}
	}
	
	public Map<String, List<Weather>> groupWeathersByState(List<Weather> weathers ){
		Map<String, List<Weather>> result = new HashMap<String, List<Weather>>();
		for (Weather weather : weathers) {
			List<Weather> weathersInMap = result.get(weather.getState());
			if(weathersInMap == null){
				weathersInMap = new ArrayList<Weather>();
				result.put(weather.getState(), weathersInMap);
			}
			weathersInMap.add(weather);
		}
		return result;
	}

}
