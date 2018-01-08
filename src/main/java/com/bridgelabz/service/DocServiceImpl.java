package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.DocDao;

@Service
public class DocServiceImpl implements DocService {

	@Autowired
	private DocDao docDao;
}
