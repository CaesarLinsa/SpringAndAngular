package com.soft.service;

import java.util.List;

import com.soft.entity.OPFile;

public interface IOPFileService {
	
	public void addFile(OPFile opfile);
	
	public List<OPFile> getAllFiles();

}
