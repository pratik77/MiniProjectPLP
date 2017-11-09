package com.cg.mp.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		map.addAttribute("username",username);
		userFlag=mediaService.checkLogin(username,password);
		System.out.println(userFlag);
		return userFlag;

	}
	

	@RequestMapping(value ="/retrieveAllComposer.obj")
	public String compSelect(@RequestParam("username") String username,Model model)
	{
		List<ComposerMasterDTO> composerList = mediaService.loadAllComposer();
		model.addAttribute("composerList",composerList);
		model.addAttribute("composerMasterDTO",new ComposerMasterDTO());
		return "ShowComposer";
	}
	
	@RequestMapping(value ="/modifyOrDelete.obj")
	public String compSelect(@RequestParam("submit") String submit,@RequestParam("composerId") String composerId,@ModelAttribute("composerMasterDTO") ComposerMasterDTO composerMasterDTO, Model model)
	{
		System.out.println(submit);
		System.out.println(composerId);
		
	
		System.out.println(composerMasterDTO);
		
		model.addAttribute("composerMasterDTO",composerMasterDTO);
		return "Composer";
	}
	
	@RequestMapping("/insertComposer.obj")
	public String add(Model model)
	{
		model.addAttribute("composer", new ComposerMasterDTO());
		return "AddComposer";
	}
	
	@RequestMapping(value ="/addComposer.obj",method= RequestMethod.POST)
	public String save(@ModelAttribute("composer") ComposerMasterDTO composer,Model model)
	{
		composer.setCreatedBy(userId);
		composer.setUpdatedBy(userId);
		LocalDate ldate=LocalDate.now();
		Date sqlDate = Date.valueOf(ldate);
		composer.setCreatedOn(sqlDate);
		composer.setUpdatedOn(sqlDate);
		ComposerMasterDTO composerCheck = mediaService.insertComposer(composer);
		model.addAttribute("message","Composer with Id "+composer.getComposerId()+" added successfully!");
		return "successComposer";	
	}


}
