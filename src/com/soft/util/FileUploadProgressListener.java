package com.soft.util;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import com.soft.entity.Progress;

 /**
  * @author caesar
  * 进度实时存放在session中
  *
  */
@Component
public class FileUploadProgressListener implements ProgressListener {

	HttpSession  session;
	

	public void setSession(HttpSession session) {
		this.session = session;
		Progress progress=new Progress();
		session.setAttribute("status", progress);
	}



	@Override
	public void update(long bytesRead, long contentLength, int items) {
	 
		Progress progress = (Progress)session.getAttribute("status");
		
		progress.setBytesRead(bytesRead);
		
		progress.setContentLength(contentLength);
		
		progress.setItems(items);
	}

}
