package com.bridgelabz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.DocDao;
import com.bridgelabz.pojo.DocDetails;

@Service
public class DocServiceImpl implements DocService {

	@Autowired
	private DocDao docDao;

	@Override
	public void saveDetails(DocDetails docDetails) {
		docDao.saveDetails(docDetails);
		
	}

	@Override
	public List<DocDetails> getAllDetails() {
		return docDao.getAllDetails();
	}

	@Override
	public DocDetails getDetailsById(int id) {
		return docDao.getDetailsById(id);
	}
}
