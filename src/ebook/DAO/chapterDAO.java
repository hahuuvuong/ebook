package ebook.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ebook.entity.chapter;
import ebook.entity.truyen;

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
	@Override
	public int amountOfChapter(){
		Session session = factory.getCurrentSession();
		String hql = "FROM chapter ";
		Query query = session.createQuery(hql);
		int sl = query.list().size();
		sl = sl-1;
		if(sl <= 12) {
			sl = 1;
		}
		else if ((sl%12)==0) {
			sl = sl/12 ;
		}
		else {
			sl= sl/12 +1 ;
		}
		return sl;
	}
	@Override
	public List<chapter> allChapter(int numPage){
		
		Session session = factory.getCurrentSession();
		
		String hql = "FROM chapter ";
		Query query = session.createQuery(hql);
		query.setFirstResult((numPage-1)*12 + 1);
		query.setMaxResults( 12);
		List<chapter> list = query.list();
		return list;
	}
}
