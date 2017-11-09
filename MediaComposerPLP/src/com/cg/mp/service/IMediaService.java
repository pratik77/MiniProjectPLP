package com.cg.mp.service;

import java.util.List;

import com.cg.mp.dto.ComposerMasterDTO;


public interface IMediaService {
	List<ComposerMasterDTO> loadAllComposer();

	String checkLogin(int username, String password);

	ComposerMasterDTO insertComposer(ComposerMasterDTO composer);

}
