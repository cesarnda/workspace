package com.nevermind.entity;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Weather implements Serializable, Comparable<Weather>{
	
	private static final long serialVersionUID = 1L;
	
	@SerializedName("_id.$oid")
	private String id;
	private Double Day;
	private Double Time;
	private String State;
	private String Airport;
	private Double Temperature;
	private Double Humidity;
	
	@SerializedName("month_high")
	private Boolean monthHigh;
	
	@SerializedName("Wind Speed")
	private Double windSpeed;
	
	@SerializedName("Wind Direction")
	private String windDirection;

	@SerializedName("Station Pressure")
	private Double stationPressure;
	
	@SerializedName("Sea Level Pressure")
	private Double seaLevelPressure;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getDay() {
		return Day;
	}

	public void setDay(Double day) {
		Day = day;
	}

	public Double getTime() {
		return Time;
	}

	public void setTime(Double time) {
		Time = time;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getAirport() {
		return Airport;
	}

	public void setAirport(String airport) {
		Airport = airport;
	}

	public Double getTemperature() {
		return Temperature;
	}

	public void setTemperature(Double temperature) {
		Temperature = temperature;
	}

	public Double getHumidity() {
		return Humidity;
	}

	public void setHumidity(Double humidity) {
		Humidity = humidity;
	}

	public Boolean getMonthHigh() {
		return monthHigh;
	}

	public void setMonthHigh(Boolean monthHigh) {
		this.monthHigh = monthHigh;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public Double getStationPressure() {
		return stationPressure;
	}

	public void setStationPressure(Double stationPressure) {
		this.stationPressure = stationPressure;
	}

	public Double getSeaLevelPressure() {
		return seaLevelPressure;
	}

	public void setSeaLevelPressure(Double seaLevelPressure) {
		this.seaLevelPressure = seaLevelPressure;
	}

	@Override
	public int compareTo(Weather o) {
		// TODO Auto-generated method stub
		if(Temperature == null){
			return -1;
		}
		return Temperature.compareTo(o.getTemperature());
	}
}
