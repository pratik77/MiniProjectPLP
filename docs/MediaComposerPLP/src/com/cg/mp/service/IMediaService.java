package com.cg.mp.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

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
	
	ComposerMasterDTO getComposerById(int composerId);
	
	ComposerMasterDTO updateComposer(ComposerMasterDTO composerMasterDTO);

	void artistSongAssoc(int artistId, int[] songIdList, int userId);

	List<SongMasterDTO> listAllSongsForComposer(int composerId);

	List<SongMasterDTO> listAllSongsForArtist(int artistId);

	ModelAndView checkPassword(String password, String cpassword);

}
