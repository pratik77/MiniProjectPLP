package com.cg.mp.dao;

import java.util.List;

import com.cg.mp.dto.ComposerMasterDTO;

public interface IMediaDAO {


	List<ComposerMasterDTO> loadAllComposer();

	int checkLogin(int username, String password);

}
