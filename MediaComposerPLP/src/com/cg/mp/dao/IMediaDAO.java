package com.cg.mp.dao;

import java.util.List;

import com.cg.mp.dto.ComposerMasterDTO;

public interface IMediaDAO {

	int checkLogin(String username, String password);
	List<ComposerMasterDTO> loadAllComposer();

}
