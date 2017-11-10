package com.cg.mp.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mp.dao.IMediaDAO;
import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ArtistSongAssoc;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.ComposerSongAssoc;
import com.cg.mp.dto.SongMasterDTO;



@Component("service")
public class MediaService implements IMediaService {
	
	
	@Autowired
	IMediaDAO	mediaDAO;
	
	int userFlag;
	ComposerSongAssoc composerSongAssoc=new ComposerSongAssoc();
	ArtistSongAssoc artistSongAssoc=new ArtistSongAssoc();
	
	@Override
	public String checkLogin(int username, String password) {
		// TODO Auto-generated method stub
		userFlag=mediaDAO.checkLogin(username,password);
		if(userFlag==1)
			return "admin";
		else if(userFlag==2)
			return "user";
		else
			return "login";
			
	}
	
	@Override
	public List<ComposerMasterDTO> loadAllComposer() 
	{
		return mediaDAO.loadAllComposer();
	}

	@Override
	public ComposerMasterDTO insertComposer(ComposerMasterDTO composer) {
		
		return mediaDAO.insertComposer(composer);
	}
	@Override
	public List<SongMasterDTO> loadAllSongs() {
		
		return mediaDAO.loadAllSongs();

	}

	@Override
	public ComposerMasterDTO getComposerById(int composerId) {
		return mediaDAO.getComposerById(composerId);
	}

	@Override
	public ComposerMasterDTO updateComposer(ComposerMasterDTO composerMasterDTO) {
		return mediaDAO.updateComposer(composerMasterDTO);
	}

	@Override
	public void compSongAssoc(int composerId, int[] songIdList, int userId) {
		// TODO Auto-generated method stub
		for(int songId:songIdList)
		{
			composerSongAssoc.setComposerId(composerId);
			composerSongAssoc.setSongId(songId);
			composerSongAssoc.setCreatedBy(userId);
			composerSongAssoc.setCreatedOn(Date.valueOf(LocalDate.now()));
			composerSongAssoc.setUpdatedBy(userId);
			composerSongAssoc.setUpdatedOn(Date.valueOf(LocalDate.now()));
			mediaDAO.compSongAssoc(composerSongAssoc);
		}
	}
		

	public List<ArtistMasterDTO> loadAllArtists() {
		
		return mediaDAO.loadAllArtists();

	}

	@Override
	public ArtistMasterDTO getArtistById(int artistId) {
		
		return mediaDAO.getArtistById(artistId);
	}

	@Override
	public ArtistMasterDTO deleteArtist(int artistId) {
		
		return mediaDAO.deleteArtist(artistId);
	}

	@Override
	public void artistSongAssoc(int artistId, int[] songIdList, int userId) {
		// TODO Auto-generated method stub
		
		for(int songId:songIdList)
		{
		artistSongAssoc.setArtistId(artistId);
		artistSongAssoc.setSongId(songId);
		artistSongAssoc.setCreatedBy(userId);
		artistSongAssoc.setCreatedOn(Date.valueOf(LocalDate.now()));
		artistSongAssoc.setUpdatedBy(userId);
		artistSongAssoc.setUpdatedOn(Date.valueOf(LocalDate.now()));
		mediaDAO.artistSongAssoc(artistSongAssoc);
		}
		
	}


}
