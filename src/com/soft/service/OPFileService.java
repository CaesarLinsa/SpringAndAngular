package com.soft.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.dao.IOPFileDao;
import com.soft.entity.OPFile;

@Service
public class OPFileService implements IOPFileService {
    
	@Resource
	private IOPFileDao iopdao;
	 
	@Override
	public void addFile(OPFile opfile) {
		iopdao.addFile(opfile);
}

	@Override
	public List<OPFile> getAllFiles() {
		
		return iopdao.getAllFiles();
		
	}
}