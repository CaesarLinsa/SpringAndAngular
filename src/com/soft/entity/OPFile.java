package com.soft.entity;

public class OPFile {
	
	private Integer id;
	
	private String filename;
	
	private String filesize;
	
	private Integer file_user_id;
	
	private String  file_src;

	public OPFile() {
		super();
	}

	public OPFile(Integer id, String filename, String filesize, Integer file_user_id,String file_src) {
		super();
		this.id = id;
		this.filename = filename;
		this.filesize = filesize;
		this.file_user_id = file_user_id;
		this.setFile_src(file_src);
	}
   	
	public OPFile(String filename, String filesize, String file_src,Integer file_user_id) {
		super();
		this.filename = filename;
		this.filesize = filesize;
		this.file_user_id = file_user_id;
		this.file_src=file_src;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public Integer getFile_user_id() {
		return file_user_id;
	}

	public void setFile_user_id(Integer file_user_id) {
		this.file_user_id = file_user_id;
	}

	public String getFile_src() {
		return file_src;
	}

	public void setFile_src(String file_src) {
		this.file_src = file_src;
	}

	@Override
	public String toString() {
		return "OPFile [id=" + id + ", filename=" + filename + ", filesize=" + filesize + ", file_user_id="
				+ file_user_id + ", file_src=" + file_src + "]";
	}
	
}
