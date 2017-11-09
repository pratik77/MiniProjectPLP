package com.cg.mp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

	List<ComposerMasterDTO> composerList=new ArrayList();
	List<SongMasterDTO> songList=new ArrayList();
	String userFlag,message="";
=======
	
	List<ComposerMasterDTO> composerList = new ArrayList<>();
	List<SongMasterDTO> songList = new ArrayList<>();
	List<ArtistMasterDTO> artistList = new ArrayList<>();
	
	String userFlag;
>>>>>>> 84afec0bcdf7478964a7854248f0f3a9dbc21627
	int userId;

	@RequestMapping("/login.obj")
	public String checkLogin(@RequestParam("username") int username,
			@RequestParam("password") String password,
			Model map){

		userFlag=mediaService.checkLogin(username,password);
		System.out.println(userFlag);
		userId=username;
		return userFlag;

	}


	@RequestMapping(value ="/retrieveAllComposer.obj")
	public String compSelect(Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		composerList = mediaService.loadAllComposer();
		model.addAttribute("composerList",composerList);
		model.addAttribute("composerMasterDTO",new ComposerMasterDTO());
		return "ShowComposer";
	}

	@RequestMapping(value ="/modifyOrDelete.obj")
	public String compSelect(@RequestParam("submit") String submit,@RequestParam("composerId") String composerId,@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO, Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		System.out.println(submit);
		System.out.println(composerId);


		System.out.println(composerMasterDTO);

		model.addAttribute("composerMasterDTO",composerMasterDTO);
		return "Composer";
	}

	@RequestMapping(value ="/retrieveComposerSong.obj")
	public String retrieveCompSong( Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		composerList = mediaService.loadAllComposer();
		songList = mediaService.loadAllSongs();
		model.addAttribute("composerList",composerList);
		model.addAttribute("songList",songList);
		return "composerSongAssoc";
	}
<<<<<<< HEAD

=======
	
<<<<<<< HEAD
	@RequestMapping(value ="/retrieveAllArtist.obj")
	public String artistSelect(Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		artistList = mediaService.loadAllArtists();
		model.addAttribute("artistList",artistList);
		model.addAttribute("artistMasterDTO",new ArtistMasterDTO());
		return "ShowArtist";
	}
	
	@RequestMapping(value ="/modifyOrDeleteArtist.obj")
	public String artistSelect(@RequestParam("submit") String submit,@RequestParam("artistId") String artistId,@ModelAttribute("artistMasterDTO") ArtistMasterDTO artistMasterDTO, Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		System.out.println(submit);
		System.out.println(artistId);
		
		System.out.println(artistMasterDTO);
		
		model.addAttribute("artistMasterDTO",artistMasterDTO);
		return "Artist";
	}
=======
>>>>>>> 84afec0bcdf7478964a7854248f0f3a9dbc21627
	@RequestMapping(value ="/composerSongAssoc.obj")
	public String compSongAssoc( @RequestParam("composerSelect")int composerId,
			@RequestParam("songSelect")int[] songIdList,Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		mediaService.compSongAssoc(composerId,songIdList,userId);
		model.addAttribute("composerList",composerList);
		model.addAttribute("songList",songList);
		model.addAttribute("message","Composer and songs associated successfully");
		return "composerSongAssocSuccess";
	}
	
<<<<<<< HEAD
	@RequestMapping(value ="/retrieveArtistSong.obj")
	public String artistSongAssoc( @RequestParam("composerSelect")int composerId,
			@RequestParam("songSelect")int[] songIdList,Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		mediaService.compSongAssoc(composerId,songIdList,userId);
		model.addAttribute("composerList",composerList);
		model.addAttribute("songList",songList);
		model.addAttribute("message","Composer and songs associated successfully");
		return "composerSongAssocSuccess";
	}

=======
>>>>>>> 0c6eab4e960ef7bb3faf779d7a5ef881aa1b51ad
>>>>>>> 84afec0bcdf7478964a7854248f0f3a9dbc21627


}
