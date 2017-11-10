package com.cg.mp.dao;

import java.util.List;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ArtistSongAssoc;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.ComposerSongAssoc;
import com.cg.mp.dto.SongMasterDTO;

public interface IMediaDAO {

	List<ComposerMasterDTO> loadAllComposer();

	List<ArtistMasterDTO> loadAllArtists();
	ArtistMasterDTO getArtistById(int artistId);
	ArtistMasterDTO deleteArtist(int artistId);

	int checkLogin(int username, String password);
	

	ComposerMasterDTO insertComposer(ComposerMasterDTO composer);


	List<SongMasterDTO> loadAllSongs();
	
	ComposerMasterDTO getComposerById(int composerId);
	
	ComposerMasterDTO updateComposer(ComposerMasterDTO composerMasterDTO);

	void compSongAssoc(ComposerSongAssoc composerSongAssoc);

	void artistSongAssoc(ArtistSongAssoc artistSongAssoc);

}
