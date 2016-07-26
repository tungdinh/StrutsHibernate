package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import entities.Department;
import entities.Member;
import util.HibernateUtil;

public class MemberModel {
	public ArrayList<Member> getMembers(BigDecimal departmentId) {
		Session session = HibernateUtil.getSession();
		try {
			List list = session.createCriteria(Member.class).add(Restrictions.eq("department.id", departmentId)).list();
			return new ArrayList<Member>(list);
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
	}
	public ArrayList<Member> getMembers(BigDecimal departmentId, String key) {
		Session session = HibernateUtil.getSession();
		try {
			String name = '%' + key + '%';
			String nameYomikata = '%' + key + '%';
			String email = '%' + key + '%';
			String telephone = '%' + key + '%';
			String address = '%' + key + '%';

			List list = session.createCriteria(Member.class).add(Restrictions.and(Restrictions.eq("department.id", departmentId),
					Restrictions.disjunction()
					.add(Restrictions.like("name", name))
                    .add(Restrictions.like("nameYomikata", nameYomikata))
                    .add(Restrictions.like("email", email))
                    .add(Restrictions.like("telephone", telephone)))).list();

			return new ArrayList<Member>(list);
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
	}
    public ArrayList<Department> getDepartments(){
    	Session session = HibernateUtil.getSession();
    	try {
			List list = session.createCriteria(Department.class).list();
			return new ArrayList<Department>(list);
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
    }
}
