package ebook.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ebook.entity.chapter;

@Repository
public class chapterDAO implements chapterDAOimp {
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<chapter> returnChapterTruyen(int idTruyen){
		Session session = factory.getCurrentSession();
		
		String hql = "SELECT e FROM chapter e WHERE e.idTruyen = "+idTruyen;
		Query query = session.createQuery(hql);
		List<chapter> list = query.list();

		
		return list;
	}
	@Override
	public chapter returnContentChapter(int idChapter) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT e FROM chapter e WHERE e.idChapter = "+idChapter;
		Query query = session.createQuery(hql);
		chapter x = (chapter) query.uniqueResult();
		
		return x;
	}
	
}
