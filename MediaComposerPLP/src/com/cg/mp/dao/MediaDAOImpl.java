package com.cg.mp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.UserMasterDTO;


@Repository
@Transactional
public class MediaDAOImpl implements IMediaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public int checkLogin(int username, String password) {
		// TODO Auto-generated method stub
		
		TypedQuery<UserMasterDTO> query = entityManager.createQuery("SELECT userMasterDTO FROM UserMasterDTO "
				+ "userMasterDTO WHERE userMasterDTO.userId=:puserId AND userMasterDTO.userPassword=:puserPassword", UserMasterDTO.class);
		query.setParameter("puserId", username);
		query.setParameter("puserPassword", password);
		UserMasterDTO userMasterDTO = query.getSingleResult();
		return userMasterDTO.getUserFlag();
	}

	@Override
	public List<ComposerMasterDTO> loadAllComposer() {
		TypedQuery<ComposerMasterDTO> query = entityManager.createQuery("select c from ComposerMasterDTO c", ComposerMasterDTO.class);
		return query.getResultList();
	}



}
