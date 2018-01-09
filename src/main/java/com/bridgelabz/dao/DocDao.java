package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.pojo.DocDetails;

public interface DocDao {

	public void saveDetails(DocDetails docDetails);
	
	public List<DocDetails> getAllDetails();
	
	public DocDetails getDetailsById(int id);
}
