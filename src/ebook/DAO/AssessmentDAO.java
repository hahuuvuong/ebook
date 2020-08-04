package ebook.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ebook.entity.RateAssessment;
@Repository
public class AssessmentDAO implements AssessmentDAOimp{
	@Autowired
	SessionFactory factory;

	@Override
	public List<RateAssessment> getListAssessmentOfTruyen(int idTruyen) {
Session session = factory.getCurrentSession();
		
		String hql = "SELECT e FROM RateAssessment e WHERE e.idTruyen = "+idTruyen;
		Query query = session.createQuery(hql);
		List<RateAssessment> list = query.list();
		
		return list;
	}
}
