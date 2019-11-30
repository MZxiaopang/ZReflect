package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpLoadController {

	@RequestMapping("UpDown.do")
	public String method(MultipartFile file1, HttpServletRequest req, HttpServletResponse rep) throws Exception {
		System.out.println("aaa");
		System.out.println(file1.getName());
//		String string = "D:\\" + System.currentTimeMillis() + file1.getOriginalFilename();

		return null;
	}

}
