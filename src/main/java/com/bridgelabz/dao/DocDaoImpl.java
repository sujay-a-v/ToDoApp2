package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.pojo.DocDetails;

@Component
public class DocDaoImpl implements DocDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveDetails(DocDetails docDetails) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		try
		{
			session.save(docDetails);
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
	public List<DocDetails> getAllDetails() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(DocDetails.class);
		List<DocDetails> list=criteria.list();
		System.out.println(list.size());
		return list;
	}

	@Override
	public DocDetails getDetailsById(int id) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(DocDetails.class);
		Criterion criterion=Restrictions.eqOrIsNull("id", id);
		criteria.add(criterion);
		DocDetails docDetails=(DocDetails) criteria.uniqueResult();
		return docDetails;
	}

}
