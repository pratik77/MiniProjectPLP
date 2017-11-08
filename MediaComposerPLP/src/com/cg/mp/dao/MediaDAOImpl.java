package com.cg.mp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class MediaDAOImpl implements IMediaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public int checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

}
