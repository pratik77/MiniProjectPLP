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

import com.cg.mp.dto.ArtistMasterDTO;
import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.dto.SongMasterDTO;
import com.cg.mp.service.IMediaService;

@Controller
public class MediaController {

	@Autowired
	private IMediaService mediaService;

	List<ComposerMasterDTO> composers = new ArrayList();
	List<SongMasterDTO> songs = new ArrayList();
	List<ArtistMasterDTO> artists = new ArrayList();
	String userFlag, message = "";

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
		userFlag = mediaService.checkLogin(username, password);
		userId = username;
		if (("login").equals(userFlag))
			model.addAttribute("message",
					"Invalid user ID and password combination.");
		return userFlag;

	}

	@RequestMapping(value = "/retrieveAllComposer.obj")
	public String compSelect(Model model) {
		List<ComposerMasterDTO> composerList = mediaService.loadAllComposer();
		composerList = mediaService.loadAllComposer();
		model.addAttribute("composerList", composerList);
		model.addAttribute("composerMasterDTO", new ComposerMasterDTO());
		return "ShowComposer";
	}

	@RequestMapping(value = "/modifyOrDelete.obj", method = RequestMethod.POST)
	public String modifyAndDeleteComposer(
			@RequestParam("submit") String submit,

			@RequestParam("composerId") String composerId,
			@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO,
			Model model) {
		switch (submit) {
		case "modify":
			composerMasterDTO = mediaService.getComposerById(composerMasterDTO
					.getComposerId());
			model.addAttribute("composerMasterDTO", composerMasterDTO);
			return "ModifyComposer";
		case "delete":

		}

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
		ComposerMasterDTO composerCheck = mediaService.insertComposer(composer);
		model.addAttribute("message",
				"Composer with Id " + composer.getComposerId()
						+ " added successfully!");
		return "successComposer";
	}

	@RequestMapping(value = "/retrieveComposerSong.obj")
	public String retrieveCompSong(Model model) {
		composers = mediaService.loadAllComposer();
		songs = mediaService.loadAllSongs();
		model.addAttribute("composerList", composers);
		model.addAttribute("songList", songs);
		return "composerSongAssoc";
	}

	@RequestMapping(value = "/retrieveAllArtist.obj")
	public String artistSelect(Model model) {

		artists = mediaService.loadAllArtists();
		model.addAttribute("artists", artists);
		model.addAttribute("artistMasterDTO", new ArtistMasterDTO());
		return "ShowComposer";

	}

	@RequestMapping(value = "/modifyOrDeleteArtist.obj")
	public String artistSelect(@RequestParam("submit") String submit,
			@RequestParam("artistId") int artistId,
			@ModelAttribute("artistMasterDTO") ArtistMasterDTO artistMasterDTO,
			Model model) {
		System.out.println(submit);
		System.out.println(artistId);
		System.out.println(artistMasterDTO);

		if (("delete").equals(submit)) {
			artistMasterDTO = mediaService.getArtistById(artistId);
			model.addAttribute("artistMasterDTO", artistMasterDTO);
			artistMasterDTO = mediaService.deleteArtist(artistId);
			artists = mediaService.loadAllArtists();
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
		artists = mediaService.loadAllArtists();
		songs = mediaService.loadAllSongs();
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
		ComposerMasterDTO composerCheck = mediaService
				.updateComposer(composerMasterDTO);
		model.addAttribute("message",
				"Composer with Id " + composerMasterDTO.getComposerId()
						+ " modified successfully!");
		return "successComposer";
	}

	@RequestMapping(value = "/artistSongAssoc.obj")
	public String artistSongAssoc(@RequestParam("artistSelect") int artistId,
			@RequestParam("songSelect") int[] songIdList, Model model)

	{
		mediaService.artistSongAssoc(artistId, songIdList, userId);
		model.addAttribute("artistList", artists);
		model.addAttribute("songList", songs);
		model.addAttribute("message",
				"Artist and songs associated successfully");
		return "artistSongAssocSuccess";
	}

	@RequestMapping(value = "/composerSongAssoc.obj")
	public String compSongAssoc(@RequestParam("composerSelect") int composerId,
			@RequestParam("songSelect") int[] songIdList,
			@RequestParam("Associate") String associate, Model model) {
		if (("Associate").equals(associate)) {
			mediaService.compSongAssoc(composerId, songIdList, userId);
			model.addAttribute("composerList", composers);
			model.addAttribute("songList", songs);
			model.addAttribute("message",
					"Composer and songs associated successfully");
			return "composerSongAssocSuccess";
		}
		else
		{
			songs=mediaService.listAllSongsForComposer(composerId);
			System.out.println(songs.size());
			for(SongMasterDTO song:songs)
			{System.out.println(song);}
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

}
