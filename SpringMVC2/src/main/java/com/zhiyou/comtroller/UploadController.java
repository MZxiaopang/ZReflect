package com.zhiyou.comtroller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.util.FTPUtil;

@Controller
public class UploadController {

	@RequestMapping("upload.do")
	public String upload(MultipartFile fileName, HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 文件类型
		System.out.println(fileName.getContentType());
		// 文件大小
		System.out.println(fileName.getSize());
		// 文件名称
		System.out.println(fileName.getName());
		// 原始名称
		System.out.println(fileName.getOriginalFilename());
		// 通过文件打开一个输入流
		InputStream in = fileName.getInputStream();
		// 指定文件存放的路径及文件名称
		String name = "D:/" + System.currentTimeMillis() + fileName.getOriginalFilename();
		// 根据文件需要存放路径获得一个输出流
		FileOutputStream out = new FileOutputStream(name);
		// 使用io工具放入输入流 输出流 让其自动实现文件copy
		IOUtils.copy(in, out);
		System.out.println("需要存放数据库的是问津路径及名称    " + name);
		in.close();
		out.close();
		return null;
	}

	@RequestMapping("upload2.do")
	public String upload2(MultipartFile fileName, HttpServletRequest req, HttpServletResponse res) throws Exception {
		String string = FTPUtil.upload(fileName.getInputStream(), fileName.getOriginalFilename());
		System.out.println(string);
		return null;
	}

	@RequestMapping("download.do")
	public String download(String name, HttpServletRequest req, HttpServletResponse rep) throws Exception {

		// 接受客户需要下载的图片名字，使用服务器地址 拼接上名字 组成图片路径
		String n = "C:\\Users\\Administrator\\Desktop\\" + name;
		// 根据图片路径打开一个输入流
		FileInputStream in = new FileInputStream(n);
		// 设置响应头信息，指定为文件下载
		rep.setHeader("content-disposition", "attachment;filename=123.png");
		// 根据响应获得一个输出流
		ServletOutputStream outputStream = rep.getOutputStream();
		// 考培图片
		IOUtils.copy(in, outputStream);
		outputStream.close();
		in.close();

		return null;
	}
}
