package com.simpleapi.bussiness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.arjuna.ats.jta.exceptions.RollbackException;
import com.simpleapi.errors.ErrorMessage;
import com.simpleapi.errors.ErrorsEnum;

@Transactional(rollbackOn = RollbackException.class, dontRollbackOn = Exception.class)
public class SearchRN implements Serializable {

	private static final long serialVersionUID = 5501241178256403469L;
	
	@PersistenceContext
	EntityManager em;
	
	public List<ErrorMessage> validateName(String name){
		
		List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
		
		if (name == null)
			errors.add(new ErrorMessage(ErrorsEnum.L001_NULL_NAME));
		
		
		return errors;
	}

	public Long countPeopleByName(String name) {
		
		String hql = "SELECT COUNT(id) FROM Person WHERE nome like :NAME ";
		
		Query query = em.createQuery(hql);
		
		query.setParameter("NAME", "%"+name+"%");
		
		Long count = (Long) query.getSingleResult();
		
		return count;
	}


}
