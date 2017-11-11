package com.cg.mp.service;

import java.util.List;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;


public interface IMediaService {
	List<ComposerMasterDTO> loadAllComposer();

	String checkLogin(int username, String password);

	ComposerMasterDTO insertComposer(ComposerMasterDTO composer);
	
	List<SongMasterDTO> loadAllSongs();


	void compSongAssoc(int composerId, int[] songIdList, int userId);

	List<ArtistMasterDTO> loadAllArtists();
	
	ArtistMasterDTO getArtistById(int artistId);
	
	ArtistMasterDTO deleteArtist(int artistId);
	
	ArtistMasterDTO insertArtist(ArtistMasterDTO artistMasterDTO);
	ArtistMasterDTO updateArtist(ArtistMasterDTO artistMasterDTO);
	
	ComposerMasterDTO getComposerById(int composerId);
	
	ComposerMasterDTO updateComposer(ComposerMasterDTO composerMasterDTO);

	void artistSongAssoc(int artistId, int[] songIdList, int userId);


}
