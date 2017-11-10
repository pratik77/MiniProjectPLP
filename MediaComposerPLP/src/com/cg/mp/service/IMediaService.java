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

<<<<<<< HEAD

=======
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632
	void compSongAssoc(int composerId, int[] songIdList, int userId);

	List<ArtistMasterDTO> loadAllArtists();
	
	ArtistMasterDTO getArtistById(int artistId);
	
	ArtistMasterDTO deleteArtist(int artistId);
<<<<<<< HEAD


=======
	
	ComposerMasterDTO getComposerById(int composerId);
	
	ComposerMasterDTO updateComposer(ComposerMasterDTO composerMasterDTO);

	void artistSongAssoc(int artistId, int[] songIdList, int userId);
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632

}
