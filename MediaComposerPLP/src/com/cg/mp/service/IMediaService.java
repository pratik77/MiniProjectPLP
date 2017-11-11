package com.cg.mp.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;
import com.cg.mp.exception.MediaException;


public interface IMediaService {
	List<ComposerMasterDTO> loadAllComposer()throws MediaException;

	String checkLogin(int username, String password)throws MediaException;

	ComposerMasterDTO insertComposer(ComposerMasterDTO composer)throws MediaException;
	
<<<<<<< HEAD
	List<SongMasterDTO> loadAllSongs();


	void compSongAssoc(int composerId, int[] songIdList, int userId);
=======
	List<SongMasterDTO> loadAllSongs()throws MediaException;

	void compSongAssoc(int composerId, int[] songIdList, int userId)throws MediaException;
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820

	List<ArtistMasterDTO> loadAllArtists()throws MediaException;
	
	ArtistMasterDTO getArtistById(int artistId)throws MediaException;
	
<<<<<<< HEAD
	ArtistMasterDTO deleteArtist(int artistId);
	
	ArtistMasterDTO insertArtist(ArtistMasterDTO artistMasterDTO);
	ArtistMasterDTO updateArtist(ArtistMasterDTO artistMasterDTO);
=======
	ArtistMasterDTO deleteArtist(int artistId)throws MediaException;
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
	
	ComposerMasterDTO getComposerById(int composerId)throws MediaException;
	
	ComposerMasterDTO updateComposer(ComposerMasterDTO composerMasterDTO)throws MediaException;

	void artistSongAssoc(int artistId, int[] songIdList, int userId)throws MediaException;

	List<SongMasterDTO> listAllSongsForComposer(int composerId)throws MediaException;

	List<SongMasterDTO> listAllSongsForArtist(int artistId)throws MediaException;

<<<<<<< HEAD
	void artistSongAssoc(int artistId, int[] songIdList, int userId);

=======
	ModelAndView checkPassword(String password, String cpassword)throws MediaException;
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820

}
