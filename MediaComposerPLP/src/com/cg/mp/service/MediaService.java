package com.cg.mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mp.dao.IMediaDAO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;



@Component("service")
public class MediaService implements IMediaService {
	
	
	@Autowired
	IMediaDAO	mediaDAO;
	
	int userFlag;
	
	@Override
	public String checkLogin(int username, String password) {
		// TODO Auto-generated method stub
		userFlag=mediaDAO.checkLogin(username,password);
		if(userFlag==1)
			return "admin";
		else if(userFlag==2)
			return "user";
		else
			return "errorLogin";
			
	}
	
	@Override
	public List<ComposerMasterDTO> loadAllComposer() 
	{
		return mediaDAO.loadAllComposer();
	}

	@Override
<<<<<<< HEAD
	public ComposerMasterDTO insertComposer(ComposerMasterDTO composer) {
		
		return mediaDAO.insertComposer(composer);
=======
	public List<SongMasterDTO> loadAllSongs() {
		// TODO Auto-generated method stub
		return mediaDAO.loadAllSongs();
>>>>>>> 0c6eab4e960ef7bb3faf779d7a5ef881aa1b51ad
	}


}
