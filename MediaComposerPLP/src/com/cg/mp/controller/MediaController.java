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
	public String checkLogin(@RequestParam("username") int username,
			@RequestParam("password") String password,
			Model map){
		
<<<<<<< HEAD
		String redirect;
		if(username.equals("bvk") && password.equalsIgnoreCase("bvk")){
			redirect = new String("admin");
		}else{
			redirect = new String("../../login");
		}
		return redirect;
=======
		userFlag=mediaService.checkLogin(username,password);
		System.out.println(userFlag);
		return userFlag;
>>>>>>> 80a29455bdb2a3469ad745514b82633c24c44222
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
