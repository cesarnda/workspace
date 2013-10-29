package com.nevermind.entity.finder;

import java.net.UnknownHostException;

import com.nevermind.entity.User;

public class UserFinder extends AbstractFinder {

	public UserFinder() throws UnknownHostException{
		super("users", "user");
	}
	
	public User getUniquerUser(String username){
		User user = new User();
		user.setUsername(username);
		return getUniqueElement(user, User.class);
	}
	
}
