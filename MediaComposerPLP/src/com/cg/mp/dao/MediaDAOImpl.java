package com.cg.mp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ArtistSongAssoc;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.ComposerSongAssoc;
import com.cg.mp.dto.SongMasterDTO;
import com.cg.mp.dto.UserMasterDTO;


@Repository
@Transactional
public class MediaDAOImpl implements IMediaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	UserMasterDTO userMasterDTO=new UserMasterDTO();
	
	@Override
	public int checkLogin(int username, String password) {

		TypedQuery<UserMasterDTO> query = entityManager.createQuery("SELECT userMasterDTO FROM UserMasterDTO "
				+ "userMasterDTO WHERE userMasterDTO.userId=:puserId AND userMasterDTO.userPassword=:puserPassword", UserMasterDTO.class);
		query.setParameter("puserId", username);
		query.setParameter("puserPassword", password);
		List<UserMasterDTO> userMasterList = query.getResultList();
		if(userMasterList.size()==0)
			return 3;
		return userMasterList.get(0).getUserFlag();
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
	public ComposerMasterDTO insertComposer(ComposerMasterDTO composer) {
		entityManager.persist(composer);
		entityManager.flush();
		return composer;
	}

	@Override
	public ComposerMasterDTO getComposerById(int composerId) {
		ComposerMasterDTO composer = entityManager.find(ComposerMasterDTO.class, composerId);
		return composer;
	}

	@Override
	public ComposerMasterDTO updateComposer(ComposerMasterDTO composerMasterDTO) {
		composerMasterDTO = entityManager.merge(composerMasterDTO);
		entityManager.flush();
		return composerMasterDTO;
	}

	public void compSongAssoc(ComposerSongAssoc composerSongAssoc) {
		
		entityManager.persist(composerSongAssoc);
		entityManager.flush();
	}
	
	@Override
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
		ArtistMasterDTO artistMasterDTO = entityManager.find(ArtistMasterDTO.class, artistId);
		entityManager.remove(artistMasterDTO);
		return artistMasterDTO;
	}

	@Override
	public void artistSongAssoc(ArtistSongAssoc artistSongAssoc) {
		// TODO Auto-generated method stub
		entityManager.persist(artistSongAssoc);
		entityManager.flush();
	}

}
