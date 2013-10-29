package com.nevermind.jse7.trywithresources;

public class ClosingResources {

	public static void main(String[] args) {
		try{
			new ClosingResources().useResource();
		}catch(Exception ex){
			System.out.println("Exception: " + ex.getMessage());
		}
	}
	
	
	public void useResource() throws Exception{
		try(MyReader myReader = new MyReader()){
			Class.forName("java.lang.JString");
		}
	}

}
