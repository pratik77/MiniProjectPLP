package com.cg.mp.dao;

import java.util.List;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;

public interface IMediaDAO {


	List<ComposerMasterDTO> loadAllComposer();

	int checkLogin(int username, String password);
<<<<<<< HEAD
	
	ComposerMasterDTO insertComposer(ComposerMasterDTO composer);
=======
	List<SongMasterDTO> loadAllSongs();
>>>>>>> 0c6eab4e960ef7bb3faf779d7a5ef881aa1b51ad

}
