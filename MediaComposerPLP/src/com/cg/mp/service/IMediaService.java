package com.cg.mp.service;

import java.util.List;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;


public interface IMediaService {
	List<ComposerMasterDTO> loadAllComposer();

	String checkLogin(int username, String password);

	List<SongMasterDTO> loadAllSongs();

	void compSongAssoc(int composerId, int[] songIdList, int userId);


}
