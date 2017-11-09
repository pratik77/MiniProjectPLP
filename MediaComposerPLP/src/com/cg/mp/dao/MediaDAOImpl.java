package com.cg.mp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.ComposerSongAssoc;
import com.cg.mp.dto.SongMasterDTO;
import com.cg.mp.dto.UserMasterDTO;


@Repository
@Transactional
public class MediaDAOImpl implements IMediaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int checkLogin(int username, String password) {

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


	@Override
	public List<SongMasterDTO> loadAllSongs() {

		TypedQuery<SongMasterDTO> query = entityManager.createQuery("select songs from SongMasterDTO songs", SongMasterDTO.class);
		return query.getResultList();
	}

	@Override
<<<<<<< HEAD
	public void compSongAssoc(ComposerSongAssoc composerSongAssoc) {
		// TODO Auto-generated method stub
		entityManager.persist(composerSongAssoc);
		entityManager.flush();
=======
	public List<ArtistMasterDTO> loadAllArtists() {

		TypedQuery<ArtistMasterDTO> query = entityManager.createQuery("select a from ArtistMasterDTO a", ArtistMasterDTO.class);
		return query.getResultList();
	}

	@Override
	public ArtistMasterDTO getArtistById(int artistId) {
		ArtistMasterDTO artistMasterDTO = new ArtistMasterDTO();
		TypedQuery<ArtistMasterDTO> query = entityManager.createQuery("select a from ArtistMasterDTO a where a.artistId=:partistId", ArtistMasterDTO.class);
		query.setParameter("partistId", artistId);
		artistMasterDTO = query.getSingleResult();
		return artistMasterDTO;
	}

	@Override
	public ArtistMasterDTO deleteArtist(int artistId) {
		
		return null;
>>>>>>> 84afec0bcdf7478964a7854248f0f3a9dbc21627
	}

}
