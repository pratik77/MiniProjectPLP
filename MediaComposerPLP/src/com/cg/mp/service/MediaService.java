package com.cg.mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mp.dao.IMediaDAO;


@Component("service")
public class MediaService implements IMediaService {

	@Autowired
	IMediaDAO	mediaDAO;
	
	int userFlag;
	
	@Override
	public String checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		userFlag=mediaDAO.checkLogin(username,password);
		if(userFlag==1)
			return "admin";
		else if(userFlag==2)
			return "user";
		else
			return "errorLogin";
			
	}

}
