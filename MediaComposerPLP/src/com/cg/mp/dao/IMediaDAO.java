package com.cg.mp.dao;

import java.util.List;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;

public interface IMediaDAO {


	int checkLogin(String username, String password);
	List<ComposerMasterDTO> loadAllComposer();

	int checkLogin(int username, String password);
	List<SongMasterDTO> loadAllSongs();

}
