package ebook.DAO;

import java.util.List;

import ebook.entity.RateAssessment;

public interface AssessmentDAOimp {
	public List<RateAssessment> getListAssessmentOfTruyen(int idTruyen);
}
