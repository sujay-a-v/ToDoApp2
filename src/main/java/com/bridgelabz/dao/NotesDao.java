package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;

public interface NotesDao {
	
public void addUserNotes(Notes notes);
	
	public void deleteUserNotes(int id);
	
	public void modifiedNotes(int id,Notes note);
	
	public List<Notes> fetchAllNotes(User user);
	public Notes fetchById(int id);

}
