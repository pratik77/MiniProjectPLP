package com.cg.mp.service;

import java.util.List;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;


public interface IMediaService {
	List<ComposerMasterDTO> loadAllComposer();

	String checkLogin(int username, String password);

	List<SongMasterDTO> loadAllSongs();

	List<ArtistMasterDTO> loadAllArtists();
	ArtistMasterDTO getArtistById(int artistId);
	ArtistMasterDTO deleteArtist(int artistId);

	

}
