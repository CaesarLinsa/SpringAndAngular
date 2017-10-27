package com.soft.entity;
/**
 * 
 * @author caesar
 * 
 * 上传下载进度监控类
 *
 */

public class Progress {
 
	private long bytesRead;
	
	private long contentLength;
	
	private int items;
	
	public Progress() {
		super();
	}

	public Progress(long bytesRead, long contentLength, int items) {
		super();
		this.bytesRead = bytesRead;
		this.contentLength = contentLength;
		this.items = items;
	}

	public long getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(long bytesRead) {
		this.bytesRead = bytesRead;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public long getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Progress [bytesRead=" + bytesRead + ", contentLength=" + contentLength + ", items=" + items + "]";
	}
	
	
	

}
