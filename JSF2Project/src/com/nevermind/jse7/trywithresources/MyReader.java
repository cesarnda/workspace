package com.nevermind.jse7.trywithresources;

public class MyReader implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new Exception("Exception from MyReader");
	}

}
