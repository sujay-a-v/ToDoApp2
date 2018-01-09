package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.pojo.DocDetails;

public interface DocService {

	public void saveDetails(DocDetails docDetails);
	
	public List<DocDetails> getAllDetails();
	
	public DocDetails getDetailsById(int id);
}
