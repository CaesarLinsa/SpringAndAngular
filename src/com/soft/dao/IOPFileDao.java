package com.soft.dao;

import java.util.List;

import com.soft.entity.OPFile;

public interface IOPFileDao {
	
public void addFile(OPFile file);

public List<OPFile> getAllFiles();

}
