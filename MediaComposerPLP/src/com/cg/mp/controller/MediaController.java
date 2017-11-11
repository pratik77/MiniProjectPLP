package com.cg.mp.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;
import com.cg.mp.exception.MediaException;
import com.cg.mp.service.IMediaService;
/**
 * 
 * @author pratiksa
 *
 */
@Controller
public class MediaController {

	@Autowired
	private IMediaService mediaService;

<<<<<<< HEAD
	List<ArtistMasterDTO> artistList = new ArrayList<>();
	List<ComposerMasterDTO> composerList = new ArrayList<>();
	List<SongMasterDTO> songList = new ArrayList<>();

	String userFlag, message = "";
=======
	List<ComposerMasterDTO> composers = new ArrayList();
	List<SongMasterDTO> songs = new ArrayList();
	List<ArtistMasterDTO> artists = new ArrayList();
	String userFlag, message = "";
	ModelAndView checkPassword;
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820

	int userId;

	/**
	 * 
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/login.obj")
	public String checkLogin(@RequestParam("username") int username,
			@RequestParam("password") String password, Model model) {
		try {
			userFlag = mediaService.checkLogin(username, password);
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		userId = username;
		if (("login").equals(userFlag))
			model.addAttribute("message",
					"Invalid user ID and password combination.");
		return userFlag;

	}
	
	@RequestMapping(value = "/createAnAccount.obj")
	public String createAnAccount(Model model) {
		return "createAnAccount";

<<<<<<< HEAD
	@RequestMapping(value = "/retrieveAllComposer.obj")
	public String compSelect(Model model) {
		List<ComposerMasterDTO> composerList = mediaService.loadAllComposer();
		composerList = mediaService.loadAllComposer();
=======
	}
	
	@RequestMapping(value = "/accountCreation.obj")
	public ModelAndView accountCreation(@RequestParam("password") String password,
			@RequestParam("cpassword") String cpassword, Model model) {
		message="";
		try {
			checkPassword=mediaService.checkPassword(password, cpassword);
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			return new ModelAndView("mediaError","message",e.getMessage());
		}
		return checkPassword;

	}

	@RequestMapping(value = "/retrieveAllComposer.obj")
	public String compSelect(Model model) {
		List<ComposerMasterDTO> composerList;
		try {
			composerList = mediaService.loadAllComposer();
			composerList = mediaService.loadAllComposer();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
		model.addAttribute("composerList", composerList);
		model.addAttribute("composerMasterDTO", new ComposerMasterDTO());
		return "ShowComposer";
	}

<<<<<<< HEAD
	@RequestMapping(value = "/modifyOrDelete.obj")
=======
	@RequestMapping(value = "/modifyOrDelete.obj", method = RequestMethod.POST)
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
	public String modifyAndDeleteComposer(
			@RequestParam("submit") String submit,

			@RequestParam("composerId") String composerId,
			@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO,
			Model model) {
		switch (submit) {
		case "modify":
<<<<<<< HEAD
			composerMasterDTO = mediaService.getComposerById(composerMasterDTO
					.getComposerId());
			model.addAttribute("composerMasterDTO", composerMasterDTO);
			return "ModifyComposer";
		}
=======
			try {
				composerMasterDTO = mediaService.getComposerById(composerMasterDTO
						.getComposerId());
			} catch (MediaException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message",e.getMessage());
				return "mediaError";
			}
			model.addAttribute("composerMasterDTO", composerMasterDTO);
			return "ModifyComposer";
		case "delete":

		}

>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
		model.addAttribute("composerMasterDTO", composerMasterDTO);
		return "Composer";

	}

	@RequestMapping(value = "/insertComposer.obj")
	public String add(Model model) {
		model.addAttribute("composer", new ComposerMasterDTO());
		return "AddComposer";
	}

	@RequestMapping(value = "/addComposer.obj")
	public String save(@ModelAttribute("composer") ComposerMasterDTO composer,
			Model model) {
		composer.setCreatedBy(userId);
		composer.setUpdatedBy(userId);
		LocalDate ldate = LocalDate.now();
		Date sqlDate = Date.valueOf(ldate);
		composer.setCreatedOn(sqlDate);
		composer.setUpdatedOn(sqlDate);
		try {
			ComposerMasterDTO composerCheck = mediaService.insertComposer(composer);
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		model.addAttribute("message",
				"Composer with Id " + composer.getComposerId()
						+ " added successfully!");
		return "successComposer";
	}

<<<<<<< HEAD
	@RequestMapping(value = "/insertModifiedComposer.obj", method = RequestMethod.POST)
	public String modifyComposer(
			@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO,
			Model model) {
		composerMasterDTO.setCreatedBy(userId);
		System.out.println(composerMasterDTO.getComposerId());
		composerMasterDTO.setUpdatedBy(userId);
		LocalDate ldate = LocalDate.now();
		Date sqlDate = Date.valueOf(ldate);
		composerMasterDTO.setCreatedOn(sqlDate);
		composerMasterDTO.setUpdatedOn(sqlDate);
		ComposerMasterDTO composerCheck = mediaService
				.updateComposer(composerMasterDTO);
		model.addAttribute("message",
				"Composer with Id " + composerMasterDTO.getComposerId()
						+ " modified successfully!");
		return "successComposer";
=======
	@RequestMapping(value = "/retrieveComposerSong.obj")
	public String retrieveCompSong(Model model) {
		try {
			composers = mediaService.loadAllComposer();
			songs = mediaService.loadAllSongs();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		model.addAttribute("composerList", composers);
		model.addAttribute("songList", songs);
		return "composerSongAssoc";
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
	}

	@RequestMapping(value = "/retrieveAllArtist.obj")
	public String artistSelect(Model model) {

<<<<<<< HEAD
		List<ArtistMasterDTO> artistList = mediaService.loadAllArtists();
		artistList = mediaService.loadAllArtists();
		model.addAttribute("artistList", artistList);
		model.addAttribute("artistMasterDTO", new ArtistMasterDTO());
		return "ShowArtist";
=======
		try {
			artists = mediaService.loadAllArtists();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		model.addAttribute("artists", artists);
		model.addAttribute("artistMasterDTO", new ArtistMasterDTO());
		return "ShowComposer";

>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
	}

	@RequestMapping(value = "/modifyOrDeleteArtist.obj")
	public String artistSelect(@RequestParam("submit") String submit,
			@RequestParam("artistId") int artistId,
			@ModelAttribute("artistMasterDTO") ArtistMasterDTO artistMasterDTO,
			Model model) {
<<<<<<< HEAD

		if (("delete").equals(submit)) {
			artistMasterDTO = mediaService.getArtistById(artistId);
			model.addAttribute("artistMasterDTO", artistMasterDTO);
			artistMasterDTO = mediaService.deleteArtist(artistId);
			artistList = mediaService.loadAllArtists();
			model.addAttribute("artistList", artistList);
			model.addAttribute("artistMasterDTO", new ArtistMasterDTO());
			message = new String("Artist deleted!");
			model.addAttribute("message", message);
			return "ShowArtist";
		}

		if (("modify").equals(submit)) {
			artistMasterDTO = mediaService.getArtistById(artistId);
			model.addAttribute("artistMasterDTO", artistMasterDTO);
			return "ModifyArtist";
		}
		return "ShowArtist";
	}

	@RequestMapping(value = "/insertModifiedArtist.obj", method = RequestMethod.POST)
	public String modifyArtist(
			@ModelAttribute("artistMasterDTO") ArtistMasterDTO artistMasterDTO,
			Model model) {
		artistMasterDTO.setCreatedBy(userId);
		System.out.println(artistMasterDTO.getArtistId());
		artistMasterDTO.setUpdatedBy(userId);
		LocalDate ldate = LocalDate.now();
		Date sqlDate = Date.valueOf(ldate);
		artistMasterDTO.setCreatedOn(sqlDate);
		artistMasterDTO.setUpdatedOn(sqlDate);
		ArtistMasterDTO artistCheck = mediaService
				.updateArtist(artistMasterDTO);
		model.addAttribute("message",
				"Artist with Id " + artistMasterDTO.getArtistId()
						+ " modified successfully!");
		return "successArtist";
	}

	@RequestMapping("/insertArtist.obj")
	public String addArtist(Model model) {
		model.addAttribute("artistMasterDTO", new ArtistMasterDTO());
		return "AddArtist";
	}

	@RequestMapping(value = "/addArtist.obj", method = RequestMethod.POST)
	public String saveArtist(
			@ModelAttribute("artistMasterDTO") ArtistMasterDTO artistMasterDTO,
			Model model) {

		artistMasterDTO.setCreatedBy(userId);
		artistMasterDTO.setUpdatedBy(userId);
		LocalDate ldate = LocalDate.now();
		Date sqlDate = Date.valueOf(ldate);
		artistMasterDTO.setCreatedOn(sqlDate);
		artistMasterDTO.setUpdatedOn(sqlDate);
		ArtistMasterDTO artistCheck = mediaService
				.insertArtist(artistMasterDTO);
		model.addAttribute("message",
				"Artist with Id " + artistMasterDTO.getArtistId()
						+ " added successfully!");
		return "successArtist";
	}

	@RequestMapping(value = "/retrieveArtistSong.obj")
	public String retrieveArtistSong(Model model)

	{

		artistList = mediaService.loadAllArtists();
		songList = mediaService.loadAllSongs();
		model.addAttribute("artistList", artistList);
		model.addAttribute("songList", songList);
		return "artistSongAssoc";
	}

	@RequestMapping(value = "/composerSongAssoc.obj")
	public String compSongAssoc(@RequestParam("composerSelect") int composerId,
			@RequestParam("songSelect") int[] songIdList, Model model) {

		mediaService.compSongAssoc(composerId, songIdList, userId);
		model.addAttribute("composerList", composerList);
		model.addAttribute("songList", songList);
=======
		System.out.println(submit);
		System.out.println(artistId);
		System.out.println(artistMasterDTO);

		if (("delete").equals(submit)) {
			try {
				artistMasterDTO = mediaService.getArtistById(artistId);
				model.addAttribute("artistMasterDTO", artistMasterDTO);
				artistMasterDTO = mediaService.deleteArtist(artistId);
				artists = mediaService.loadAllArtists();
			} catch (MediaException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message",e.getMessage());
				return "mediaError";
			}
			model.addAttribute("artistList", artists);
			model.addAttribute("artistMasterDTO", new ArtistMasterDTO());
			message = new String("Artist deleted!");
			model.addAttribute("message", message);
		}
		return "ShowArtist";
	}

	/*
	 * @RequestMapping("/deleteArtist.obj") public String deleteArtist(){ return
	 * "deleteArtist"; }
	 * 
	 * @RequestMapping(value="/getArtistId.htm") public String
	 * getArtistId(@RequestParam("artistId") int artistId, Model model ){
	 * ArtistMasterDTO artistMasterDTO = mediaService.getArtistById(artistId);
	 * model.addAttribute("artistMasterDTO", artistMasterDTO); return
	 * "deleteArtist"; }
	 * 
	 * @RequestMapping(value="/delete.htm") public String
	 * delete(@RequestParam("artistId") int artistId, Model model){
	 * ArtistMasterDTO artistMasterDTO = mediaService.deleteArtist(artistId);
	 * 
	 * String message = null; if(artistMasterDTO==null){ message = new
	 * String("Artist not found"); }else{ message = new
	 * String("Artist deleted!"); }
	 * 
	 * model.addAttribute("message",message); return "ShowArtist"; }
	 */

	@RequestMapping(value = "/retrieveArtistSong.obj")
	public String retrieveArtistSong(Model model) {
		try {
			artists = mediaService.loadAllArtists();
			songs = mediaService.loadAllSongs();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		model.addAttribute("artistList", artists);
		model.addAttribute("songList", songs);
		return "artistSongAssoc";
	}

	@RequestMapping(value = "/insertModifiedComposer.obj", method = RequestMethod.POST)
	public String modifyComposer(
			@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO,
			Model model) {
		composerMasterDTO.setCreatedBy(userId);
		composerMasterDTO.setUpdatedBy(userId);
		LocalDate ldate = LocalDate.now();
		Date sqlDate = Date.valueOf(ldate);
		composerMasterDTO.setCreatedOn(sqlDate);
		composerMasterDTO.setUpdatedOn(sqlDate);
		try {
			ComposerMasterDTO composerCheck = mediaService
					.updateComposer(composerMasterDTO);
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
		model.addAttribute("message",
				"Composer and songs associated successfully");
		return "composerSongAssocSuccess";
	}

	@RequestMapping(value = "/artistSongAssoc.obj")
	public String artistSongAssoc(@RequestParam("artistSelect") int artistId,
			@RequestParam("songSelect") int[] songIdList, Model model)

	{
<<<<<<< HEAD

		mediaService.artistSongAssoc(artistId, songIdList, userId);
		model.addAttribute("artistList", artistList);
		model.addAttribute("songList", songList);
=======
		try {
			mediaService.artistSongAssoc(artistId, songIdList, userId);
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		model.addAttribute("artistList", artists);
		model.addAttribute("songList", songs);
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820
		model.addAttribute("message",
				"Artist and songs associated successfully");
		return "artistSongAssocSuccess";
	}
<<<<<<< HEAD

	public String retrieveCompSong(Model model) {

		composerList = mediaService.loadAllComposer();
		songList = mediaService.loadAllSongs();
		model.addAttribute("composerList", composerList);
		model.addAttribute("songList", songList);
		return "composerSongAssoc";
	}
=======

	@RequestMapping(value = "/composerSongAssoc.obj")
	public String compSongAssoc(@RequestParam("composerSelect") int composerId,
			@RequestParam("songSelect") int[] songIdList,
			@RequestParam("Associate") String associate, Model model) {
		if (("Associate").equals(associate)) {
			try {
				mediaService.compSongAssoc(composerId, songIdList, userId);
			} catch (MediaException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message",e.getMessage());
				return "mediaError";
			}
			model.addAttribute("composerList", composers);
			model.addAttribute("songList", songs);
			model.addAttribute("message",
					"Composer and songs associated successfully");
			return "composerSongAssocSuccess";
		}
		else
		{
			try {
				songs=mediaService.listAllSongsForComposer(composerId);
			} catch (MediaException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message",e.getMessage());
				return "mediaError";
			}
			if(songs.size()==0)
			{
				model.addAttribute("message",
						"No Songs related to the Composer found.");
				return "composerSongAssocSuccess";
			}
			else
			{
				model.addAttribute("songList", songs);
				model.addAttribute("composerId", composerId);
				return "composerSong";
			}
		}
	}
	
	@RequestMapping(value = "/retrieveComposerListForSongs.obj")
	public String retrieveComposerListForSongs(
			Model model)

	{		
		try {
			composers = mediaService.loadAllComposer();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		model.addAttribute("composerList", composers);
		return "retrieveComposerListForSongs";
		
	}
	
	@RequestMapping(value = "/listSongsForComposer.obj")
	public String listSongsForComposer(@RequestParam("composerSelect") int composerId,
			Model model)

	{
		try {
			songs=mediaService.listAllSongsForComposer(composerId);
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		if(songs.size()==0)
		{
			model.addAttribute("message",
					"No Songs related to the Composer found.");
			return "composerSongAssocSuccess";
		}
		else
		{
			model.addAttribute("songList", songs);
			model.addAttribute("composerId", composerId);
			return "listAllSongsForComposer";
		}
		
		
	}
	
	@RequestMapping(value = "/retrieveArtistListForSongs.obj")
	public String retrieveArtistListForSongs(
			Model model)

	{		
		try {
			artists = mediaService.loadAllArtists();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		model.addAttribute("artists", artists);
		return "retrieveArtistListForSongs";
		
	}
	
	@RequestMapping(value = "/listSongsForArtsist.obj")
	public String listSongsForArtsist(@RequestParam("artistSelect") int artistId,
			Model model)

	{
		try {
			songs=mediaService.listAllSongsForArtist(artistId);
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
			return "mediaError";
		}
		if(songs.size()==0)
		{
			model.addAttribute("message",
					"No Songs related to the Artist found.");
			return "artistSongAssocSuccess";
		}
		else
		{
			model.addAttribute("songs", songs);
			model.addAttribute("artistId", artistId);
			return "listAllSongsForArtist";
		}
		
		
	}
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820

}
