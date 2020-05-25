package ebook.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ebook.entity.Accounts;
import ebook.entity.truyen;

@Repository
public class AccountDAO implements AccountDAOimp {
	@Autowired
	SessionFactory factory;

	@Override
	public boolean checkUsername(String username, String password) {
		Session session = factory.openSession();
		String hql = "FROM Accounts WHERE Username = '" + username + "' AND Password = '" + password + "'";
		Query query = session.createQuery(hql);
		Accounts x = (Accounts) query.uniqueResult();
		if (x != null) {
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	public Accounts returnAccount(String username) {
		Session session = factory.openSession();
		String hql = "SELECT e FROM Accounts e WHERE e.Username = '" + username + "'";
		Query query = session.createQuery(hql);
		Accounts nickname = (Accounts) query.uniqueResult();
		session.close();
		return nickname;
	}
	public String returnNickname(String username) {
		Session session = factory.openSession();
		String hql = "SELECT e.nickname FROM Accounts e WHERE e.Username = '" + username + "'";
		Query query = session.createQuery(hql);
		String nickname = (String) query.uniqueResult();
		session.close();
		return nickname;
	}

	public Accounts returnRole(String username) {
		Session session = factory.openSession();

		String hql = "FROM Accounts e WHERE e.Username = '" + username + "'";
		Query query = session.createQuery(hql);
		Accounts x = (Accounts) query.uniqueResult();
		session.close();

		return x;
	}

	public int saveFavBook(Accounts acc, truyen truyen) {
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(acc);
			session.saveOrUpdate(truyen);
			t.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
		return 1;
	}

	public List<truyen> returnFavBook(String username) {
		
		Session session = factory.openSession();
		String hql = "SELECT e FROM truyen e JOIN e.accounts r WHERE r.Username = '" + username + "'";
		Query query = session.createQuery(hql);
		List<truyen> list  = query.list();
		session.close();
		return list;
	}
	public void deleteFavBook(String username, int id) {
		
		Session session = factory.openSession();
		String hql = "DELETE FROM favBook WHERE accounts_Username = '" + username + "'" +" AND truyens_idTruyen ="+id+"";
		session.createSQLQuery(hql).executeUpdate();
		session.close();
		
	}
	public List<Accounts> returnListUser(){
		Session session = factory.openSession();
		String hql = "FROM Accounts";
		Query query = session.createQuery(hql);
		List<Accounts> list = query.list();
		session.close();
		return list;
	}
}
