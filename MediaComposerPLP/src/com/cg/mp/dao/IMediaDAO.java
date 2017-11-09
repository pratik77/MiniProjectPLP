package com.cg.mp.dao;

import java.util.List;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.ComposerSongAssoc;
import com.cg.mp.dto.SongMasterDTO;

public interface IMediaDAO {


	List<ComposerMasterDTO> loadAllComposer();

	int checkLogin(int username, String password);
	List<SongMasterDTO> loadAllSongs();

	void compSongAssoc(ComposerSongAssoc composerSongAssoc);

}
