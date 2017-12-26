package com.bridgelabz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.NotesDao;
import com.bridgelabz.dao.NotesDaoImpl;
import com.bridgelabz.dao.UserDao;
import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;


@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesDao notesDao;
	
	
	@Override
	public void addUserNotes(Notes notes) {
		notesDao.addUserNotes(notes);

	}

	@Override
	public void deleteUserNotes(int id) {
		notesDao.deleteUserNotes(id);
	}

	@Override
	public void modifiedNotes(int id, Notes note) {
		notesDao.modifiedNotes(id, note);

	}

	@Override
	public List<Notes> fetchAllNotes(User user) {
		return notesDao.fetchAllNotes(user);
	}

	@Override
	public Notes fetchById(int id) {
		return notesDao.fetchById(id);
	}

}
