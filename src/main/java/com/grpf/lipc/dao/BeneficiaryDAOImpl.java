package com.grpf.lipc.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.grpf.lipc.entities.Beneficiary;
import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;

import com.grpf.lipc.dao.*;
import com.grpf.lipc.service.*;
import com.grpf.lipc.exception.*;
import com.grpf.lipc.controller.*;

@Repository
public class BeneficiaryDAOImpl implements BeneficiaryDAO {

	@PersistenceContext
	private EntityManager em;
	
	

	
	public void addBeneficiary(Beneficiary beneficiary) {
		em.persist(beneficiary);
		
	}

	
	public void deleteBeneficiary(Beneficiary beneficiary) {
		em.remove(beneficiary);
		
	}

	
	public void updateBeneficiary(Beneficiary beneficiary) {
		em.merge(beneficiary);
		
	}
		
	
	public BeneficiaryDAOImpl() {
		super();
	}


@Override
public int findUserIdByEmail(String email) {
	int userId = (int) em.createQuery("SELECT user_id FROM User where User.email = :email").setParameter("email", email).getSingleResult();
	return userId;
}


@Override
public Beneficiary findBeneficiaryById(int beneficiaryId) {
	Beneficiary beneficiary = em.createQuery("SELECT b FROM Beneficiary b where b.beneficiaryId= :beneficiaryId",Beneficiary.class).setParameter("beneficiaryId", beneficiaryId).getSingleResult();
	
	return beneficiary;
}


@Override
public List<Beneficiary> findAllBeneficiary() {
	List<Beneficiary> beneficiary = em.createQuery("select b from Beneficiary b", Beneficiary.class).getResultList();
	return beneficiary;
}


@Override
public Beneficiary findBeneficiaryByUserId(int userId) {
	Beneficiary beneficiary = em.createQuery("SELECT b FROM Beneficiary b where b.user.userId = :userId",Beneficiary.class).setParameter("userId", userId).getSingleResult();
	return beneficiary;
}


@Override
public void deleteBeneficiaryByUserId(int userId) {
	Beneficiary beneficiary = em.createQuery("SELECT b FROM Beneficiary b where b.user.userId = :userId",Beneficiary.class).setParameter("userId", userId).getSingleResult();
	em.remove(beneficiary);
	
}


@Override
public Submission findSubmissionByEmail(String email) {
	List<Submission> sub=em.createQuery("SELECT s FROM Submission s where s.user.email=:email",Submission.class).setParameter("email", email).getResultList();
	return sub.get(sub.size()-1);
}




}
