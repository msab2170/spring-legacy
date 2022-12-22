package com.recsee.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recsee.report.dto.FileReadResult;
import com.recsee.report.dto.UserDto;
import com.recsee.report.service.UserService;
import com.recsee.report.vo.User;


@Controller
public class HomeController {
	
	@Autowired
	private final UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@GetMapping("/result")
	public String result() {
		return "/result";
	}
	
	@PostMapping("/file-upload")
	public String dbfileUpload(MultipartFile dbfile, RedirectAttributes redirect) {
		String message = "";
		System.out.print(dbfile);
		// System.out.print(redirect);
		try {
			FileReadResult result = userService.insertUsers(dbfile);
            if (result.getFailList().size() > 0) result.toJson();
           redirect.addFlashAttribute("result", result);
		} catch (Exception e) { 
			message = "파일 업로드에 실패했습니다."; 
		}
		
		redirect.addFlashAttribute("message", message);
		return "redirect:/result";
	}
	
	@ResponseBody
	@PostMapping("/showUsers")
	public List<UserDto> showAllUsers() {
		return userService.findAllUsers();
	}
	
}
