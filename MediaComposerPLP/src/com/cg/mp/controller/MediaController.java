package com.cg.mp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.service.IMediaService;



@Controller
public class MediaController {
	
	@Autowired
	private IMediaService mediaService;
	
	String userFlag;
	
	@RequestMapping("/login.obj")
	public String checkLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model map){
		
		String redirect;
		if(username.equals("bvk") && password.equalsIgnoreCase("bvk")){
			redirect = new String("admin");
		}else{
			redirect = new String("../../login");
		}
		return redirect;
	}
	

	@RequestMapping(value ="/retrieveAllComposer.obj")
	public String compSelect()
	{
		//@ModelAttribute("composer") ComposerMasterDTO 
		List<ComposerMasterDTO> composerList = mediaService.loadAllComposer();
		System.out.println(composerList);
		//model.addAttribute("composerList",composerList);
		return "ShowComposer";
	}


}
