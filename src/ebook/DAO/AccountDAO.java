	package ebook.DAO;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ebook.entity.Accounts;

@Repository
public class AccountDAO implements AccountDAOimp  {
	@Autowired
	SessionFactory factory;
	
	@Override
	public boolean checkUsername(String username,String password) {
		Session session = factory.openSession();
		String hql = "FROM Accounts WHERE Username = '"+username+"' AND Password = '"+password+"'";
		Query query = session.createQuery(hql);
		Accounts x = (Accounts) query.uniqueResult();
		if(x!=null) {
			session.close();
		return true;
		}
		session.close();
		return false;
	}
	public String returnNickname(String username) {
		Session session = factory.openSession();
		String hql = "SELECT e.nickname FROM Accounts e WHERE e.Username = '"+username+"'";
		Query query = session.createQuery(hql);
		String nickname = (String)query.uniqueResult();
		session.close();
		return nickname;
	}
	public Accounts returnRole(String username) {
		Session session = factory.openSession();
		
		String hql = "FROM Accounts e WHERE e.Username = '"+username+"'";
		Query query = session.createQuery(hql);
		Accounts x = (Accounts)query.uniqueResult();
		session.close();
		
		return x;
	}
}
