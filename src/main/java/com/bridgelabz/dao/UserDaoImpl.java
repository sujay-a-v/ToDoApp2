package com.bridgelabz.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;


@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try
		{
			System.out.println(user.getUserEmail());
			session.save(user);
			transaction.commit();
			System.out.println("Done");
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}

	}

	@Override
	public List<User> getAllUser() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> list=query.list();
		return list;
	}

	@Override
	public boolean isUserExist(String email) {
		Session session=sessionFactory.openSession();
		try
		{
			Criteria criteria=session.createCriteria(User.class);
			List list=criteria.list();
			for(Iterator itr= list.iterator(); itr.hasNext();)
			{
				User user=(User) itr.next();
				String email1=user.getUserEmail();
				if(email.equals(email1))
				{
					return true;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User checkUserData(String email, String password) {
		try{
			Session session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(User.class);
			Criterion email1=Restrictions.eq("userEmail", email);
			criteria.add(email1);
			User user=(User) criteria.uniqueResult();
			session.close();
				if(BCrypt.checkpw(password, user.getUserPassword()))
				{
					return user;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public User retrieveById(int id) {
		System.out.println("insile Retrn");
		Session session=sessionFactory.openSession();
		System.out.println("open session");
		try
		{
			Criteria criteria=session.createCriteria(User.class);
			System.out.println("open session");
			Criterion id1=Restrictions.eq("id", id);
			criteria.add(id1);
			System.out.println("open session");
			User user=(User) criteria.uniqueResult();
			session.close();
			System.out.println("open session  "+user);
			
			return user;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void activateUser(int id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getByEmail(String email) {
		Session session=sessionFactory.openSession();
		try
		{
			Criteria criteria=session.createCriteria(User.class);
			Criterion email1=Restrictions.eq("userEmail", email);
			criteria.add(email1);
			User user=(User) criteria.uniqueResult();
			session.close();
			return user;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String passwordReset(User user) {
		Session session=sessionFactory.openSession();
		Transaction transaction=null;
		try
		{
			transaction=session.beginTransaction();
			String hql="update User set userPassword=:userPassword where id=:id";
			Query query=session.createQuery(hql);
			query.setParameter("userPassword",user.getUserPassword());
			query.setParameter("id", user.getId());
			query.executeUpdate();
			//session.update(user);
			transaction.commit();
			session.close();
			return "Password set";
		}
		catch (Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}
		return "Password not set";  
	}
	
}
