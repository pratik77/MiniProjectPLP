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

	List<ArtistMasterDTO> artistList=new ArrayList<>();
	List<ComposerMasterDTO> composerList=new ArrayList<>();
	List<SongMasterDTO> songList=new ArrayList<>();
	String userFlag,message="";
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

/*	@RequestMapping(value ="/retrieveComposerSong.obj")
	public String retrieveCompSong( Model model)
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		composerList = mediaService.loadAllComposer();
		songList = mediaService.loadAllSongs();
		model.addAttribute("composerList",composerList);
		model.addAttribute("songList",songList);
		return "composerSongAssoc";
	}
*/
	

	@RequestMapping(value ="/retrieveAllArtist.obj")
	public String artistSelect(Model model)
	{
		artistList = mediaService.loadAllArtists();
		model.addAttribute("artistList",artistList);
		model.addAttribute("artistMasterDTO",new ArtistMasterDTO());
		return "ShowArtist";
	}

	@RequestMapping(value ="/modifyOrDeleteArtist.obj")
	public String artistSelect(@RequestParam("submit") String submit,@RequestParam("artistId") int artistId,@ModelAttribute("artistMasterDTO") ArtistMasterDTO artistMasterDTO, Model model)
	{
		
		System.out.println(submit);
		System.out.println(artistId);	
		System.out.println(artistMasterDTO);
		
		if(("delete").equals(submit)){
		artistMasterDTO = mediaService.getArtistById(artistId);
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
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		mediaService.compSongAssoc(composerId,songIdList,userId);
		model.addAttribute("composerList",composerList);
		model.addAttribute("songList",songList);
		model.addAttribute("message","Composer and songs associated successfully");
		return "composerSongAssocSuccess";
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
	

}
