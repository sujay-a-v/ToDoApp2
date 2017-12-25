package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;
import com.bridgelabz.service.NotesService;


public class NotesDaoImpl implements NotesService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserNotes(Notes notes) {
		System.out.println("Inside add note impl");
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		System.out.println("Session open");
		System.out.println("!@#");
		session.save(notes);
		System.out.println("^%^&%&");
		transaction.commit();
		System.out.println("HGG");
		session.close();
		System.out.println("HWH");
		/*try
		{
			System.out.println("Before");
			session.save(notes);
			transaction.commit();
			session.close();
			System.out.println("After");

		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}*/
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
		System.out.println("\n\nDeepak");
		Session session=sessionFactory.openSession();
		try
		{
			Criteria criteria=session.createCriteria(Notes.class);
			criteria.add(Restrictions.eq("user", user));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Notes> list=criteria.list();
			System.out.println(list.size());
			System.out.println();
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
