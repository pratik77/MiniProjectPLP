package com.cg.mp.service;

import java.util.List;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;


public interface IMediaService {
	List<ComposerMasterDTO> loadAllComposer();

	String checkLogin(int username, String password);

	List<SongMasterDTO> loadAllSongs();

<<<<<<< HEAD
	void compSongAssoc(int composerId, int[] songIdList, int userId);

=======
	List<ArtistMasterDTO> loadAllArtists();
	ArtistMasterDTO getArtistById(int artistId);
	ArtistMasterDTO deleteArtist(int artistId);

	
>>>>>>> 84afec0bcdf7478964a7854248f0f3a9dbc21627

}
