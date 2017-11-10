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

<<<<<<< HEAD
	List<ArtistMasterDTO> artistList=new ArrayList<>();
	List<ComposerMasterDTO> composerList=new ArrayList<>();
	List<SongMasterDTO> songList=new ArrayList<>();
=======
	List<ComposerMasterDTO> composerList=new ArrayList();
	List<SongMasterDTO> songList=new ArrayList();
	List<ArtistMasterDTO> artistList=new ArrayList();
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632
	String userFlag,message="";

	int userId;

	@RequestMapping("/login.obj")
	public String checkLogin(@RequestParam("username") int username,
			@RequestParam("password") String password, Model model) {
		model.addAttribute("username", username);
		userFlag = mediaService.checkLogin(username, password);
		System.out.println(userFlag);
		userId = username;
		if(("login").equals(userFlag))
			model.addAttribute("message","Invalid user ID and password combination.");
		return userFlag;

	}


	@RequestMapping(value = "/retrieveAllComposer.obj")
	public String compSelect(Model model) {
		List<ComposerMasterDTO> composerList = mediaService.loadAllComposer();
		// @ModelAttribute("composer") ComposerMasterDTO
		System.out.println(composerList);
		composerList = mediaService.loadAllComposer();
		model.addAttribute("composerList", composerList);
		model.addAttribute("composerMasterDTO", new ComposerMasterDTO());
		return "ShowComposer";
	}


	@RequestMapping(value = "/modifyOrDelete.obj")
	public String modifyAndDeleteComposer(
			@RequestParam("submit") String submit,
			@RequestParam("composerId") String composerId,
			@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO,
			Model model) {
		switch (submit) {
		case "modify":
			composerMasterDTO = mediaService.getComposerById(composerMasterDTO.getComposerId());
			model.addAttribute("composerMasterDTO", composerMasterDTO);
			return "ModifyComposer";
		}
		System.out.println(submit);
		System.out.println(composerId);

		System.out.println(composerMasterDTO);

		model.addAttribute("composerMasterDTO", composerMasterDTO);
		return "Composer";
	}

	@RequestMapping("/insertComposer.obj")
	public String add(Model model) {
		model.addAttribute("composer", new ComposerMasterDTO());
		return "AddComposer";
	}

	@RequestMapping(value = "/addComposer.obj", method = RequestMethod.POST)
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

	@RequestMapping(value ="/modifyOrDelete.obj")
	public String compSelect(@RequestParam("submit") String submit,@RequestParam("composerId") String composerId,@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO, Model model)
	{

		model.addAttribute("composerMasterDTO",composerMasterDTO);
		return "Composer";
	}

/*	@RequestMapping(value ="/retrieveComposerSong.obj")
	public String retrieveCompSong( Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		composerList = mediaService.loadAllComposer();
		songList = mediaService.loadAllSongs();
		model.addAttribute("composerList", composerList);
		model.addAttribute("songList", songList);
		return "composerSongAssoc";
	}
<<<<<<< HEAD
*/
	

	@RequestMapping(value ="/retrieveAllArtist.obj")
	public String artistSelect(Model model)
=======

	@RequestMapping(value ="/composerSongAssoc.obj")
	public String compSongAssoc( @RequestParam("composerSelect")int composerId,
			@RequestParam("songSelect")int[] songIdList,Model model)
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632
	{
		artistList = mediaService.loadAllArtists();
		model.addAttribute("artistList",artistList);
		model.addAttribute("artistMasterDTO",new ArtistMasterDTO());
		return "ShowArtist";
	}
<<<<<<< HEAD

=======
	
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632
	@RequestMapping(value ="/modifyOrDeleteArtist.obj")
	public String artistSelect(@RequestParam("submit") String submit,@RequestParam("artistId") int artistId,@ModelAttribute("artistMasterDTO") ArtistMasterDTO artistMasterDTO, Model model)
	{
<<<<<<< HEAD
		
		System.out.println(submit);
		System.out.println(artistId);	
		System.out.println(artistMasterDTO);
		
		if(("delete").equals(submit)){
		artistMasterDTO = mediaService.getArtistById(artistId);
=======
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632
		model.addAttribute("artistMasterDTO",artistMasterDTO);
		artistMasterDTO = mediaService.deleteArtist(artistId);
		artistList = mediaService.loadAllArtists();
		model.addAttribute("artistList",artistList);
		model.addAttribute("artistMasterDTO",new ArtistMasterDTO());
		message = new String("Artist deleted!");
		model.addAttribute("message",message);
		}
		return "ShowArtist";
	}
<<<<<<< HEAD


/*	@RequestMapping("/deleteArtist.obj")
	public String deleteArtist(){
		return "deleteArtist";
	}
	
	@RequestMapping(value="/getArtistId.htm")
	public String getArtistId(@RequestParam("artistId") int artistId, Model model ){		
		ArtistMasterDTO artistMasterDTO = mediaService.getArtistById(artistId);
		model.addAttribute("artistMasterDTO", artistMasterDTO);
		return "deleteArtist";
	}
	
	@RequestMapping(value="/delete.htm")
	public String delete(@RequestParam("artistId") int artistId, Model model){
		ArtistMasterDTO artistMasterDTO = mediaService.deleteArtist(artistId);
		
		String message = null;
		if(artistMasterDTO==null){
			message = new String("Artist not found");
		}else{
			message = new String("Artist deleted!");
		}
		
		model.addAttribute("message",message);
		return "ShowArtist";
	}
	
	*/
	
	@RequestMapping(value ="/retrieveArtistSong.obj")
	public String artistSongAssoc( @RequestParam("composerSelect")int composerId,

			@RequestParam("songSelect")int[] songIdList,Model model)
=======
	
	@RequestMapping(value ="/retrieveArtistSong.obj")
	public String retrieveArtistSong(Model model)
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		artistList = mediaService.loadAllArtists();
		songList = mediaService.loadAllSongs();
		model.addAttribute("artistList",artistList);
		model.addAttribute("songList",songList);
		return "artistSongAssoc";
	}

	@RequestMapping(value = "/insertModifiedComposer.obj", method = RequestMethod.POST)
	public String modifyComposer(@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO,
			Model model) {
		composerMasterDTO.setCreatedBy(userId);
		System.out.println(composerMasterDTO.getComposerId());
		composerMasterDTO.setUpdatedBy(userId);
		LocalDate ldate = LocalDate.now();
		Date sqlDate = Date.valueOf(ldate);
		composerMasterDTO.setCreatedOn(sqlDate);
		composerMasterDTO.setUpdatedOn(sqlDate);
		ComposerMasterDTO composerCheck = mediaService.updateComposer(composerMasterDTO);
		model.addAttribute("message",
				"Composer with Id " + composerMasterDTO.getComposerId()
						+ " modified successfully!");
		return "successComposer";
	}

<<<<<<< HEAD
	@RequestMapping(value ="/composerSongAssoc.obj")
	public String compSongAssoc( @RequestParam("composerSelect")int composerId,
			@RequestParam("songSelect")int[] songIdList,Model model)
=======
	@RequestMapping(value ="/artistSongAssoc.obj")
	public String artistSongAssoc( @RequestParam("artistSelect")int artistId,
			@RequestParam("songSelect")int[] songIdList,Model model)

	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		mediaService.artistSongAssoc(artistId,songIdList,userId);
		model.addAttribute("artistList",artistList);
		model.addAttribute("songList",songList);
		model.addAttribute("message","Artist and songs associated successfully");
		return "artistSongAssocSuccess";
	}
>>>>>>> 60fb09b6c90e815822f8b0483e723a19226ea632

	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		mediaService.compSongAssoc(composerId,songIdList,userId);
		model.addAttribute("composerList",composerList);
		model.addAttribute("songList",songList);
		model.addAttribute("message","Composer and songs associated successfully");
		return "composerSongAssocSuccess";
	}
	

}
