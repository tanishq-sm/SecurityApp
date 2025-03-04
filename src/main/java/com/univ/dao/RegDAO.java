package com.univ.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.univ.model.RegModel;
@Repository
public class RegDAO {
    @Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveUser(RegModel user) {
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}

	public List checkUser(RegModel user) {
DetachedCriteria dt=(DetachedCriteria)DetachedCriteria.forClass(RegModel.class);
	       dt.add(Restrictions.eq("unm",user.getUnm()));
	       dt.add(Restrictions.eq("pw",user.getPw()));
List<RegModel> lt=(List<RegModel>) this.hibernateTemplate.findByCriteria(dt);
		
		return lt;
	}
}
