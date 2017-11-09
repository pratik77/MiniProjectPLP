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

	List<ComposerMasterDTO> composerList=new ArrayList();
	List<SongMasterDTO> songList=new ArrayList();
	List<ArtistMasterDTO> artistList=new ArrayList();
	String userFlag,message="";
	int userId;

	@RequestMapping("/login.obj")
	public String checkLogin(@RequestParam("username") int username,
			@RequestParam("password") String password,
			Model model){

		userFlag=mediaService.checkLogin(username,password);
		userId=username;
		if(("login").equals(userFlag))
			model.addAttribute("message","Invalid user ID and password combination.");
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

	@RequestMapping(value ="/retrieveArtistSong.obj")
	public String retrieveArtistSong(Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		artistList = mediaService.loadAllArtists();
		songList = mediaService.loadAllSongs();
		model.addAttribute("artistList",artistList);
		model.addAttribute("songList",songList);
		return "artistSongAssoc";
	}
	
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




}
