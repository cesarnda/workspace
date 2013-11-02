package com.nevermind.entity.finder;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class AggregationOperator {

	@SerializedName("$contains")
	private Map<Object, Object> contains;

	public Map<Object, Object> getContains() {
		return contains;
	}

	public void setContains(Map<Object, Object> contains) {
		this.contains = contains;
	}
}
