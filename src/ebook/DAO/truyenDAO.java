package ebook.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ebook.entity.truyen;

@Repository
public class truyenDAO implements truyenDAOimp {
	@Autowired
	SessionFactory factory;
	
	@Override
	public truyen returnTruyen(int id) {
		Session session = factory.getCurrentSession();
		
		String hql1 = "SELECT e FROM truyen e WHERE e.idTruyen = "+id;
		Query query1 = session.createQuery(hql1);
		truyen x = (truyen) query1.uniqueResult();
		return x;
	}
	@Override
	public List<truyen> randomTruyen(int soluong){
		Session session = factory.getCurrentSession();
		List<truyen> list = new ArrayList<>();
		for(int i = 0; i<soluong+1;i++) {
			Random rand = new Random();
			int n = rand.nextInt(500);
			
			String hql = "SELECT e FROM truyen e WHERE idTruyen = "+ n;
			Query query = session.createQuery(hql);
			list.add((truyen) query.uniqueResult());
		}
		return list;
	}
	@Override
	public List<truyen> truyenTheoTheLoai(int idTheLoai){
		Session session = factory.getCurrentSession();
		String hql = "SELECT e FROM truyen e WHERE e.idTheLoai = " + idTheLoai;
		Query query = session.createQuery(hql);
		query.setMaxResults(12);
		List<truyen> list = query.list();
		return list;
	}
	@Override
	public List<truyen> truyenTheLoai(int idTheLoai,int numPage){
		Session session = factory.getCurrentSession();
		String hql = "SELECT e FROM truyen e WHERE e.idTheLoai = " + idTheLoai;
		Query query = session.createQuery(hql);

		query.setFirstResult((numPage-1)*12 + 1);
		query.setMaxResults( 12);
		List<truyen> list = query.list();
		return list;
	}
	@Override
	public List<truyen> searchingTruyen(String keywords){
		Session session = factory.getCurrentSession();
		String hql = "SELECT e FROM truyen e WHERE e.TenTruyen LIKE '%"+keywords+"%'";
		Query query = session.createQuery(hql);
		query.setMaxResults( 12);
		List<truyen> list = query.list();
		return list;
	}
}