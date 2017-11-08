package com.cg.mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.mp.service.IMediaService;



@Controller
public class MediaController {
	
	@Autowired
	private IMediaService mediaService;
	
	@RequestMapping("/login.obj")
	public String getMainPage(@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model map){
		String redirect;
		
		if(username.equals("bvk") && password.equalsIgnoreCase("bvk")){
			redirect = new String("traineemgtsys");
		}else{
			redirect = new String("../../login");
		}
		return redirect;
	}

}
