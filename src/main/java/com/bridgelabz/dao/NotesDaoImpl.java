package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;
import com.bridgelabz.service.NotesService;

@Component
public class NotesDaoImpl implements NotesDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserNotes(Notes notes) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		try
		{
			session.save(notes);
			transaction.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
	}

	@Override
	public void deleteUserNotes(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifiedNotes(int id, Notes note) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Notes> fetchAllNotes(User user) {
		Session session=sessionFactory.openSession();
		try
		{
			Criteria criteria=session.createCriteria(Notes.class);
			criteria.add(Restrictions.eq("user", user));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Notes> list=criteria.list();
			System.out.println(list.size());
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public Notes fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
