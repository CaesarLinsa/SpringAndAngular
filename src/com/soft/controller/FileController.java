package com.soft.controller;

import java.io.BufferedOutputStream;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.soft.entity.OPFile;
import com.soft.entity.Progress;
import com.soft.entity.ReturnBody;
import com.soft.entity.User;
import com.soft.service.IOPFileService;
import com.soft.service.UserService;
import com.soft.util.Log;


@Controller
@RequestMapping("/file")
public class FileController {
 
	@Resource
    private UserService us;	
	@Resource
	private IOPFileService ios;
	
 @RequestMapping(value="/upload",method=RequestMethod.POST)
 @ResponseBody
 public ReturnBody file_upload(@RequestParam(value = "file") MultipartFile file,@RequestParam(value="userName") String userName,HttpServletRequest request) throws IOException{
	 ReturnBody body=new ReturnBody();
	 Log.info(FileController.class, "start file upload......");
	 String file_src="D:\\my_program\\MeiPhoto\\user_file\\"+userName+"\\"+file.getOriginalFilename();
	 String filename=file.getOriginalFilename();
	 Integer file_user_id=null;
	 long filesize=file.getSize();
	 String size=null;
	 if(filesize/1024<1){
		 size=filesize+"B";
	 }
	 if(filesize/1024>=1){
		 filesize=filesize/1024;
		 size=filesize+"KB";
	 }
	 if(filesize/1024>=1){
		 filesize=filesize/1024;
		 size=filesize+"MB";
	 }
	 User user = us.findUserByUserName(userName);		 
	 if(user!=null){
		 file_user_id=user.getId();
		 Log.info(FileController.class, user.toString());
	 }else{
		 body.setMsg("请先登录后操作");
		 Log.info(FileController.class, user.toString());
		 return body;
	 }
	 OPFile file_info=new OPFile(filename, size, file_src, file_user_id);
	 File out_file =new File(file_src);
	 Log.info(FileController.class, file_info.toString());
	if(!out_file.getParentFile().exists()){
		out_file.getParentFile().mkdirs();
	}
	if(!out_file.exists()){
		out_file.createNewFile();
	}
    file.transferTo(out_file);
    body.setData(file_info);
    try {
		ios.addFile(file_info);
	} catch(Exception e) {
		Log.info(FileController.class, file_info.toString()+"  insert into database error");
	}
	Log.info(FileController.class, "filedate insert into database");
    Log.info(FileController.class, "finish file upload......");
	return body;
 }
 
    @RequestMapping(value="/upload/progress",method=RequestMethod.POST)
    @ResponseBody
    public String getProgress(HttpServletRequest request){
    	
    	Progress progress = (Progress)request.getSession().getAttribute("status");
    	if(progress!=null){
    	DecimalFormat df=new DecimalFormat(".00");
		String percents=df.format(progress.getBytesRead()*1.0/progress.getContentLength()*100); 
    	return percents;
    	}
    	return null;
    	
 }
    
    @RequestMapping(value="/file_init",method=RequestMethod.POST)
    @ResponseBody
    public List<OPFile> initFileData(OPFile file){
    	
    	List<OPFile> files = ios.getAllFiles();
    	
		return files;
    	
    }
   
    @RequestMapping(value="/file_download",method=RequestMethod.GET)
    @ResponseBody
    public void downLoadFile(String file_src,HttpServletResponse response){
    	ReturnBody body=new ReturnBody();
    	System.out.println(file_src);
    	String filename = file_src.substring(file_src.lastIndexOf("\\")+1);
    	try {
    		response.setContentType("Content-Type: application/force-download");
			response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
    	File file=new File(file_src);
    	if(!file.exists()){
    		body.setMsg("下载资源已删除");
    	}
    	FileInputStream in=null;
    	try {
			  in=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	OutputStream out=null;
    	try {
			 out=response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	byte buffer[]=new byte[1024];
    	int len=0;
    	try {
			while((len=in.read(buffer))>0)
			out.write(buffer, 0, len);
			System.out.println(file_src);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    	
    }
    
    
    
    
    
 
}
