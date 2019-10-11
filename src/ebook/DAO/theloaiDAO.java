package ebook.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ebook.entity.theloai;

@Repository
public class theloaiDAO implements theloaiDAOimp {
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<theloai> returnTheLoai(){
		Session session = factory.getCurrentSession();
		
		String hql = "FROM theloai";
		Query query = session.createQuery(hql);
		List<theloai> list = query.list();
		
		return list;
	}
	@Override
	public int amountOfTruyen(int idTheLoai) {
		Session session = factory.getCurrentSession();
		
		String hql = "FROM truyen WHERE idTheLoai = " + idTheLoai;
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
}
